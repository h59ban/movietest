package com.sowayai.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 加强其他类时用到的模板
 * @author soway
 *
 */
public class MyHandler implements InvocationHandler {

	private Object target;
	
	public MyHandler(Object target) {
		super();
		this.target = target;
	}
	public MyHandler() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * JDK到现在都没有改，第一个参数无用，不用管。
	 * 第二个参数Method就是要加强的那个方法 
	 * 第三个参数就是方法的参数们
	 */
	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		this.before();
		Object ret = method.invoke(this.target, args);
		//this.after();
		return ret;
	}
	//写出自己的加强逻辑。名字自定义
	public void before(){
//		System.out.println("方法执行之前");
//		System.out.println("验证权限");
		System.out.println("开始事务");
	}
	
	public void after(){
//		System.out.println("方法执行之后");
		System.out.println("结束事务");
	}

}
