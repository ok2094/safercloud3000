package model;

import java.io.File;
import java.io.IOException;

import org.json.JSONObject;


public interface ConnectionInterface {
	public String url=null;
	public void upload(File fileToUpload) throws Exception;
	public File downloadFile();
	public JSONObject downloadData() throws IOException;
	public void delete();
	public boolean sendRegistrationData(String username, int hashOfPW)throws Exception;
	public boolean checkLoginData(String username, int hashofPW)throws Exception;
	
}
