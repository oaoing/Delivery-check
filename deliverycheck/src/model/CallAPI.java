package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class CallAPI {
	private final static String KEY = "5QzfWN1Q6vQe0m0M3Oovgg";
	public static JSONArray callApi(String param) {
		String baseUrl = "http://info.sweettracker.co.kr?t_key=" + KEY;
		JSONArray result = null;
		try {
			URL url = new URL(baseUrl + param);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			
			 int responseCode = conn.getResponseCode();
		        if (responseCode == 200) {
		        	 BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			         StringBuilder sb = new StringBuilder();
			         String line = "";
			         while ((line = br.readLine()) != null) {
			             sb.append(line);
			         }
			         
			         JSONObject responseJson = new JSONObject(sb.toString());
			         result = responseJson.getJSONArray("Company");
		        } else if (responseCode == 404) {
		            System.out.println("404:: response body 의 code 와 메시지 확인 바랍니다");
		        } else if (responseCode == 500) {
		            System.out.println("500:: 서버 에러");
		        } else { 
		        	System.out.println("그 외 오류");
		        }
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
