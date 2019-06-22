package components;

import com.jfoenix.controls.JFXButton;

public class PuzzleTile extends JFXButton {

    private boolean isActive;

    public PuzzleTile() {
        deactivateTile();
    }

    public void activateTile() {
        isActive = true;
        setStyle("-fx-background-color: WHITE");
    }

    private boolean isActive() {
        return isActive;
    }

    private void deactivateTile() {
        isActive = false;
        setStyle("-fx-background-color: BLACK");
    }

    public void triggerTile() {
        if (isActive()) {
            deactivateTile();
        } else {
            activateTile();
        }
    }

}
