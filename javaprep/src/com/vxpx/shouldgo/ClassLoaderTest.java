package com.vxpx.shouldgo;

public class ClassLoaderTest {

	public static void main(String[] args) {

		try {
			Class.forName("ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader().getParent());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
