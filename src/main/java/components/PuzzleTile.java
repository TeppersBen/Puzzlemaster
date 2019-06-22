package components;

import com.jfoenix.controls.JFXButton;

public class PuzzleTile extends JFXButton {

    public PuzzleTile() {
        deactivateTile();
    }

    public PuzzleTile(String value) {
        super(value);
    }

    public void activateTile() {
        setText("O");
    }

    public boolean isActive() {
        return getText().contains("O");
    }

    public void deactivateTile() {
        setText("X");
    }

    public void triggerTile() {
        if (isActive()) {
            deactivateTile();
        } else {
            activateTile();
        }
    }

}
