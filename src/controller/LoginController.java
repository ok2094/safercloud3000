package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	private void loginAction() throws IOException {

		un = userName.getText();
		hashOfPW = password.getText().hashCode();
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/Overview.fxml"));        
        Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("SaferCloud3000");   
        stage.setScene(scene);
        stage.show();
        stage = (Stage) login.getScene().getWindow();
		stage.close();

	}

	@FXML
	private void callRegistrateAction() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/Registrate.fxml"));        
        Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("SaferCloud3000");   
        stage.setScene(scene);
        stage.show();
	}
}
