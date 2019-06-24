package frames;

import components.PuzzleTile;
import engine.GameFieldTileHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import utils.Settings;

public class GameFieldFrame extends GridPane {

    private PuzzleTile[] fieldButtons;
    private GameFieldTileHandler tileHandler;

    public GameFieldFrame(int rows, int columns, int... activeTiles) {
        setMinSize(Settings.width,Settings.height);
        setMaxSize(Settings.width, Settings.height);
        createButtonsField(rows, columns, activeTiles);
    }

    public void createButtonsField(int rows, int columns, int... activeTiles) {
        fieldButtons = new PuzzleTile[(rows * columns)];
        for (int i = 0; i < fieldButtons.length; i++) {
            fieldButtons[i] = new PuzzleTile();
        }
        tileHandler = new GameFieldTileHandler(rows, fieldButtons);
        tileHandler.init(activeTiles);
        placeButtonsOnGrid(rows, columns);
    }

    private void placeButtonsOnGrid(int rows, int columns) {
        int currentButton = 0;
        for (int h = 0; h < columns; h++) {
            for (int w = 0; w < rows; w++) {
                add(fieldButtons[currentButton], w, h);
                currentButton++;
            }
        }

        //TODO - fix this broken bollox
        for (ColumnConstraints constraint : getColumnConstraints()) {
            constraint.setMaxWidth(getMaxWidth());
            constraint.setHgrow(Priority.ALWAYS);
        }
        for (RowConstraints constraint : getRowConstraints()) {
            constraint.setMaxHeight(getMaxHeight());
            constraint.setVgrow(Priority.ALWAYS);
        }

        setAlignment(Pos.CENTER);
    }

}
