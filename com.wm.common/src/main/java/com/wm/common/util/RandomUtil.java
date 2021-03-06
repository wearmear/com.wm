package com.wm.common.util;

import java.util.Random;

public class RandomUtil {
	public static String getCharAndNum(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) { // 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 字符串
			if ("char".equalsIgnoreCase(charOrNum)) { // 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	public static String getNum(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) { // 输出字母还是数字
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	
	public static void main(String[] args) {
		System.out.println(getCharAndNum(6));
		System.out.println(getNum(6));
	}
}
