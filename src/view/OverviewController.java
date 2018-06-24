package view;

import java.io.File;

import controller.CryptoUtils;
import controller.KeyGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OverviewController {
	final FileChooser fc = new FileChooser();
	
	@FXML
	private Button upload, download, delete, refresh;
	
	@FXML
	private void uploadAction() throws Exception {
		Stage stage = new Stage();
		File key = fc.showOpenDialog(stage);
		KeyGenerator kg = new KeyGenerator();
		String keyString =kg.getKey(key);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("SaferCloud3000");
		alert.setContentText("Schlüssel Ausgewählt! \n weiter um Datei auszuwählen");
		alert.showAndWait();
		File fileToUpload = fc.showOpenDialog(stage);
		File outputFile=null;
		CryptoUtils cu = new CryptoUtils();
		cu.encrypt(keyString, fileToUpload, outputFile);
		
	}
	
	@FXML
	private void downloadAction() {
		Stage stage2 = new Stage();
		File key = fc.showOpenDialog(stage2);
		
		
	}

}
