package com.yif.util;

public class TextUtil {
	/**
	 * 判断字符串是否为空
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(CharSequence s) {
		return s == null || s.length() == 0;
	}
}
