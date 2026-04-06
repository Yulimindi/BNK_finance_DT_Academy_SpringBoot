package streamEx;

import java.util.stream.IntStream;

public class IntStreamEx {
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10)
				 .filter(n -> n % 2 == 0)
				 .forEach(System.out::println);
		
		int sum = IntStream.of(1, 2, 3, 4, 5)
						   .sum();
		
		System.out.println("Sum : " + sum);
		
		double avg = IntStream.of(1, 2, 3, 4, 5)
							  .average()
							  .orElse(0);
		System.out.println("평균 : " + avg);
	}
}
