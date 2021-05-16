package tc.wo.jeonghan.week10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DeadLockThread {
	private static Object lockerA = new Object();
	private static Object lockerB = new Object();
	private static int counter = 0;
	
	private static Runnable runnerA = () ->
		IntStream.range(0, 100000).forEach(i -> {
			synchronized (lockerA) {
				synchronized (lockerB) {
					counter += 1;
				}
			}
		});

	private static Runnable runnerB = () ->
		IntStream.range(0, 100000).forEach(i -> {
			synchronized (lockerB) {
				synchronized (lockerA) {
					counter += 1;
				}
			}
		});
	
	public static void main(String[] args) {
		List<Thread> threads = Arrays.asList(
			new Thread(runnerA), new Thread(runnerB)
		);
		
		threads.forEach(Thread::start);

		int gap = 1000;
		LongStream.iterate(0, i -> i + gap).filter(i -> {
			List<Thread.State> states = threads.stream().map(Thread::getState).collect(Collectors.toList());
			System.out.println("show time : " + i + ", state : " + states + ", counter : " + counter);
			try { Thread.sleep(gap); } catch (InterruptedException ignored) { }
			return states.stream().allMatch(Thread.State.TERMINATED::equals);
		}).findFirst();
		
		System.out.println("total result : " + counter);
	}
}
