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
    	final Rectangle rectBasicTimeline = new Rectangle(510, 0, 50, 50);
    	rectBasicTimeline.setFill(Color.RED);
    	final Timeline timeline = new Timeline();
    	timeline.setCycleCount(1);
    	timeline.setAutoReverse(false);
    	final KeyValue kv = new KeyValue(rectBasicTimeline.yProperty(), 600);
    	final KeyFrame kf = new KeyFrame(Duration.millis(13000), kv);
    	root.getChildren().add(rectBasicTimeline);
    	timeline.getKeyFrames().add(kf);
    	timeline.play();
        stage.setScene(scene);
        stage.show();
        AnimationTimer timer = new AnimationTimer() 
        {
            public void handle(long now) 
            {
                int dx = 0, dy = 0;
                if (goNorth) dy -= 3;
                if (goSouth) dy += 3;
                if (goEast)  dx += 4;
                if (goWest)  dx -= 4;
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
    public static void main(String[] args) 
    { 
    	launch(args); 
    }
}
