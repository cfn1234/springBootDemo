package com.demo.slidingwindow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <br>
 * 〈功能详细描述〉
 * com.demo.slidingwindow
 *
 * @author caofengnian 2019/4/23 0023 11:01
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SlidingWindowCounterTest {
	private static ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) throws IOException {
	SlidingWindowCounter swc = new SlidingWindowCounter(3);
		ses.scheduleAtFixedRate(() -> {
			//方法引用
			Loops.fixLoop(swc::increase, new Random().nextInt(10));
		}, 10, 2, TimeUnit.MILLISECONDS);
		ses.scheduleAtFixedRate(() -> {
			System.out.println(swc);
			swc.advance();
		}, 1, 1, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(() -> {
			swc.resizeWindow(new Random().nextInt(10));
		}, 1, 10, TimeUnit.SECONDS);
		System.in.read();
	}
	public void test3Window() {
		SlidingWindowCounter swc = new SlidingWindowCounter(3);
		System.out.println(swc);
		swc.increase();
		System.out.println(swc);
		swc.advance();
		System.out.println(swc);
		swc.increase();
		swc.increase();
		System.out.println(swc);
		swc.advance();
		System.out.println(swc);
		swc.increase();
		swc.increase();
		swc.increase();
		System.out.println(swc);
		swc.advance();
		System.out.println(swc);
		swc.increase();
		swc.increase();
		swc.increase();
		swc.increase();
		System.out.println(swc);
		swc.advance();
		System.out.println(swc);
	}

}
