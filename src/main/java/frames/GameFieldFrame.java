package frames;

import components.PuzzleTile;
import engine.GameFieldTileHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class GameFieldFrame extends BorderPane {

    private PuzzleTile[] fieldButtons;
    private GameFieldTileHandler tileHandler;

    public GameFieldFrame(int rows, int columns, int... activeTiles) {
        setMinSize(700,350);
        setMaxSize(700,350);
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
        GridPane pane = new GridPane();
        int currentButton = 0;
        for (int h = 0; h < columns; h++) {
            for (int w = 0; w < rows; w++) {
                pane.add(fieldButtons[currentButton], w, h);
                currentButton++;
            }
        }

        //TODO - fix this broken bollox
        for (ColumnConstraints constraint : pane.getColumnConstraints()) {
            constraint.setMaxWidth(getMaxWidth());
            constraint.setHgrow(Priority.ALWAYS);
        }
        for (RowConstraints constraint : pane.getRowConstraints()) {
            constraint.setMaxHeight(getMaxHeight());
            constraint.setVgrow(Priority.ALWAYS);
        }

        pane.setAlignment(Pos.CENTER);

        setCenter(pane);
    }

}
