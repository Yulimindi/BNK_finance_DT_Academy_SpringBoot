package java_test.p01;

public class ThreadEx01_1 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Runnable task1 = () -> {
			System.out.println("짝수 출력 시작");
			for(int a : arr) {
				if(a % 2 == 0) {
					System.out.print(a + " ");
				}
			}
			System.out.println("");
		};
		
		Runnable task2 = () -> {
			System.out.println("홀수 출력 시작");
			for(int a : arr) {
				if(a % 2 != 0) {
					System.out.print(a + " ");
				}
			}
			System.out.println("");
		};
		
		Runnable task3 = () -> {
			int result = 0;
			System.out.println("합 출력 시작");
			for(int a : arr) {
				result += a;	
			}
			System.out.println(result);
		};
		
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		Thread t3 = new Thread(task3);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	
	
	
}
