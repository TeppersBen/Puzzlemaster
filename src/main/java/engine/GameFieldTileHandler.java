package engine;

import com.jfoenix.controls.JFXButton;
import components.PuzzleTile;

public class GameFieldTileHandler {

    private PuzzleTile[] tiles;
    private int width;
    private int height;

    public GameFieldTileHandler(int width, int height, PuzzleTile... buttons) {
        tiles = buttons;
        this.width = width;
        this.height = height;
    }

    public void init(int... activeTiles) {
        for (int i : activeTiles) {
            tiles[i].activateTile();
        }

        for (int i = 0; i < tiles.length; i++) {
            final int tile = i;
            tiles[i].setOnAction(e->{
                tiles[tile].triggerTile();
                if (tile-1 >= 0) {
                    tiles[tile-1].triggerTile();
                }
                if (tile+1 < tiles.length) {
                    tiles[tile+1].triggerTile();
                }
                if (tile-width >= 0) {
                    tiles[tile-width].triggerTile();
                }
                if (tile+width < tiles.length) {
                    tiles[tile+width].triggerTile();
                }
            });
        }
    }

}
