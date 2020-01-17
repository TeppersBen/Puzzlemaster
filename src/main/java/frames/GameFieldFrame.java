package frames;

import com.jfoenix.controls.JFXButton;
import engine.FrameHandler;
import interfaces.Frame;
import javafx.scene.layout.BorderPane;

public class GameFieldFrame extends BorderPane implements Frame {

    private GameTileGrid gameTileGrid;
    private JFXButton backButton;

    private int rows;
    private int columns;
    private int[] activeTiles;

    public GameFieldFrame(int rows, int columns, int... activeTiles) {
        this.rows = rows;
        this.columns = columns;
        this.activeTiles = activeTiles;

        initComponents();
        layoutComponents();
        initListeners();
    }

    @Override
    public void initComponents() {
        gameTileGrid = new GameTileGrid(rows, columns, activeTiles);
        backButton = new JFXButton("<<");
    }

    @Override
    public void layoutComponents() {
        setTop(backButton);
        setCenter(gameTileGrid);
    }

    @Override
    public void initListeners() {
        backButton.setOnAction(e->{
            FrameHandler.changeFrame(new LevelSelectionFrame());
        });
    }

}
