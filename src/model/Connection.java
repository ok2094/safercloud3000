package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import controller.JSONController;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Connection implements ConnectionInterface {

	public String url = "http://192.168.1.160:3000";
	public String token = "0";

	@Override
	public void upload(File fileToUpload) throws Exception {
//		String charset = "UTF-8";
//		String boundary = Long.toHexString(System.currentTimeMillis());
//		String CRLF = "\r\n";
//
//		URLConnection connection = new URL(url + "/api/file").openConnection();
//		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
//		connection.setDoOutput(true);
//		OutputStream output = connection.getOutputStream();
//		PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
//		
//		
//		writer.append("--" + boundary).append(CRLF);
//		writer.append("Content-Disposition: form-data; name=\"textFile\"; filename=\"" + fileToUpload + "\"")
//				.append(CRLF);
//		writer.append("Content-Type: text/plain; charset=" + charset).append(CRLF); // Text file itself must be saved in
//																					// this charset!
//		writer.append(CRLF).flush();
//		Files.copy(fileToUpload.toPath(), output);
//		output.flush(); // Important before continuing with writer!
//		writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.
//		int responseCode = ((HttpURLConnection) connection).getResponseCode();
//		System.out.println(responseCode); 
		
		  final MediaType MEDIA_TYPE = MediaType.parse("multipart/form-data");

		  final OkHttpClient client = new OkHttpClient();
		  
		  RequestBody requestBody = new MultipartBody.Builder()
			        .setType(MultipartBody.FORM)
			        .addFormDataPart("ufile", "logo-square.png", RequestBody.create(MEDIA_TYPE, new File("tempUpload.txt")))
			        .build();

			    Request request = new Request.Builder()
			        .header("token", token)
			        .url(url + "/api/file")
			        .post(requestBody)
			        .build();

			    try (Response response = client.newCall(request).execute()) {
			      if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

			      System.out.println(response.body().string());
			    }
		 
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
	public boolean sendRegistrationData(String username, int hashOfPW) throws Exception {

		URL serverConnection = new URL(
				url + "/api/user" + "?username=" + username + "&cryptokey=dkjsöflj&password=" + hashOfPW);
		HttpURLConnection con = (HttpURLConnection) serverConnection.openConnection();
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		con.setRequestProperty("origin", "safercloudclient");
		con.setRequestMethod("POST");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		JSONController jc = new JSONController();
		String jsonText = jc.readAll(in);
		JSONObject json = new JSONObject(jsonText);
		
		if (json.getString("status").equalsIgnoreCase("created")) {
			return true;
		}

		else {

			return false;
		}
	}

	@Override
	public boolean checkLoginData(String username, int hashOfPW) throws Exception {
		URL serverConnection = new URL(url + "/api/user/login" + "?username=" + username + "&password=" + hashOfPW);
		HttpURLConnection con = (HttpURLConnection) serverConnection.openConnection();
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		con.setRequestProperty("origin", "safercloudclient");
		con.setRequestMethod("POST");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		JSONController jc = new JSONController();
		String jsonText = jc.readAll(in);
		JSONObject json = new JSONObject(jsonText);
		token = json.getString("token");
		System.out.println(json);
		if (json.getString("status").equalsIgnoreCase("ok")) {
			return true;
		}

		else {

			return false;
		}
	}

}
