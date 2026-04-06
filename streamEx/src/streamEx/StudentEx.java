package streamEx;

import java.util.Arrays;
import java.util.List;

public class StudentEx {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Ann", 90, 80, 88),
				new Student("Benjamin", 75, 80, 70),
				new Student("Cindy", 95, 92, 96),
				new Student("David", 65, 70, 68),
				new Student("Eve", 88, 90, 85)
				);
		
		// 1. 평균 80점 이상인 학생
		System.out.println("▼ 평균 80점 이상인 학생 ▼");
		students.stream().filter(s -> s.getAverage() >= 80)
						 .forEach(System.out::println);
		
		
		// 2. 총점 높은 순으로 정렬하여 상위 3명
		System.out.println("▼ 총점 높은 순으로 정렬하여 상위 3명 ▼");
		students.stream().filter(s -> s.getTotal() >= 0)
						 .sorted((a, b) -> b.getTotal() - a.getTotal()) // 양수가 나오면 내림차순 음수면 오름차순
						 .limit(3)
						 .forEach(System.out::println);
		
		
		// 3. 모든 학생 이름 리스트
		System.out.println("▼ 모든 학생 이름 리스트 ▼");
		List<Student> joined = students.stream().toList();
		System.out.println(joined);
	}
}
