package model;

import java.io.File;


public interface ConnectionInterface {

	public void openConnection();
	public void closeConnection();
	public void upload(File fileToUpload);
	public File downloadFile();
	public void downloadData();
	public void delete();
	public boolean sendRegistrationData(String username, int hashOfPW);
	public boolean checkLoginData(String username, int hashofPW);
	
}
