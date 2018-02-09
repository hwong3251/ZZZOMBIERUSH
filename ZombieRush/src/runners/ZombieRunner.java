package runners;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import Characters.Player;
import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
 //Yiren,Derek,leon,hoilam
public class ZombieRunner extends Application {
	
	Scene SceneMenu, SceneShop, SceneGame, SceneSave, SceneLoad;
	private double previousangle;
	private boolean playing=false;
	
    public static void main(String[] args) throws IOException {
	    	
		/*StringBuilder sb=new StringBuilder();
		System.out.println("High Score List");  	
    	String csvFile ="highscore.csv";
    	BufferedReader br = null;
    	br = new BufferedReader(new FileReader(csvFile));
    	String line="";
    	
    	while ((line = br.readLine()) != null)
    	{
            // use comma as separator
    		 String[] board = line.split(",");
             System.out.println(board[0]+ "  "+board[1]);
            sb.append(board[0]+ ","+board[1]+"\n");
        }
    	//
    	PrintWriter pw=new PrintWriter(new File("highscore.csv"));*/
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    	
    	//****************SCENE MENU*****************************
    	StackPane startpg = new StackPane();
    	
    	Button btnstart = new Button("PLAY");
    	btnstart.setOnAction(e->primaryStage.setScene(SceneGame));
    	btnstart.setTranslateY(0);
    	btnstart.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnstart.setStyle("-fx-padding:5;");
    	
    	Button btnsave = new Button("SAVE");
    	//btnsave.setOnAction(e->primaryStage.setScene(SceneSave));
    	btnsave.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnsave.setTranslateY(60);
    	btnsave.setStyle("-fx-padding:5;");
    	
    	Button btnload = new Button("LOAD");
    	//btnload.setOnAction(e->primaryStage.setScene(SceneLoad));
    	btnload.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnload.setStyle("-fx-padding:5;");
    	btnload.setTranslateY(120);

    	Button btnshop = new Button("SHOP");
    	btnshop.setOnAction(e->primaryStage.setScene(SceneShop));
    	btnshop.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnshop.setStyle("-fx-padding:5;");
    	btnshop.setTranslateY(180);
    	
    	   
        FileInputStream input = new FileInputStream("camo.jpg");
        Image Image = new Image(input);
        ImageView camo = new ImageView(Image);
        camo.setFitHeight(500);
        camo.setFitWidth(500);
        startpg.getChildren().addAll(camo,btnstart,btnsave,btnload,btnshop); 
    
    	SceneMenu = new Scene(startpg,500,500);
    	// ****************SCENE GAME*****************************
    	Pane game=new Pane();
    	game.setStyle("-fx-background-color: BLACK;");
    	Player player = new Player(100,250,250,1,0,1,0);
    	
    	Line line = new Line(); 
    	line.setStartX(500); 
    	line.setStartY(0); 
    	line.setEndX(500); 
    	line.setEndY(500);
    	line.setStroke(Color.AQUA);
    	line.setStrokeWidth(5);
    	
    	
    	Button btnpause = new Button("Pause");
        btnpause.setOnAction(e->
        {
        	//stop the game 
        });
        btnpause.setFont(Font.loadFont("file:WarWound.otf",30));
        btnpause.setStyle("-fx-padding:5;");
        btnpause.setTranslateX(530);
        btnpause.setTranslateY(100);
        
        Button btngameshop = new Button("SHOP");
    	btngameshop.setOnAction(e->primaryStage.setScene(SceneShop));
    	btngameshop.setFont(Font.loadFont("file:WarWound.otf",30));
    	btngameshop.setStyle("-fx-padding:5;");
    	btngameshop.setTranslateX(537);
    	btngameshop.setTranslateY(200);
    	
    	Rectangle rect = new Rectangle(50,10, Color.RED);
        rect.setX(245);
    	rect.setY(245);
        
        Circle c1 = new Circle(250,250,20);
    	c1.setFill(Color.WHITE);
    	game.getChildren().addAll(rect,c1,btnpause,btngameshop,line);
    	
    	SceneGame = new Scene(game,650,500);
    	
    	btnstart.setOnAction(new EventHandler<ActionEvent>() 
    	{
    		public void handle(ActionEvent e)
    		{    	        
    	        primaryStage.setScene(SceneGame);
    	        primaryStage.show();
    	        /*following code is modified from
    	         * https://gist.github.com/bugabinga/9636541
    	         */
    	        game.setOnMouseMoved(moved ->
    	        {
    	        	if(moved.getX()<=500)
    	        	{
    	        	Point2D mousepoint= new Point2D(moved.getX(), moved.getY());
    	        	double anglemove=computeAngle(mousepoint);

    	        	previousangle=anglemove;
    	        	rect.getTransforms().clear();
    	        	rect.getTransforms().add(new Rotate(anglemove,250,250));
    	        	}
    	        });
    		}
    	});
    	// ****************SCENE SAVE*****************************
    	
    	// ****************SCENE LOAD*****************************
    	
    	//****************SCENE_SHOP*****************************
	    Image auto = new Image("Auto.png");
			ImageView iAuto = new ImageView();
			iAuto.setImage(auto);
		Image boomerang = new Image("Boomerang.png");
	    	ImageView iBoomerang = new ImageView();
	        iBoomerang.setImage(boomerang);
		Image click = new Image("Click.png");
	    	ImageView iClick = new ImageView();
	        iClick.setImage(click);
		Image poison = new Image("Poison.png");
	    	ImageView iPoison = new ImageView();
	        iPoison.setImage(poison);
		Image spear = new Image("Spear.png");
	    	ImageView  iSpear = new ImageView();
	        iSpear.setImage(spear);
		Image best = new Image("Best.png");
	    	ImageView iBest = new ImageView();
	        iBest.setImage(best);
	        
	        ImageView[] weaponimage = new ImageView[6];
	        weaponimage[0] = iAuto;
	        weaponimage[1] = iBoomerang;
	        weaponimage[2] = iClick;
	        weaponimage[3] = iPoison;
	        weaponimage[4] = iSpear;
	        weaponimage[5] = iBest;
	        
	        VBox vbox4 = new VBox(20);
	        vbox4.setAlignment(Pos.CENTER);
	        vbox4.setStyle("-fx-border-style: dotted;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
	        
	        for(int i = 0; i < weaponimage.length; i++)
	        {
	        	weaponimage[i].setFitWidth(50);
	        	weaponimage[i].setPreserveRatio(true);
	            weaponimage[i].setSmooth(true);
	            weaponimage[i].setCache(true);
	            vbox4.getChildren().add(weaponimage[i]);
	        }
	        
	    	HBox hbox = new HBox(50);
	        hbox.setAlignment(Pos.CENTER); // default TOP_LEFT
	        
	        VBox vbox1 = new VBox(20);
	        vbox1.setAlignment(Pos.CENTER);
	        vbox1.setStyle("-fx-border-style: dotted;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
	        
	        VBox vbox2 = new VBox(20);
	        vbox2.setAlignment(Pos.CENTER);
	        vbox2.setStyle("-fx-border-style: dotted;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
	        
	        VBox vbox3 = new VBox(20);
	        vbox3.setAlignment(Pos.CENTER);
	        vbox3.setStyle("-fx-border-style: dotted;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: black");
	        
	       
	        
	        Button btnmenu = new Button("MENU");
	        btnmenu.setOnAction(e->primaryStage.setScene(SceneMenu));
	        btnmenu.setTranslateY(0);
	        btnmenu.setFont(Font.loadFont("file:WarWound.otf",30));
	        btnmenu.setStyle("-fx-padding:5;");
	        
	        for (int i = 0; i < 3; i++)
	        {
	            Button bt = new Button("Buy " );
	            Button bt2 = new Button("Buy "); 
	            Button bt3 = new Button("Buy ");
	
	            vbox1.getChildren().add(bt);
	            vbox2.getChildren().add(bt2);
	            vbox3.getChildren().add(bt3);
	        }
	        
	        
	        hbox.getChildren().addAll(vbox1, vbox2, vbox3, vbox4, btnmenu);
	        
	        SceneShop = new Scene(hbox,500,500);
    	//****************SCENE SHOP*****************************
    	    
    	//PRIMARY STAGE
        primaryStage.setScene(SceneMenu);
        primaryStage.show();
        primaryStage.setTitle("ZombieRush");
    }  
    private double computeAngle( final Point2D a )
    {
      final double angle1 = Math.toDegrees(Math.atan2(-(a.getX()-250), a.getY()-250));
      return angle1+90;
    }
}
