package com.yhy.lambda;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 对象方法引用
 * 抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数恰好可以当做实例方法的参数。
 * 如果函数式接口的实现能由上面说的实例方法调用来实现的话，那么就可以使用对象方法引用
 * 
 * 
 * 第一个参数类型 最好是自定义的类型
 * 
 *  语法
 *  类名::instMethod
 */
public class Example4 {
	
	/**
	 * 抽象方法没有输入参数，不能使用对象方法引用
	 * 比如说，如下函数式接口
	 */
	public void not() {
		Runnable run = () -> {};
		Closeable c = () -> {};
		Supplier<String> s = () -> "";
	}
	
	public static void main(String[] args) {
		Consumer<Too> c1 = (Too too) -> new Too().foo();
		Consumer<Too> c2 = (Too too) -> new Too2().foo();
		Consumer<Too> c3 = Too::foo;
		
		c1.accept(new Too());
		c3.accept(new Too());
		
		BiConsumer<Too2, String> c5 = (too2, str) -> new Too2().fo(str);
		BiConsumer<Too2, String> c6 = Too2::fo;
		
		BiFunction<Prod, String, Integer> bf1 = (p, s) -> new Prod().fun(s);
		BiFunction<Prod, String, Integer> bf2 = (p, s) -> new Too().fun(s);
		BiFunction<Prod, String, Integer> bf3 = Prod::fun;
		
		Execute ex1 = (p,name,size) -> new Prod().run(name, size);
		Execute ex2 = Prod::run;
	}

}

interface Execute {
	public void run(Prod p, String name, String size);
}

class Prod {

	public void run(String name, String size) {
		
	}
	
	public Integer fun(String s) {
		return 1;
	}
	
}

class Too {
	public Integer fun(String s) {
		return 1;
	}
	
	public void foo() {
		System.out.println("invoke");
	}
}

class Too2 {
	
	public void foo() {
		System.out.println("invoke");
	}
	
	public void fo(String str) {
		
	}
}




