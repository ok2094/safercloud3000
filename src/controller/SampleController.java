package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SampleController {

    @FXML
    private Button btnTest;

    @FXML
    private void btnTestAction() throws Exception {
        btnTest.setText("NANI?!");
        KeyGenerator kg = new KeyGenerator();
        kg.generateKey();
    }
}
