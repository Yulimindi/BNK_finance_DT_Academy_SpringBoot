package java_test.p01;

public class CounterTest {
	public static void main(String[] args) throws Exception {
		Counter counter = new Counter();
		
		Runnable task1 = () -> {
			// cnt 값을 1000번 증가
			int i = 0;
			while(i < 1000) {
				counter.increment();
				i++;
			}
		};
		
		Runnable task2 = () -> {
			// cnt 값을 1000번 감소
			int i = 0;
			while(i < 1000) {
				counter.decrement();
				i++;
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(counter.getCnt());
	}
}
