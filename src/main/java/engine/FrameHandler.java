package engine;

import frames.LevelSelectionFrame;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FrameHandler {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 350;

    public static Stage parent;
    public static Scene levelSelectionFrame = new Scene(new LevelSelectionFrame(), WIDTH, HEIGHT);
}
