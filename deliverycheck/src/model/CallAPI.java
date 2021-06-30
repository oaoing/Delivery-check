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
	/*
	 * api �ּ�
	 * �ù�� ��ȸ - /api/v1/companylist(t_key)
	 * �ù�� ��õ - /api/v1/recommend(t_key, t_invoice)
	 * ����� ��ȸ - /api/v1/trackingInfo(t_key, t_code, t_invoice)
	 */
	private final static String KEY = "5QzfWN1Q6vQe0m0M3Oovgg";
	public static JSONArray callCompayList() {
		String baseUrl = "http://info.sweettracker.co.kr/api/v1/companylist?t_key=" + KEY;
		JSONArray result = null;
		try {
			URL url = new URL(baseUrl);
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
		            System.out.println("404:: response body �� code �� msg Ȯ�� �ٶ��ϴ�");
		        } else if (responseCode == 500) {
		            System.out.println("500:: ���� ����");
		        } else { 
		        	System.out.println("�� �� ����");
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
	
	public static JSONArray callRecommand(String invoice) {
		String baseUrl = "http://info.sweettracker.co.kr/api/v1/recommend?t_key=" + KEY;
		JSONArray result = null;
		try {
			URL url = new URL(baseUrl + "&t_invoice=" + invoice);
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
			         result = responseJson.getJSONArray("Recommend");
		        } else if (responseCode == 404) {
		            System.out.println("404:: response body �� code �� msg Ȯ�� �ٶ��ϴ�");
		        } else if (responseCode == 500) {
		            System.out.println("500:: ���� ����");
		        } else { 
		        	System.out.println("�� �� ����");
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
	
	public static JSONObject callTrackingInfo(String invoice, String code) {
		String baseUrl = "http://info.sweettracker.co.kr/api/v1/trackingInfo?t_key=" + KEY;
		JSONObject result = null;
		try {
			URL url = new URL(baseUrl + "&t_code=" + code + "&t_invoice=" + invoice);
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
			         
			         result = new JSONObject(sb.toString());
		        } else if (responseCode == 404) {
		            System.out.println("404:: response body �� code �� msg Ȯ�� �ٶ��ϴ�");
		        } else if (responseCode == 500) {
		            System.out.println("500:: ���� ����");
		        } else if (responseCode == 101) {
		        	System.out.println("101:: �߱޵� ����Ű�� ���� ���� ����");
		        } else if (responseCode == 102) {
		        	System.out.println("102:: ����� Ű");
		        } else if (responseCode == 103) {
		        	System.out.println("103:: Ű ��뷮 �ʰ�");
		        } else if (responseCode == 104) {
		        	System.out.println("104:: ��ȿ���� ���� ����� ��ȣ Ȥ�� �ù�� �ڵ� �Է�");
		        } else if (responseCode == 105) {
		        	System.out.println("105:: ������ ������� �Ϸ� ��û ���� �Ǽ� �ʰ�");
		        } else if (responseCode == 106) {
		        	System.out.println("106:: ����� ��ȣ ��ȸ ����");
		        } else { 
		        	System.out.println("�� �� ����");
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
