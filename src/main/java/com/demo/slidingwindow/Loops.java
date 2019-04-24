package com.demo.slidingwindow;

import java.util.concurrent.TimeUnit;

/**
 * <br>
 * 〈功能详细描述〉循环
 * com.demo.slidingwindow
 *
 * @author caofengnian 2019/4/23 0023 11:01
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Loops {
	public static void dieLoop(Runnable runnable) {
		while (true) {
			run(runnable);
		}
	}

	public static void rateLoop(Runnable runnable, int mills) {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(mills);
			} catch (InterruptedException e) {

			}
			run(runnable);
		}
	}

	public static void fixLoop(Runnable runnable, int loop) {
		for (int i = 0; i < loop; i++) {
			run(runnable);
		}
	}

	private static void run(Runnable runnable) {
		try {
			runnable.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
