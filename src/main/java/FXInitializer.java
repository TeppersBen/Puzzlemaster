import engine.FrameHandler;
import frames.GameFieldFrame;
import frames.LevelSelectionFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        FrameHandler.parent = stage;
        stage.setTitle("PuzzleMaster");
        stage.setScene(new Scene(new LevelSelectionFrame(), 700, 350));
        stage.setResizable(false);
        stage.show();
    }
}
