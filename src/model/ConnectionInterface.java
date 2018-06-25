package model;

import java.io.File;


public interface ConnectionInterface {
	public String url=null;
	public void upload(File fileToUpload) throws Exception;
	public File downloadFile();
	public void downloadData();
	public void delete();
	public boolean sendRegistrationData(String username, int hashOfPW)throws Exception;
	public boolean checkLoginData(String username, int hashofPW)throws Exception;
	
}
