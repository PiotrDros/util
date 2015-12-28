package com.till;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTrace {

	public static String methodName() {
		StringWriter sw = new StringWriter();
		new Throwable().printStackTrace(new PrintWriter(sw));
		String stackTrace = sw.toString();
		String[] split = stackTrace.split("\n");
		String packageName = new Object() {
		}.getClass().getPackage().getName();
		for (int i = 0; i < split.length; i++) {
			if (split[i].contains(packageName + ".StackTrace.methodName")) {
				return split[i + 1].replace("at ", "").trim();
			}
		}
		return "ERROR";
	}

	public static void main(String[] args) {
		System.out.println(methodName());

		// Object s = new Object() {
		// @Override
		// public String toString() {
		// return methodName();
		// };
		// };

		// System.out.println(s);
	}
}
