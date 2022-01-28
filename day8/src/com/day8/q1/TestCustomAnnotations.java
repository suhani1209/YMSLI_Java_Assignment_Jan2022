package com.day8.q1;

import java.lang.reflect.Method;

public class TestCustomAnnotations {
	public static void main(String[] args) {
		try {
			Class<?> class1 = Class.forName("com.day8.q1.AnnotatedClass");

			Author author = class1.getAnnotation(Author.class);
			System.out.println("AnnotatedClass @Author: " + author.name());
			Version version = class1.getAnnotation(Version.class);
			System.out.println("Version : " + version.number());

			Method[] m = class1.getDeclaredMethods();
			Author method1 = m[0].getAnnotation(Author.class);
			System.out.println("annotatedMethod1 @Author:" + method1.name());
			Version method12 = m[0].getAnnotation(Version.class);
			System.out.println("Version :" + method12.number());

			Author method2 = m[1].getAnnotation(Author.class);
			System.out.println("annotatedMethod2 @Author:" + method2.name());
			Version method22 = m[1].getAnnotation(Version.class);
			System.out.println("Version :" + method22.number());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}