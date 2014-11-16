package firstTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class httpRequest {
	public static String httpGet(String urlStr) throws IOException {
		
		URL url = new URL(urlStr);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (((HttpURLConnection) conn).getResponseCode() != 200) {
		    throw new IOException(((HttpURLConnection) conn).getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  ((HttpURLConnection) conn).disconnect();
		  return sb.toString();
		}
	public static String httpGetProxy(String urlStr,String proxyUri, int proxyPort, String proxyUsername,String  proxyPassword) throws IOException {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUri, proxyPort));
		URLConnection conn = new URL(urlStr).openConnection(proxy);
		
		  if (((HttpURLConnection) conn).getResponseCode() != 200) {
		    throw new IOException(((HttpURLConnection) conn).getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  ((HttpURLConnection) conn).disconnect();
		  return sb.toString();
		}
}
