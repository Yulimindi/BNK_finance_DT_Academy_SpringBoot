package streamEx;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ann", "Ben", "Cindy", "David", "Ben");
		
		// 리스트 - 스트림화 - 조건부 (자료 거르는 작업) - 순서대로 처리 (최종 연산)
		// 리스트 스트림 - 중간 연산 - 최종 연산
		
		// 1. filter - 조건에 맞는 요소만
		// 글자 수가 4 이상인(중간 연산) 이름만 출력(최종 연산)하자
		names.stream()
			 .filter(name -> name.length() >= 4) // 중간 연산
//			 .forEach(name -> System.out.println(name)); // 최종 연산
			 .forEach(System.out::println); // 더블 콜론 : 메서드 참조		
		
		// 2. map - 변환 : 대문자로 변환하기
		System.out.println("[ map() : 대문자로 변환하기 ]");
		names.stream()
			 .map(String::toUpperCase)
			 .forEach(str -> System.out.println(str)); // 이거 메서드 참조로 바꿀 수 있음
	
		// 3. flatMap - 스트림 평탄화
		System.out.println("[ flatMap() : 문자열을 문자로 ]");
		List<String> words = Arrays.asList("Hello", "World");
		words.stream()
			 .flatMap(word -> Arrays.stream(word.split("")))
			 .forEach(System.out::print);
		System.out.println();
		
		// 4. distinct - 중복 제거
		System.out.println("[ distinct : 중복 제거 ]");
		names.stream()
			 .filter(name -> name.length() < 4)
			 .distinct()
			 .forEach(System.out::println);
		
		// 5. sort - 정렬
		System.out.println("[ sorted : 정렬 ]");
		names.stream()
			 .distinct()
			 .sorted()
			 .forEach(System.out::println);
		
		// 6. limit() - 개수 제한
		System.out.println("[ limit : 개수 제한 ]");
		names.stream()
			 .limit(3)
			 .forEach(System.out::println);
		
		// 7. skip() - 건너뛰기
		System.out.println("[ skip : 건너뛰기 ]");
		names.stream()
			 .skip(2)
			 .forEach(System.out::println);
		
		// 8. peek() - 디버깅
		System.out.println("[ peek : 디버깅 ]");
		long count = names.stream()
						  .peek(s -> System.out.println("처리 전 : " + s))
						  .filter(s -> s.length() >= 4)
						  .peek(s -> System.out.println("처리 후 : " + s))
						  .count();
		System.out.println("개수 : " + count);
		
		// 9. 중간 연산 체이닝
		System.out.println("[ 중간 연산 체이닝 ]");
		names.stream()
			 .filter(s -> s.length() >= 4)
			 .map(String::toUpperCase)
			 .distinct()
			 .sorted()
			 .limit(2)
			 .forEach(System.out::println);
			 
	}
}
