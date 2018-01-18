import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.stage.Stage;

public abstract class ZombieRunner extends Application{

	public static void ZombieRunner(String[] args) throws IOException {
		//
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
    	
    	PrintWriter pw=new PrintWriter(new File("results.csv"));
    	launch(args);
	}
	public void start(Stage primaryStage)
	{
		
	}
}
