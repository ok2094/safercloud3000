package model;

import java.io.File;

public class Connection implements ConnectionInterface {

	@Override
	public void openConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upload(File fileToUpload) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File downloadFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void downloadData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sendRegistrationData(String username, int hashOfPW) {
		// TODO Auto-generated method stub
		
		return false;
		
	}

	@Override
	public boolean checkLoginData(String username, int hashofPW) {
		// TODO Auto-generated method stub
		return false;
	}

}
