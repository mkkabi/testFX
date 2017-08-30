package com.mycompany.mavenproject1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NewClass implements Serializable{
		
	int number;
	String name;
	
	public static List<NewClass> objects = new ArrayList();
	
	public NewClass(final int number) throws FileNotFoundException, IOException {
		objects.add(this);
		this.number = number;
		System.out.println("created ");
	}
	
	public int getNumber(){
		return number;
	}
	
}
