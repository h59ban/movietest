package com.sowayai.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.sowayai.dynamicproxy.Admin;
import com.sowayai.dynamicproxy.Administrable;
import com.sowayai.dynamicproxy.Flyable;
import com.sowayai.dynamicproxy.MyHandler;
import com.sowayai.dynamicproxy.Student;

public class StudentTestCase {

	@Test
	public void test() {
		Student student = new Student();
		try {
			Object obj = Class.forName("com.sowayai.dynamicproxy.Student").newInstance();
			Method m = obj.getClass().getMethod("sayHello", null);
			m.invoke(obj, null);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testDynamicProxy(){
		/*String[] strs = new String[]{
			"aaa","bbbb","cccc"
		};
		Class<Flyable>[] ins = new Class[]{
			Flyable.class
		};
		InvocationHandler handler = new MyHandler(new Student());
		
		Flyable fly = (Flyable) Proxy.newProxyInstance(this.getClass().getClassLoader(), ins, handler);
		fly.flyInSky();*/
		InvocationHandler handler = new MyHandler(new Admin());
		Administrable admin = (Administrable) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{Administrable.class}, handler);
		admin.showAdministrators();
	}
}
