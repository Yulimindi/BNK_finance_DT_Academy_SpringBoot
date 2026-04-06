package streamEx;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestEndOper {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<String> names = Arrays.asList("James", "Ann", "David", "Benjamin", "Eve");
		
		// 1. forEach - 각 요소 처리
		System.out.println("[ forEach ]");
		names.stream().forEach(System.out::println);
		
		// 2. collect - 컬렉션으로 수집 : forEach와 차이점은 반환 타입이 있다는 것!
		System.out.println("[ collect ]");
		List<String> longNames = names.stream()
									  .filter(s -> s.length() > 3)
									  .collect(Collectors.toList());
		
		System.out.println(longNames);
		
		// 3. toList (Java 16+)
		System.out.println("[ toList ]");
		List<String> upperNames = names.stream()
									   .map(String::toUpperCase)
									   .toList();
		System.out.println(upperNames);
		
		// 4. count - 개수 세기
		System.out.println("[ count ]");
		long evenCount = numbers.stream()
								.filter(n -> n % 2 == 0)
								.count();
		System.out.println(evenCount);
		
		// 5. reduce - 값 누적
		System.out.println("[ reduce ]");
		int sum = numbers.stream()
						 .reduce(0, (a, b) -> a + b); // 초기값을 0으로 주겠다
		System.out.println("합계 : " + sum);
		
		// 문자열 연결
		String concatStr = names.stream()
								.reduce("", (a, b) -> a + ", " + b);
		System.out.println("문자열 연결 : " + concatStr);
		
		// 6. findFirst
		System.out.println("[ findFirst ]");
		Optional<Integer> firstEven = numbers.stream()
											 .filter(n -> n % 2 == 0)
											 .findFirst();
		firstEven.ifPresent(System.out::println);
		
		// 7. anyMatch / allMatch / noneMatch
		System.out.println("[ 매칭 연산 ]");
		boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
		boolean allPositive = numbers.stream().allMatch(n -> n > 0);
		boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
		System.out.printf("짝수 있음 : %s, 모두 양수 : %s, 음수 없음 : %s%n", hasEven, allPositive, noneNegative);
		
		// 8. max / min
		System.out.println("[ max/min ]");
		Optional<Integer> min = numbers.stream().min(Integer::compareTo);
		Optional<Integer> max = numbers.stream().max(Integer::compareTo);
		System.out.println("최소 : " + min.orElse(0) + " 최고 : " + max.orElse(0));
		
		// 9. collect - 그룹 짓기
		System.out.println("[ collect(그룹핑)] ");
		Map<Integer, List<String>> groupByLength = names.stream()
							.collect(Collectors.groupingBy(String::length));
		System.out.println("길이별 그룹 : " + groupByLength);
		
		// 10. collect - joining
		System.out.println("[ collect(조이닝)] ");
		String joined = names.stream()
						.collect(Collectors.joining(", ", "[" , "]"));
		System.out.println(joined);
		
		
	}
}
