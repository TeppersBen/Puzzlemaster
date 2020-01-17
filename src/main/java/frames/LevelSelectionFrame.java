package frames;

import com.jfoenix.controls.JFXButton;
import components.Level;
import engine.FrameHandler;
import interfaces.Frame;
import io.Reader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;

import java.awt.*;
import java.util.List;

public class LevelSelectionFrame extends FlowPane implements Frame {

    private JFXButton[] levelTiles;
    private List<Level> levels;

    public LevelSelectionFrame() {
        initComponents();
        layoutComponents();
        initListeners();
    }

    @Override
    public void initComponents() {
        levels = Reader.getAvailableTileLevels();
        levelTiles = new JFXButton[levels.size()];

        for (int i = 0; i < levelTiles.length; i++) {
            levelTiles[i] = new JFXButton(String.valueOf(i));
        }
    }

    @Override
    public void layoutComponents() {
        getChildren().addAll(levelTiles);
    }

    @Override
    public void initListeners() {
        for (int i = 0; i < levelTiles.length; i++) {
            final int index = i;
            levelTiles[i].setOnAction(e ->
                    FrameHandler.changeFrame(
                            new GameFieldFrame(
                                    levels.get(index).getRows(),
                                    levels.get(index).getColumns(),
                                    levels.get(index).getActiveTiles()
                            )
                    )
            );
        }

    }
}
