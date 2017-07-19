package com.sowayai.dynamicproxy;

public class Student implements Flyable{

	public void sayHello(){
		System.out.println("呵呵呵哒");
	}

	@Override
	public void flyInSky() {
		// TODO Auto-generated method stub
		System.out.println("我是凹凸慢，我前来买菜！");
		//恐龙特急克塞号
	}
}
