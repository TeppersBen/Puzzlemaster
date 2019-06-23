package engine;

import components.PuzzleTile;

public class GameFieldTileHandler {

    private PuzzleTile[] tiles;
    private int width;

    public GameFieldTileHandler(int width, PuzzleTile... buttons) {
        tiles = buttons;
        this.width = width;
    }

    public void init(int... activeTiles) {
        for (int i : activeTiles) {
            tiles[i].activateTile();
        }

        for (int i = 0; i < tiles.length; i++) {
            final int TILE = i;
            tiles[i].setOnAction(e->{
                tiles[TILE].triggerTile();
                if (TILE-1 >= 0 && TILE%width != 0) {
                    tiles[TILE-1].triggerTile();
                }
                if (TILE+1 < tiles.length && (TILE+1)%width != 0) {
                    tiles[TILE+1].triggerTile();
                }
                if (TILE-width >= 0) {
                    tiles[TILE-width].triggerTile();
                }
                if (TILE+width < tiles.length) {
                    tiles[TILE+width].triggerTile();
                }
                checkFieldCleared();
            });
        }
    }

    private void checkFieldCleared() {
        boolean isCleared = true;
        boolean previousBool = tiles[0].isActive();
        for (PuzzleTile tile : tiles) {
            if (previousBool != tile.isActive()) {
                isCleared = false;
            }
        }
        if (isCleared) {
            //TODO - Navigate the user to the LevelSelection screen
            System.err.println("Game finished! | TODO - Navigate the user to the LevelSelection screen");
        }
    }

}
