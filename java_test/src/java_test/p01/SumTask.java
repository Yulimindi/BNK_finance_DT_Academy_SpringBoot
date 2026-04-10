package java_test.p01;

public class SumTask implements Runnable {
	private int start;
	private int end;
	private int result;
	
	public SumTask(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		this.result = sum;
		System.out.println(Thread.currentThread().getName() + "가 계산을 완료햇서용");
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
}
