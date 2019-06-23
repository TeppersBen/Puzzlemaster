package components;

import com.jfoenix.controls.JFXButton;

public class PuzzleTile extends JFXButton {

    private boolean isActive;

    public PuzzleTile() {
        deactivateTile();
    }

    public void activateTile() {
        isActive = true;
        setStyle("-fx-background-color: RED");
    }

    public boolean isActive() {
        return isActive;
    }

    private void deactivateTile() {
        isActive = false;
        setStyle("-fx-background-color: WHITE");
    }

    public void triggerTile() {
        if (isActive()) {
            deactivateTile();
        } else {
            activateTile();
        }
    }

}
