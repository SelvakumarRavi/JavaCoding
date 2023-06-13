package com.dal;

public class MyHomeWork {

	
	public static void main(String[] args) {
		Multiple mul = new Multiple();
		mul.x=100;
		mul.y=200;
		mul.AddDisplay();
		mul.MulDisplay(10,20);
		
	}
}

class Multiple{
	
	int x=0;
	int y=0;
	int res=0;
	public void AddDisplay() {
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("Addition of x,y=" +(res=x+y));
		 
	}	
	public void MulDisplay(int a, int b) {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("Multiplication of a,b=" +(res=a*b));
	}
	
	
}
