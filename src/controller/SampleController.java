package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SampleController {

    @FXML
    private Button btnTest;

    @FXML
    private void btnTestAction() {
        btnTest.setText("NANI?!");
    }
}
