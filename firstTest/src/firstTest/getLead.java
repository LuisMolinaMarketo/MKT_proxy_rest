package firstTest;

	import java.io.IOException;


public class getLead {

	public static void main(String[] args) {
		try {	
			ConfigLoader loader =  new ConfigLoader("soap.properties");
	    	String SOAPMessageURL = loader.getData("SOAPMessageURL");
	    	String marketoUserId = loader.getData("marketoUserId");
	    	String marketoSecretKey = loader.getData("marketoSecretKey");
	    	String proxyUri = loader.getData("proxyUri");
	    	int proxyPort = Integer.parseInt(loader.getData("proxyPort"));
	    	String proxyUsername = loader.getData("proxyUsername");
	    	String proxyPassword = loader.getData("proxyPassword");
	    	String token = "473fda3e-ae57-4666-9c1b-81c5ee26663d:ab";
			String urlStr="https://363-kzp-741.mktorest.com/rest/v1/lead/12675.json?access_token=" + token;
			httpRequest http = new httpRequest();
			//String response =httpRequest.httpGetProxy(urlStr,proxyUri,proxyPort,proxyUsername,proxyPassword);
			String response =httpRequest.httpGet(urlStr);
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
