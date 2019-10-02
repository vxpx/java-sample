package com.vxpx.shouldgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class GetRunner implements Runnable {

	String url;
	
	GetRunner(String httpurl) throws IOException {
		url = httpurl;
	}

	@Override
	public void run() {
		try {
			
			int sleepTime = (int) (Math.random()*10000);
			System.out.println(sleepTime);
			Thread.sleep(sleepTime);
			
			HttpURLConnection conn;
			URL url;
			url = new URL(this.url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			

			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			System.out.println(this.url);
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

public class ConcurrentRest {

	

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) throws IOException {

		String url1 = "https://aprilia-fiberplus-prod1.corp.intranet:14103/api/rest/aprilia/fiberplus/v1/solution/cntrl/v2/siteSurveyValidation?DSRNumber=&opportunityId=56394657&addLine1=995%20PRAIRIE%20CENTER%20DR&city=EDEN%20PRAIRIE&state=MN&zipCode=55344";
		String url2 = "https://aprilia-fiberplus-prod1.corp.intranet:14103/api/rest/aprilia/fiberplus/v1/solution/cntrl/v2/siteSurveyValidation?DSRNumber=&opportunityId=56296892&addLine1=620%20N%206TH%20ST&city=BOISE&state=ID&zipCode=83702";
		String url3 = "https://aprilia-fiberplus-prod1.corp.intranet:14103/api/rest/aprilia/fiberplus/v1/solution/cntrl/v2/siteSurveyValidation?DSRNumber=&opportunityId=56330372&addLine1=1101%20W%20FRONT%20ST&city=BOISE&state=ID&zipCode=83702";
		Thread t1 = new Thread(new GetRunner(url1));
		Thread t2 = new Thread(new GetRunner(url2));
		Thread t3 = new Thread(new GetRunner(url3));
		t1.start();
		t2.start();
		t3.start();
		

	}

}