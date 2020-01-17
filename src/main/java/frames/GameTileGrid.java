package frames;

import components.PuzzleTile;
import engine.GameFieldTileHandler;
import interfaces.Frame;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import utils.Settings;

import javax.swing.*;

public class GameTileGrid extends GridPane implements Frame {

    private PuzzleTile[] fieldButtons;
    private GameFieldTileHandler tileHandler;

    private int rows;
    private int columns;
    private int[] activeTiles;

    public GameTileGrid(int rows, int columns, int... activeTiles) {
        this.rows = rows;
        this.columns = columns;
        this.activeTiles = activeTiles;

        initComponents();
        layoutComponents();
        initListeners();
    }

    @Override
    public void initComponents() {
        fieldButtons = new PuzzleTile[(rows * columns)];
        for (int i = 0; i < fieldButtons.length; i++) {
            fieldButtons[i] = new PuzzleTile();
        }
        tileHandler = new GameFieldTileHandler(rows, fieldButtons);
    }

    @Override
    public void layoutComponents() {
        setMinSize(Settings.width,Settings.height);
        setMaxSize(Settings.width, Settings.height);

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

    @Override
    public void initListeners() {
        tileHandler.init(activeTiles);
    }
}
