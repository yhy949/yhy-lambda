package com.yhy.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 静态方法引用
 * 如果函数式接口的实现恰好是通过调用一个静态方法来实现，那么就可以使用静态方法引用
 * 
 *  语法
 *  类名::staticMethod
 */
public class Example2 {
	
	public static String put() {
		System.out.println("put method invoke");
		return "hello";
	}
	
	public static void con(Integer size) {
		System.out.println("size: " + size);
	}
	
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}
	
	public static Integer len(String s1, String s2) {
		return s1.length() + s2.length();
	}

	public static void main(String[] args) {
		Supplier<String> s = () -> Example2.put();
		Supplier<String> s1 = () -> Fun.ret();
		
		Supplier<String> s2 = Example2::put;
		Supplier<String> s3 = Fun::ret;
		System.out.println(s1.get());
		
		Consumer<Integer> c1 = (size) -> Example2.con(size);
		Consumer<Integer> c2 = Example2::con;
		c2.accept(100);
		
		Function<String, String> f1 = str -> str.toUpperCase();
		Function<String, String> f2 = str -> Example2.toUpperCase(str);
		Function<String, String> f3 = Example2::toUpperCase;
		Function<String, String> f4 = Fun::toUpperCase;
		System.out.println(f3.apply("lambda"));
		
		BiFunction<String, String, Integer> bf1 = (ss1, ss2) -> ss1.length() + ss2.length();
		BiFunction<String, String, Integer> bf2 = (ss1, ss2) -> Example2.len(ss1, ss2);
		BiFunction<String, String, Integer> bf3 = Example2::len;
		System.out.println(bf3.apply("java", "se"));
	}

}
class Fun {
	public static String ret() {
		System.out.println("put method invoke");
		return "hello";
	}
	
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
