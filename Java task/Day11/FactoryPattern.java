package com.dedalus;


interface Iseries
{
	void showI();
}
class Iphone implements Iseries
{
	public void showI()
	{
		System.out.println("This is an Iphone Iseries!!");
	}
}
class Ipad implements Iseries
{
	public void showI()
	{
		System.out.println("This is a Ipad Iseries!!");
	}
}
class Ipod implements Iseries
{
	public void showI()
	{
		System.out.println("This is a ipod Iseries!!");
	}
}

class IFactory 
{
	public Iseries getIseries(String str)
	{
		if(str==null)
			return null;
		if(str.equalsIgnoreCase("Iphone"))
			return new Iphone();
		else if(str.equalsIgnoreCase("Ipad"))
			return new Ipad();
		else if(str.equalsIgnoreCase("Ipod"))
			return new Ipod();
		
		return null;
	}
}


class FactoryPattern
{
	public static void main(String args[])
	{
		
		IFactory ifact=new IFactory();
		
		Iseries if1=ifact.getIseries("Iphone");
		if1.showI();
		Iseries if2=ifact.getIseries("Ipad");
		if2.showI();
		Iseries if3=ifact.getIseries("Ipod");
		if3.showI();
		
	}
}
