package frames;

import com.jfoenix.controls.JFXButton;
import components.PuzzleTile;
import engine.GameFieldTileHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class GameFieldFrame extends BorderPane {

    private PuzzleTile[] fieldButtons;
    private GameFieldTileHandler tileHandler;

    public GameFieldFrame(int width, int height, int... activeTiles) {
        createButtonsField(width, height, activeTiles);
    }

    private void createButtonsField(int width, int height, int... activeTiles) {
        fieldButtons = new PuzzleTile[(width * height)];
        for (int i = 0; i < fieldButtons.length; i++) {
            fieldButtons[i] = new PuzzleTile();
            fieldButtons[i].setMinSize(50,50);
            fieldButtons[i].setMaxSize(50,50);
        }
        tileHandler = new GameFieldTileHandler(width, fieldButtons);
        tileHandler.init(activeTiles);
        placeButtonsOnGrid(width, height);
    }

    private void placeButtonsOnGrid(int width, int height) {
        GridPane pane = new GridPane();
        int currentButton = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                pane.add(fieldButtons[currentButton], w, h);
                currentButton++;
            }
        }
        setCenter(pane);
    }

}
