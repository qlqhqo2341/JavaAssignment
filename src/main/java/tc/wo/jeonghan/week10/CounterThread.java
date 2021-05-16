package tc.wo.jeonghan.week10;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CounterThread {
	
	private static List<Thread> threads = new LinkedList<>();
	
	private static List<Thread.State> showThreadStates() {
		List<Thread.State> threadStates = threads.stream()
			.map(Thread::getState)
			.collect(Collectors.toList());

		return threadStates;
	}

	public static void main(String[] args) {
		int countNum = 5;
		int threadNum = 3;
		List<Thread> threads = IntStream.range(0, threadNum)
			.mapToObj(i -> new Thread(() -> 
				IntStream.range(0, countNum).forEach(num -> {
					try {
						System.out.println("thread " + i + " : " + num);
						Thread.sleep(300L);
					} catch (InterruptedException ignored) { }
				})
			))
			.collect(Collectors.toList());
		CounterThread.threads.addAll(threads);
		
		threads.add(new Thread(() -> {
			int gap = 100;
			LongStream.iterate(0, i -> i + gap).filter(i -> {
				List<Thread.State> states = showThreadStates();
				System.out.println("show time : " + i + ", state : " + states);
				try { Thread.sleep(gap); } catch (InterruptedException ignored) { }
				return states.stream().allMatch(Thread.State.TERMINATED::equals);
			}).findFirst();
		}));
		
		threads.stream().forEach(Thread::start);
		
		// 다른 스레드를 기다린다.
		threads.stream().forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException ignored) { }
		});
		
		System.out.println("finished");
	}
}
