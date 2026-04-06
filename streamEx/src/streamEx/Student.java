package streamEx;

import java.util.stream.IntStream;

public class Student {
	
	String name;
	int korean;
	int english;
	int math;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	@Override
	public java.lang.String toString() {
		return this.name;
	}

	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	// getTotal() 함수 구현
	public int getTotal() {
		return IntStream.of(korean, english, math).sum(); 
	}
	
	// double getAverage() 함수 구현
	public double getAverage() {
		return IntStream.of(korean, english, math).average().orElse(0);
	}
}
