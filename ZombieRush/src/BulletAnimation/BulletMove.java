package BulletAnimation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BulletMove extends Application 
{
	private static final double W = 800, H = 560;
    private Image heroImage;
    private Node  hero;
    boolean running, goNorth, goSouth, goEast, goWest;
    @Override
    public void start(Stage stage) throws Exception 
    {
    	hero = new ImageView(heroImage);
    	BorderPane root = new BorderPane();
    	Pane map = new Pane(hero);
    	root.getChildren().add(map);
    	moveHeroTo(W / 2, H / 2);
    	Scene scene = new Scene(root, W, H);
    	final Rectangle rectBasicTimeline = new Rectangle(400, 280, 50, 50);
    	Circle c = new Circle();
    	c.setCenterX(550.0f); 
        c.setCenterY(0.0f); 
        c.setRadius(30.0f); 
        c.setFill(Color.BLUE);
    	rectBasicTimeline.setFill(Color.RED);
    	final Timeline timeline = new Timeline();
    	timeline.setCycleCount(1);
    	timeline.setAutoReverse(false);
    	final KeyValue kv = new KeyValue(rectBasicTimeline.yProperty(), 600);
    	final KeyFrame kf = new KeyFrame(Duration.millis(10000), kv);
    	final KeyValue ab = new KeyValue(c.centerYProperty(),400);
    	final KeyFrame ac = new KeyFrame(Duration.millis(1000), ab);
    	root.getChildren().add(rectBasicTimeline);
    	root.getChildren().add(c);
    	timeline.getKeyFrames().add(kf);
    	timeline.getKeyFrames().add(ac);
    	timeline.play();
        stage.setScene(scene);
        stage.show();
        AnimationTimer timer = new AnimationTimer() 
        {
            public void handle(long now) 
            {
                int dx = 0, dy = 0;
                moveHeroBy(dx, dy);
            }
        };
        timer.start();
    }
    private void moveHeroBy(int dx, int dy) 
    {
        if (dx == 0 && dy == 0) 
        	return;
        final double cx = hero.getBoundsInLocal().getWidth()  / 2;
        final double cy = hero.getBoundsInLocal().getHeight() / 2;
        double x = cx + hero.getLayoutX() + dx;
        double y = cy + hero.getLayoutY() + dy;
        moveHeroTo(x, y);
    }
    private void moveHeroTo(double x, double y) 
    {
        final double cx = hero.getBoundsInLocal().getWidth()  / 2;
        final double cy = hero.getBoundsInLocal().getHeight() / 2;
        if (x - cx >= 0 && x + cx <= W &&  y - cy >= 0 && y + cy <= H) 
        {
            hero.relocate(x - cx, y - cy);
        }
    }
    public void spawnzombie(double x, double y)
    {
    	y = 0;
    	x = randomWithRange(0, 500);
    	final Rectangle zombie = new Rectangle(400, 280, 50, 50);
    	zombie.setFill(Color.GREEN);
    }
    public static void main(String[] args) 
    { 
    	launch(args); 
    }
    public int randomWithRange(int min, int max)
    {
    	int range = (max - min) + 1;     
    	return (int)(Math.random() * range) + min;
    }
}
