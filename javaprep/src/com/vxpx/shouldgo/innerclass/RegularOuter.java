package com.vxpx.shouldgo.innerclass;

public class RegularOuter {

	private int outerval = 10;

	class RegularInner {

		void accessOuter() {

			System.out.println("Outer Val " + outerval);
			System.out.println("Inner Reference " + this);
			System.out.println("Outer Reference " + RegularOuter.this);
		}
	}

	public static void main(String[] args) {

		//Two ways to create
		RegularOuter outer = new RegularOuter();
		RegularInner inner = outer.new RegularInner();
		
		RegularOuter.RegularInner inner1 = new RegularOuter().new RegularInner();
		
		inner.accessOuter();
		inner1.accessOuter();
	}

}
