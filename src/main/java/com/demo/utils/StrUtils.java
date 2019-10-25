package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * 字符串工具类
 * <p>
 * 对common-lang3下的StringUtils工具类做一层封装
 *
 * @author zpy
 * @since 2018-5-31
 */
public class StrUtils {

	/**
	 * 字符串是否null、空串、空白串
	 */
	public static boolean isBlank(final CharSequence cs) {
		return StringUtils.isBlank(cs);
	}

	/**
	 * 字符串是否null、空串、空白串
	 */
	public static boolean isNoneBlank(final CharSequence cs) {
		return StringUtils.isNoneBlank(cs);
	}

	/**
	 * 生成指定长度的数字
	 */
	public static String randomNum(int length) {
		String numStr = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			numStr += String.valueOf(random.nextInt(10));
		}
		return numStr;
	}

	/**
	 * 是否包含
	 * <p>
	 * 这里val2定义为object是为了兼容beetle
	 * </p>
	 */
	public boolean contains(String val1, String val2) {
		return isNoneBlank(val1) && val1.contains(val2.toString());
	}

	/**
	 * 还原被转移的特殊字符
	 */
	public static String restoreHtml(String title) {
		if (isNoneBlank(title)) {
			if (title.contains("&quot;")) {
				title = title.replace("&quot;", "\"");
			}
			if (title.contains("&ldquo;")) {
				title = title.replace("&ldquo;", "“");
			}
			if (title.contains("&rdquo;")) {
				title = title.replace("&rdquo;", "”");
			}
			if (title.contains("&#39;")) {
				title = title.replace("&#39;", "'");
			}
			if (title.contains("&lsquo;")) {
				title = title.replace("&lsquo;", "‘");
			}
			if (title.contains("&rsquo;")) {
				title = title.replace("&rsquo;", "’");
			}
			if (title.contains("&hellip;")) {
				title = title.replace("&hellip;", "…");
			}
			if (title.contains("&amp;")) {
				title = title.replace("&amp;", "&");
			}
			if (title.contains("&and;")) {
				title = title.replace("&and;", "^");
			}
			if (title.contains("&or;")) {
				title = title.replace("&or;", "v");
			}
			if (title.contains("&mdash;")) {
				title = title.replace("&mdash;", "—");
			}

			if (title.contains("&Alpha;")) {
				title = title.replace("&Alpha;", "A");
			}

			if (title.contains("&Beta;")) {
				title = title.replace("&Beta;", "B");
			}

			if (title.contains("&Epsilon;")) {
				title = title.replace("&Epsilon;", "E");
			}

			if (title.contains("&Zeta;")) {
				title = title.replace("&Zeta;", "Z");
			}

			if (title.contains("&Eta;")) {
				title = title.replace("&Eta;", "H");
			}

			if (title.contains("&Iota;")) {
				title = title.replace("&Iota;", "I");
			}

			if (title.contains("&Kappa;")) {
				title = title.replace("&Kappa;", "K");
			}

			if (title.contains("&Nu;")) {
				title = title.replace("&Nu;", "N");
			}

			if (title.contains("&gt;")) {
				title = title.replace("&gt;", ">");
			}

			if (title.contains("&lt;")) {
				title = title.replace("&lt;", "<");
			}
			if (title.contains("&middot;")) {
				title = title.replace("&middot;", "");
			}
		}
		return title;
	}

	/**
	 * 将整形数组转换为字符串
	 *
	 * @param intValues
	 * @return
	 */
	public static String toStringIntArray(int[] intValues) {
		StringBuilder sb = new StringBuilder();
		for (int val : intValues) {
			if (sb.length() == 0) {
				sb.append(val);
			} else {
				sb.append(",").append(val);
			}
		}
		return sb.toString();
	}

	/**
	 * 将字符串数组转换为字符串
	 *
	 * @param strValues
	 * @return
	 */
	public static String toStringStringArray(String[] strValues) {
		StringBuilder sb = new StringBuilder();
		for (String val : strValues) {
			if (sb.length() == 0) {
				sb.append(val);
			} else {
				sb.append(",").append(val);
			}
		}
		return sb.toString();
	}
}
