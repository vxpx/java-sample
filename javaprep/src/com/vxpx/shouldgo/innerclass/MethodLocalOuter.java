package com.vxpx.shouldgo.innerclass;

public class MethodLocalOuter {
	
	private int outerval = 10;
	
	void accessMethodLocal() {
		
		String localInnerVal = "vxpx";
		
		//the same rules apply to
		//method-local inner classes as to local variable declarations. You can't, for example,
		//mark a method-local inner class public, private, protected, static, transient,
		//and the like. The only modifiers you can apply to a method-local inner class are
		//abstract and final, but as always, never both at the same time.
		
		class LocalInner {
			String name;
					
			void getInnerClass() {
				System.out.println(outerval);
				System.out.println(localInnerVal);
			}
		}
		
		LocalInner inner = new LocalInner();
		inner.getInnerClass();
		
	}
	
	public static void main(String[] args) {
		
		MethodLocalOuter localInner = new MethodLocalOuter();
		localInner.accessMethodLocal();
				
	}

}
