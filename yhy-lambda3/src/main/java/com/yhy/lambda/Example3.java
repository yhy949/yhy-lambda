package com.yhy.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 实例方法引用
 * 如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
 * 
 *  语法
 *  inst::instMethod
 */
public class Example3 extends Base {

	public String put() {
		return "hello";
	}
	
	public void con(Integer size) {
		System.out.println("size : " + size);
	}
	
	public String toUpper(String str) {
		System.out.println("current to upper");
		return str.toUpperCase();
	}
	
	public void test() {
		Function<String, String> f4 = this::toUpper;
		System.out.println(f4.apply("javame"));
		
		Function<String, String> f5 = super::toUpper;
		System.out.println(f5.apply("javame"));
	}
	
	public static void main(String[] args) {
		Supplier<String> s = () -> new Example3().put();
		Supplier<String> s1 = () -> {return new Example3().put();};
		Supplier<String> s2 = new Example3()::put;
		Supplier<String> s3 = new Foo()::find;
		System.out.println(s2.get());
		
		Example3 exam = new Example3();
		exam.test();
		
		Consumer<Integer> c1 = (size) -> new Example3().con(size);
		Consumer<Integer> c2 = new Example3()::con;
		Consumer<Integer> c3 = exam::con;
		c2.accept(100);
		c3.accept(100);
		
		Function<String, String> f1 = str -> str.toUpperCase();
		Function<String, String> f2 = str -> exam.toUpper(str);
		Function<String, String> f3 = str -> new Example3().toUpper(str);
		Function<String, String> f4 = exam::toUpper;
		Function<String, String> f5 = new Example3()::toUpper;
		System.out.println(f4.apply("javase"));
		System.out.println(f5.apply("javaee"));
	}

}
class Foo {
	public String find() {
		return "hello";
	}
}

