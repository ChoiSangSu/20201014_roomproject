package com.project.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class NaverLoginService {

	public Map<String, String> getLoginUrl() throws UnsupportedEncodingException {

		String clientId = "bRbpBdzaUReuDoll_9o0";// 애플리케이션 클라이언트 아이디값";
		// 내 callback 주소
		String redirectURI = URLEncoder.encode("http://localhost:8081/room/naverlogin/callback", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString(); // 체크값
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"; // 인증 코드값을 요청
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		Map<String, String> resultmap = new HashMap<>();
		resultmap.put("state", state);
		resultmap.put("apiURL", apiURL);
		return resultmap;
	}

	// 개인 정보 조회
	public Map <String,String> getUserInfo(String code, String state) throws ParseException, org.json.simple.parser.ParseException {
		String token = getToken(code, state); // 네이버 로그인 접근 토근;
		String header = "Bearer " + token; // Bearer 다음에 공백 추가

		String apiURL = "https://openapi.naver.com/v1/nid/me";

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
		String responseBody = get(apiURL, requestHeaders);

		System.out.println("바디값:" + responseBody);
		
		//파싱
		JSONObject object = (JSONObject) new JSONParser().parse(responseBody);
		object = (JSONObject) object.get("response");
		String id = (String) object.get("id");
		String email = (String) object.get("email");
		String name = (String) object.get("name");
		Map <String,String> resultmap = new HashMap<>();
	/*	String[] array = email.split("@"); //@를 기준으로 tkdtn1101, naver.com 이렇게 짜를수가 있다
		System.out.println(array[0]);
		System.out.println(array[1]);*/
		resultmap.put("id", id);
		/*resultmap.put("email", array[0]);*/
		resultmap.put("email", email);
		resultmap.put("name", name);
		resultmap.put("joinflag", "1"); //1을 넣어서 네이버를 통해 회원가입을 한것을 알수 있다
		return resultmap;
		
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

	// 토큰 요청
	public String getToken(String code, String state) {
		String clientId = "bRbpBdzaUReuDoll_9o0";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "sMNZXk6AJm";// 애플리케이션 클라이언트 시크릿값";
		String apiURL;
		// 토큰은 정보를 요청할수 있는 값
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";
		String refresh_token = "";
		System.out.println("apiURL=" + apiURL);
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				System.out.println(res.toString());
				// 토큰값 파싱
				JSONObject object = (JSONObject) new JSONParser().parse(res.toString());
				access_token = (String) object.get("access_token");
				System.out.println("토큰값 : " + access_token);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return access_token;
	}

}
