package com.santhosh.corejava.streams;

public class Person {
    public Person(String name, int age, String state) {
		this.name = name;
		this.age = age;
		this.state = state;
		this.gender = Gender.FEMALE;
	}
    
	public Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.state = "NY";
		this.gender = gender;
	}

	private final String name;
    private final int age;
    private final String state;
    private final Gender gender;
    
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "\nPerson [name=" + name + ", age=" + age + ", state=" + state + "]";
	}
	public Gender getGender() {
		return gender;
	}
}
