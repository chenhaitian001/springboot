package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.test.demo.BookFacade;
import com.test.demo.BookFacadeProxy;
import com.test.demo.UserService;
import com.test.demo.impl.BookFacadeImpl;
import com.test.demo.impl.UserSeriviceImpl;


public class JavaProxy {
	public static void main(String[] args){
		/*final UserSeriviceImpl target = new UserSeriviceImpl();
		UserService targerProxy = (UserService)Proxy.newProxyInstance(JavaProxy.class.getClassLoader(),new Class[]{UserService.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("前置逻辑");
				try{
					return  method.invoke(target ,args);
				}finally
				{
				System.out.println("后置逻辑");	
				}
				
			}
		});
		targerProxy.getName("zhangsan");*/
		//BookFacadeImpl book= new BookFacadeImpl();
		BookFacade book = new BookFacadeImpl(); 
		InvocationHandler handler = new BookFacadeProxy(book);
		BookFacade targer = (BookFacade)Proxy.newProxyInstance(book.getClass().getClassLoader(), book.getClass().getInterfaces(), handler);
		
		//BookFacadeProxy proxy = new BookFacadeProxy();
		//BookFacade fac = (BookFacade) proxy.bind(book);
		//fac.addBook();
		targer.addBook();
		
	}
}
