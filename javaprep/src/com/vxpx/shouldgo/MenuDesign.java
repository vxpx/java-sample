package com.vxpx.shouldgo;

import java.util.Scanner;

public class MenuDesign {

	public static void main(String[] args) {

		String[] mainMenu = { "1. Menu-1", "2. Menu-2" };
		String[] subMenu1 = { "Model", "Price", "Comments" };
		String [] input = new String [subMenu1.length];

		while (true) {
			for (String display : mainMenu) {
				System.out.println(display);
			}

			Scanner menuScanner = new Scanner(System.in);
			int menu = menuScanner.nextInt();
			
			//String subMenu = "subMenu" + menu;
			//System.out.println("You Selected " + subMenu);
			
			//use switch if needed here to contorl the menu
			int i=0;
			for(String displaySub : subMenu1) {
				
				System.out.println(displaySub);
				Scanner subMenuScanner = new Scanner(System.in);
				input[i] = subMenuScanner.nextLine();
				i++;
			}
			
			for(String inputStr : input) {
				System.out.println(inputStr);
			}
		}
	}

}
