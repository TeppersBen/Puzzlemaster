package engine;

import frames.LevelSelectionFrame;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Settings;

public class FrameHandler {

    public static Stage parent;
    public static Scene levelSelectionFrame = new Scene(new LevelSelectionFrame(), Settings.width, Settings.height);

}
