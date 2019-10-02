package com.vxpx.shouldgo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileTest {

	private void createFile() throws IOException {
		File newFile = new File("test.txt");

		BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
		bw.write("Testing the file creation");
		bw.close();

		System.out.println("Created a new file " + newFile.getAbsolutePath());
	}

	public static void main(String[] args) throws IOException {

		File file = new File("test.txt");
		
		System.out.println("/** Read File line by line **/");
		/** Read File line by line **/
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {

			System.out.println(line);

		}
		
		System.out.println("\n\n/** Read in chunks **/");
		/** Read in chunks **/
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte [] bytearray = new byte[4096];
		int len;
		while((len = bis.read(bytearray)) != -1) {
			for(byte c : bytearray) {
				System.out.print((char)c + " ");
			}
		}
		
		
		System.out.println("\n\n/** Read in scanner **/");
		Scanner sc = new Scanner(new FileInputStream(file));
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			System.out.println(line);
		}
		
		System.out.println("\n\n/** Read in nio streams **/");
		Stream linestream = Files.lines(file.toPath());
		linestream.forEach(System.out::println);
		
		
	}

}
