package com.marpol.iolist.config;

public class Line {

	public static String dLine() {
		return dLine(60);
	}

	public static String dLine(int lenght) {
		return "=".repeat(lenght);
	}

	public static String sLine() {
		return sLine(60);
	}

	public static String sLine(int lenght) {
		return "-".repeat(lenght);
	}
}
