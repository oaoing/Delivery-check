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
	 * api 주소
	 * 택배사 조회 - /api/v1/companylist(t_key)
	 * 택배사 추천 - /api/v1/recommend(t_key, t_invoice)
	 * 운송장 조회 - /api/v1/trackingInfo(t_key, t_code, t_invoice)
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
		            System.out.println("404:: response body 의 code 와 msg 확인 바랍니다");
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
		            System.out.println("404:: response body 의 code 와 msg 확인 바랍니다");
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
		            System.out.println("404:: response body 의 code 와 msg 확인 바랍니다");
		        } else if (responseCode == 500) {
		            System.out.println("500:: 서버 에러");
		        } else if (responseCode == 101) {
		        	System.out.println("101:: 발급된 고유키가 존재 하지 않음");
		        } else if (responseCode == 102) {
		        	System.out.println("102:: 만료된 키");
		        } else if (responseCode == 103) {
		        	System.out.println("103:: 키 사용량 초과");
		        } else if (responseCode == 104) {
		        	System.out.println("104:: 유효하지 않은 운송장 번호 혹은 택배사 코드 입력");
		        } else if (responseCode == 105) {
		        	System.out.println("105:: 동일한 운송장의 하루 요청 제한 건수 초과");
		        } else if (responseCode == 106) {
		        	System.out.println("106:: 운송장 번호 조회 에러");
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
