package view;

import java.io.IOException;

import controller.KeyGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Connection;
import model.ConnectionInterface;

public class LoginController {
	private String un;
	private int hashOfPW;

	KeyGenerator makeKey = new KeyGenerator();
	@FXML
	private Button login, callRegistrate;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField password;

	@FXML
	private void loginAction() throws Exception {

		un = userName.getText();
		hashOfPW = password.getText().hashCode();
		ConnectionInterface c = new Connection();
		if (c.checkLoginData(un, hashOfPW)) {

			Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Overview.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			stage.setTitle("SaferCloud3000");
			stage.setScene(scene);
			stage.show();
			stage = (Stage) login.getScene().getWindow();
			stage.close();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("SaferCloud3000");
			alert.setContentText("Benutzerangaben falsch!");
			alert.showAndWait();
		}

	}

	@FXML
	private void callRegistrateAction() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("Registrate.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("SaferCloud3000");
		stage.setScene(scene);
		stage.show();
	}
}
