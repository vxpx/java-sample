package com.vxpx.shouldgo.innerclass;

interface Animal {
	public void speak();
}

// Purpose of anonymous inner class is to overrride
public class AnonymousInner {

	public void pop() {
		System.out.println("Popped Outer");
	}

	public static void main(String[] args) {

		AnonymousInner inner = new AnonymousInner() {
			public void pop() {
				System.out.println("Popped Inner inturn");
			}
		};

		inner.pop();

		Animal animal = new Animal() {
			public void speak() {
				System.out.println("Bow Bow");
			}
		};

		animal.speak();

	}

}
