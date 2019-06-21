package frames;

import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class GameFieldFrame extends BorderPane {

    private JFXButton[] fieldButtons;

    public GameFieldFrame(int width, int height) {
        createButtonsField(width, height);
    }

    private void createButtonsField(int width, int height) {
        fieldButtons = new JFXButton[(width * height)];
        for (int i = 0; i < fieldButtons.length; i++) {
            fieldButtons[i] = new JFXButton(String.valueOf(i));
            fieldButtons[i].setMinSize(50,50);
            fieldButtons[i].setMaxSize(50,50);
        }
        placeButtonsOnGrid(width, height);
    }

    private void placeButtonsOnGrid(int width, int height) {
        GridPane pane = new GridPane();
        int currentButton = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                pane.add(fieldButtons[currentButton], w, h);
                currentButton++;
            }
        }
        setCenter(pane);
    }

}
