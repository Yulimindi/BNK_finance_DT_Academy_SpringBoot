package java_test.p01;

public class ThreadEx01 {
	public static void main(String[] args) throws Exception {
//		Thread t = new MyThread();
//		t.run();
//		t.start();
//		Thread t2 = new Thread(new MyThread2());
//		t2.start();
//		
//		Runnable task = () -> { // 런 함수 정의 (함수형 인터페이스라서 람다로 표현 가능.)
//			System.out.println("----------");
//		};
//		
//		Thread t3 = new Thread(task);
//		t3.start();
		
		SumTask sum1 = new SumTask(1, 50);
		SumTask sum2 = new SumTask(51, 100);
		
		Thread t1 = new Thread(sum1, "말차"); // 스레드 이름 붙이기
		Thread t2 = new Thread(sum2, "녹차");
		
		t1.start();
		t2.start();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		t1.join();
		t2.join();
 
		int r1 = sum1.getResult();
		int r2 = sum2.getResult();
		int result = r1 + r2;
		System.out.println(Thread.currentThread().getName() + " -> 결과 : " + result);
		
		
		
		System.out.println("메인 스레드 끝");
	}
}
