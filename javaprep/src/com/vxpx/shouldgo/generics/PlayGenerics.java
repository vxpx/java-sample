package com.vxpx.shouldgo.generics;

import java.util.ArrayList;
import java.util.List;

class Animal {
	String name;

	Animal(String name) {
		this.name = name;

	}

	void perform() {
		System.out.println("Animal Performance");
	}
}

class Dog extends Animal {

	Dog(String name) {
		super(name);
	}

	void perform() {
		System.out.println("Dog Performance");
	}
}

class Cat extends Animal {

	Cat(String name) {
		super(name);
	}

	void perform() {
		System.out.println("Cat Performance");
	}
}

public class PlayGenerics {

	private void addToList1(List <Animal> genericList) {
		//This method will not work even though it doesn't have a add.
		//genericList.add(new Dog("Dog"));
	}
	
	private void addToList2(List <? extends Animal> genericList) {
		//This method will work if it doesn't have a add.
		//genericList.add(new Dog("Dog"));
	}
	
	
	private void addToList3(List <? super Dog> genericList) {
		//This method will work if it has a add.
		genericList.add(new Dog("Dog"));
	}
	
	
	/*private void addToList2(List <? super Dog> genericList) {
		genericList.add(new Animal("Animal"));
	}

	private void addToList3(List <?> genericList) {
		genericList.add(new Animal("Animal"));
	}*/
	
	public static void main(String[] args) {
		
		List <Dog> dogList = new ArrayList<Dog>();
		List <Animal> animalList = new ArrayList<Animal>();

		PlayGenerics pGenerics = new PlayGenerics();
		//pGenerics.addToList1(dogList);
		//pGenerics.addToList2(genericList);
		
		//String.format("%04d", Long.valueOf("0016@0100"));

	}

}
