package com;

public class TestMain {

	static class A{
		String str;
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.str = "main";
		System.out.println("main:"+a.str+"__address:"+a.hashCode());
		modifyData(a);
		System.out.println("main:"+a.str+"__address:"+a.hashCode());
	}
	
	private static void modifyData(A a){
//		a= new A();
		a.str="modifyData";
		System.out.println("main:"+a.str+"__address:"+a.hashCode());
	}

}
