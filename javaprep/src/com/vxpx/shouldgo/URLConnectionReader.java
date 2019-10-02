package com.vxpx.shouldgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.google.com/");

		URLConnection urlConnection = url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		// byte [] byteArray = new byte[4096];

		String inputLine;

		while ((inputLine = br.readLine()) != null) {
			System.out.println(inputLine);
		}

		br.close();
	}

}
