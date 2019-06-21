import frames.GameFieldFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("PuzzleMaster");
        stage.setScene(new Scene(new GameFieldFrame(10, 5)));
        stage.setResizable(false);
        stage.show();
    }
}
