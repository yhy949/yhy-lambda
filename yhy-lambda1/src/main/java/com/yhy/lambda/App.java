package com.yhy.lambda;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

public class App  {
	
	static void test() throws Exception {
		Runnable r1 = new Runnable()  {
			@Override
			public void run() {
				System.out.println("run");
			}
		};
		r1.run();
		
		Runnable r2 = () -> {System.out.println("run");};
		r2.run();
		
		Runnable r3 = () -> System.out.println("run");
		r3.run();
		
		Callable<String> c1 = new Callable<String>() {
			public String call() throws Exception {
				return "hello";
			}
		};
		
		Callable<String> c2 = () -> {return "hello";};
		Callable<String> c3 = () -> "hello";
		
		System.out.println(c1.call());
		System.out.println(c2.call());
		System.out.println(c3.call());
		
		UserMapper u1 = new UserMapper() {
			@Override
			public void insert(User user) {
				System.out.println("insert user: " + user);
			}
		};
	
		UserMapper u2 = (user) -> {System.out.println("insert user: " + user);};
		UserMapper u3 = (User user) -> System.out.println("insert user: " + user);
		
		u1.insert(new User());
		u2.insert(new User());
		u3.insert(new User());
		
		OrderMapper o1 = new OrderMapper() {
			@Override
			public int insert(Order order) {
				System.out.println("insert order: " + order);
				return 1;
			}
		};
		
		OrderMapper o2 = (order) -> {return 1;};
		OrderMapper o3 = (Order order) -> {return 1;};
		OrderMapper o4 = (order) -> 1;
		OrderMapper o5 = (Order order) -> 1;
		System.out.println(o1.insert(new Order()));
		System.out.println(o2.insert(new Order()));
		System.out.println(o3.insert(new Order()));
		System.out.println(o4.insert(new Order()));
		System.out.println(o5.insert(new Order()));
		
		Function<Integer, Integer> f1 = a -> {
			int sum = 0;
			for(int i=1;i<=a;i++) {
				sum += i;
			}
			return sum;
		};
		
		System.out.println(f1.apply(10));
	}
	
	static int get() {
		return 1;
	}
	
	static String find() {
		return "";
	}
	
	static void exec() {
		find();
	}
	
	public static void main(String[] args) throws Exception {
		Runnable r1 = () -> get();
		Runnable r2 = () -> exec();
		
//		Runnable r3 = () -> 100;
//		Runnable r4 = () -> "";
		
		Foo f1 = () -> get();
//		Foo f2 = () -> find();
//		Foo f3 = () -> exec();
		
		Foo f4 = () -> 100;
		Foo f5 = () -> true ? 1 : -1;
		
		BiFunction<String, String, Integer> bf = (a, b) -> a.length() + b.length();
		System.out.println(bf.apply("java", "se"));
		
		BiFunction<String, String, Integer> bf1 = (a, b) -> {
			//doing
			return 1;
		};
		
		Function<String, Integer> f6 = a -> a.length();
		System.out.println(f6.apply("javaee"));
	}
}

interface UserMapper {
	void insert(User user);
}

interface OrderMapper {
	int insert(Order order);
}

interface Foo {
	int get();
}

class User {
	
}

class Order {
	
}

