import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class ZombieRunner extends Application {
    public static void main(String[] args) {
    	
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
    	*/
    	//PrintWriter pw=new PrintWriter(new File("highscore.csv"));
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	StackPane root = new StackPane();
    	
    	Text t = new Text("PLAY");
    	t.setTranslateY(0);
    	t.setFont(Font.loadFont("file:WarWound.otf",40));
    	t.setFill(Color.RED);
    	root.getChildren().add(t);
    	
    	Text t1 = new Text("SAVE");
    	t1.setFont(Font.loadFont("file:WarWound.otf",40));
    	
    	t1.setTranslateY(50);
    	root.getChildren().add(t1); 
    	
    	Text t2 = new Text("LOAD");
    	t2.setFont(Font.loadFont("file:WarWound.otf",40));
    	t2.setTranslateY(100);
    	root.getChildren().add(t2); 

    	Text t3 = new Text("HIGHSCORES");
    	t3.setFont(Font.loadFont("file:WarWound.otf",40));
    	t3.setTranslateY(150);
    	root.getChildren().add(t3); 
    	
        primaryStage.setScene(new Scene(root, 500,500));
        primaryStage.show();
    }
}
