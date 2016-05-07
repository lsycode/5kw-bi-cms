package com.flf.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ssd.framework.util.Checking;

public class CheckBIZ {
	/**
	 * 邮件验证
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return regexCheck(email, check);

	}

	/**
	 * 8-15位,同时包含数字和字母验证
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isPassword(String password) {
		String check = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,15}$";
		return regexCheck(password, check);
	}

	/**
	 * 6-15位数字或字母，或同时包括
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isPasswordMG(String password) {
		String check = "^[0-9A-Za-z]{6,15}$";
		return regexCheck(password, check);
	}

	/**
	 * 验证是否是快速注册账号
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isAccountNameQuick(String str) {
		String check = "^mg(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{13}$";
		return regexCheck(str, check);
	}

	/**
	 * 正则检验
	 * 
	 * @param str
	 * @param check
	 * @return
	 */
	private static boolean regexCheck(String str, String check) {
		boolean flag = false;
		if (Checking.isNullorBlank(str)) {
			return flag;
		}
		try {
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(str);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
