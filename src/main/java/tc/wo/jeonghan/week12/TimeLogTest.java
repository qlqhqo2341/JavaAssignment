package tc.wo.jeonghan.week12;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

public class TimeLogTest {
	
	@TimeLog(repeat = 1000)
	public static void doubleMultiply() {
		double d = 1.0;
		for (int i=0;i<1000000;i++) {
			d = d * 1.01;
		}
	}
	
	@TimeLog(repeat = 1000)
	public static void integerMultiply() {
		long l = 1L;
		for (int i=0;i<1000000;i++) {
			l = l * 2;
		}
	}
	
	public static void main(String[] args) {
		Arrays.stream(TimeLogTest.class.getMethods())
			.filter(method -> method.getAnnotation(TimeLog.class) != null)
			.forEach(method -> {
				TimeLog timeLog = method.getAnnotation(TimeLog.class);
				int repeat = timeLog.repeat();
				System.out.printf("Start time test of method : %s, repeated : %s \n",
					method.getName(), repeat);
				
				LocalTime start = LocalTime.now();
				try {
					for (int i=0;i<repeat;i++) {
						method.invoke(null);
					}
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				LocalTime end = LocalTime.now();
				Duration duration = Duration.between(start, end);
				System.out.printf("Elapsed : %d.%09ds\n", 
					duration.getSeconds(), duration.getNano());
			});
	}
}
