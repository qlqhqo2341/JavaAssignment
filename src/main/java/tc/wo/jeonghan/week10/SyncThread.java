package tc.wo.jeonghan.week10;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SyncThread extends Thread {
	
	private static Integer counter = 0;
	private static Object locker = new Object();
	
	private static List<Thread> threads = new LinkedList<>();

	private static List<Thread.State> showThreadStates() {
		List<Thread.State> threadStates = threads.stream()
			.map(Thread::getState)
			.collect(Collectors.toList());

		return threadStates;
	}
	
	@Override
	public void run() {
		IntStream.range(0, 1000000).forEach(i -> {
			// objectSyncIncrementRun();
			methodSyncIncrementRun();
		});
	}
	
	private static synchronized void objectSyncIncrementRun() {
		synchronized (locker) {
			counter += 1;
		}
	}

	private static synchronized void methodSyncIncrementRun() {
		counter += 1;
	}

	public static void main(String[] args) {
		List<Thread> threadList = IntStream.range(0, 10)
			.mapToObj(i -> new SyncThread())
			.collect(Collectors.toList());
		
		threads.addAll(threadList);
		threadList.add(new Thread(() -> {
			int gap = 50;
			LongStream.iterate(0, i -> i + gap).filter(i -> {
				List<Thread.State> states = showThreadStates();
				System.out.println("show time : " + i + ", state : " + states);
				try { Thread.sleep(gap); } catch (InterruptedException ignored) { }
				return states.stream().allMatch(Thread.State.TERMINATED::equals);
			}).findFirst();
		}));
		
		
		threadList.forEach(Thread::start);
		threadList.forEach(thread -> {
			try { thread.join(); } catch (InterruptedException ignored) {}
		});
		
		System.out.println("result : " + counter);
	}
}
