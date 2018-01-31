import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Control;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class ZombieRunner extends Application {
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
    	StackPane root = new StackPane();
    	Button btnstart = new Button("PLAY");
    	btnstart.setTranslateY(0);
    	btnstart.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnstart.setStyle("-fx-padding:5;");
    	root.getChildren().add(btnstart);
    	
    	Button btnsave = new Button("SAVE");
    	btnsave.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnsave.setTranslateY(60);
    	btnsave.setStyle("-fx-padding:5;");
    	root.getChildren().add(btnsave); 
    	
    	Button btnload = new Button("LOAD");
    	btnload.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnload.setStyle("-fx-padding:5;");
    	btnload.setTranslateY(120);
    	root.getChildren().add(btnload); 

    	Button btnshop = new Button("SHOP");
    	btnshop.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnshop.setStyle("-fx-padding:5;");
    	btnshop.setTranslateY(180);
    	root.getChildren().add(btnshop); 
    	
        primaryStage.setScene(new Scene(root, 500,500));
        primaryStage.show();
    }
}
