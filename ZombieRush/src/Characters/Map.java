package Characters;

import javax.swing.JFrame;
public class Map extends JFrame{
	public static final int width = 700;
	public static final int height = 700;
	public Map()
	{
		add(new Board());

	      setTitle("rotate me please");
	      setSize(WIDTH, HEIGHT);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setResizable(true);
	      setVisible(true);

	   }

	   public static void main(String[] args) 
	   {
		   new Map();
		 }
	   
}
	

