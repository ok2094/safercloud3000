package view;

import java.io.File;

import controller.KeyGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.Connection;
import model.ConnectionInterface;

public class RegistrateController {
	private String un, path;
	private int hashOfPW;

	@FXML
	private Button saveKey, send;
	@FXML
	private TextField userName, pathForKey;
	@FXML
	private PasswordField password;

	@FXML
	private void saveKeyAction() {

		final DirectoryChooser dc = new DirectoryChooser();
		Stage s = new Stage();
		dc.setTitle("Wo soll der Schlüssel gespeichert werden?");
		File dir = dc.showDialog(s);
		if (dir != null) {
			pathForKey.setText(dir.getAbsolutePath());
		} else {
			pathForKey.setText(null);
		}
	}

	@FXML
	private void sendAction() throws Exception {

		un = userName.getText();
		hashOfPW = password.getText().hashCode();
		path = pathForKey.getText();
		ConnectionInterface c = new Connection();
		if (c.sendRegistrationData(un, hashOfPW)) {
			KeyGenerator kg = new KeyGenerator();
			kg.generateKey(path);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("SaferCloud3000");
			alert.setContentText("Registrieren war erfolgreich!");
			alert.showAndWait();
			Stage stage = (Stage) send.getScene().getWindow();
			stage.close();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("SaferCloud3000");
			alert.setContentText("Fehlschlag versuchen Sie es erneut!");
			alert.showAndWait();

		}
	}
}
