package java_test.p01;

public class Counter {
	private int cnt = 0;
	
	synchronized public void increment() {
		cnt++;
	}
	
	synchronized public void decrement() {
		cnt--;
	}
	
	synchronized public int getCnt() {
		return cnt;
	}
}
