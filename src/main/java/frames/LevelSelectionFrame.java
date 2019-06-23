package frames;

import com.jfoenix.controls.JFXButton;
import components.TileLevel;
import engine.FrameHandler;
import io.Reader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.List;

public class LevelSelectionFrame extends FlowPane {

    private JFXButton[] levelTiles;

    public LevelSelectionFrame() {
        initAvailableLevels();
        createLevelSelectionGrid();
    }

    private void initAvailableLevels() {
        List<TileLevel> levels = Reader.getAvailableTileLevels();
        levelTiles = new JFXButton[levels.size()];

        for (int i = 0; i < levelTiles.length; i++) {
            levelTiles[i] = new JFXButton(String.valueOf(i));
            final int index = i;
            levelTiles[i].setOnAction(e -> {
                FrameHandler.parent.setScene(
                        new Scene(
                                new GameFieldFrame(
                                        levels.get(index).getRows(),
                                        levels.get(index).getColumns(),
                                        levels.get(index).getActiveTiles()
                                )
                        )
                );
            });
        }
    }

    private void createLevelSelectionGrid() {
        getChildren().addAll(levelTiles);
    }
}
