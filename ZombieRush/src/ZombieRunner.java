import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import Characters.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
 //Yiren,Derek,leon,hoilam
public class ZombieRunner extends Application {
	
	Scene SceneMenu, SceneShop, SceneGame, SceneSave, SceneLoad;
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
    public void start(Stage primaryStage) {
    	
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
    	
    	startpg.getChildren().addAll(btnstart,btnsave,btnload,btnshop); 
    	
    	SceneMenu = new Scene(startpg,500,500);
    	//****************SCENE MENU*****************************
    	//
    	
    	
    	// ****************SCENE GAME*****************************
    	Pane game=new Pane();
    	game.setStyle("-fx-background-color: BLACK;");
    	Player player = new Player(100,250,250,1,0,"uu");
    	
    	Rectangle rect = new Rectangle(10,50, Color.RED);
        rect.setX(245);
    	rect.setY(250);
        rect.getTransforms().add(new Rotate(45,245,250)); 
        game.getChildren().add(rect);
        
        Circle c1 = new Circle(250,250,20);
    	c1.setFill(Color.WHITE);
    	game.getChildren().add(c1);
    	
    	SceneGame = new Scene(game,500,500);
    	/*
    	// button actions
    	btnstart.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {    	        
    	        primaryStage.setScene(new Scene(game, 500,500));
    	        primaryStage.show();
    	        game.setOnMouseEntered( entered->
    	        {
    	        	rect
    	        });
    		}
    	});
    	// end button actions
    	 */
    	//****************SCENE GAME*****************************
    	
    	//****************SCENE SHOP*****************************
    		StackPane scenePane = new StackPane();
    	    
    	 	VBox vbox1 = new VBox(100);
    	    vbox1.setPadding(new Insets(20));

    	    Button btnmenu = new Button("MENU");
    	    btnmenu.setOnAction(e->primaryStage.setScene(SceneMenu));
    	    btnmenu.setTranslateY(0);
    	    btnmenu.setFont(Font.loadFont("file:WarWound.otf",40));
    	    btnmenu.setStyle("-fx-padding:5;");
    	    
    	    Rectangle r1 = new Rectangle(10, 10);
    	    Rectangle r2 = new Rectangle(10, 10);
    	    Rectangle r3 = new Rectangle(10, 10);
    	    Rectangle r4 = new Rectangle(10, 10);

    	    vbox1.getChildren().addAll(btnmenu,r1, r2, r3, r4);
    	    scenePane.getChildren().addAll(vbox1);
    	    
    	   // HBox.setMargin(r1, new Insets(80, 85, 82, 82));
    	    
    	    SceneShop = new Scene(scenePane, 500, 500);
    	//****************SCENE SHOP*****************************
    	    
    	//PRIMARY STAGE
        primaryStage.setScene(SceneMenu);
        primaryStage.show();
    }
    
    /*
    private double computeAngle( final Point2D v, final Point2D a, final Point2D b )
    {
      final double angle1 = Math.atan2( v.getY() - a.getY(), v.getX() - a.getX() );
      final double angle2 = Math.atan2( v.getY() - b.getY(), v.getX() - b.getX() );
      return (angle1 - angle2) / Math.PI * 180;
    }
    */
}
