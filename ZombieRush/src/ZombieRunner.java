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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class ZombieRunner extends Application {
    public static void main(String[] args) {
    	
		StringBuilder sb=new StringBuilder();
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
    	
    	PrintWriter pw=new PrintWriter(new File("highscore.csv"));
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	Text t = new Text(10, 50, "This is a test");
    	t.setFont(new Font(20));

        
        StackPane root = new StackPane();
        root.getChildren().add(t);
        primaryStage.setScene(new Scene(root, 300,300));
        primaryStage.show();
    }
}
