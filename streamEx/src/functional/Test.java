package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import dto.Message;

class Box<T> {
	private T ob;
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}


class User {
	
	String username;
	String email;
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + "]";
	}
	
	
}


// 문제 : BiConsumer<T, U>를 기반으로 위 클래스의 인스턴스에 String형, int형, double형 데이터를 저장하는 기능의 
// 람다식을 각각 작성하고 이를 확인하기 위한 예제를 작성하라.

public class Test {
	
	/* 
	 * 미리 정의되어 있는 함수형 인터페이스 4총사 (함수형 인터페이스 : 메서드가 하나)
	 * Predicate<T> boolean test(T t)
	 * Supplier<T> T get()
	 * Consumer<T> void accept(T t)
	 * Function<T, R> R apply(T, t)
	 */
	
	public static void main(String[] args) {
		// Predicate<Integer> p = a -> a % 2 == 0; // test() 메소드 정의한 코드
		// System.out.println(p.test(5));
		
		
		
		
		System.out.println("--------------------");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int s = 0;
		s = sum(n -> n % 2 == 0, list);
		System.out.println("짝수의 합 : " + s);
		
		System.out.println("----------------------");
		
		BiPredicate<String, Integer> bp = (str, m) -> str.length() > m ? true:false;
		
		// test() 호출한 결과 문자열 "GoodBye"의 길이가 3보다 크면 true 반환
		
		if(bp.test("GoodBye", 3)) {
			System.out.println("문자열 길이 3 초과");
		} else {
			System.out.println("문자열 길이 3 이하");
		}
		
		System.out.println("----------------------");
		
		Message m1 = new Message("안녕 좋은 아침", "이름1");
		Message m2 = new Message("월요일 조아", "이름2");
		Message m3 = new Message("하암냐", "이름3");
		
		List<Message> lst = new ArrayList<>();
		lst.add(m1);
		lst.add(m2);
		lst.add(m3);
		
		Predicate<String> check = str -> str.contains("안녕") ? true:false;
		int cnt = 0;
//		for(Message m : lst) {
//			if(bp.test(m.getMessage(), 3)) {
//				System.out.println("작성자 : " + m.getWriter());
//				System.out.println("내용 : " + m.getMessage());
//				System.out.println("이 메시지는 좀 기네용");
//				System.out.println("----------------");
//			} else {
//				System.out.println("작성자 : " + m.getWriter());
//				System.out.println("내용 : " + m.getMessage());
//				System.out.println("이 메시지는 좀 짧네용");
//				System.out.println("----------------");
//			}
//		}
		
		for(Message m : lst) {
			if(check.test(m.getMessage())) {
				System.out.println(m.getMessage());
				System.out.println("'안녕'이란 말이 있어요");
				System.out.println("------------------");
				cnt++;
			} else {
				System.out.println(m.getMessage());
				System.out.println("'안녕'이란 말이 없어요");
				System.out.println("------------------");
			}
		}
		System.out.println("총 " + cnt + "개 있어요");
		
		
		Supplier<Integer> sp = () -> {return 10;};
		
		// Supplier<T> 정의하기
		
		Random r = new Random();
		Supplier<Integer> spr = () -> {return r.nextInt(10) + 1;};
		// 랜덤 수 반환하기 (1 ~ 10)
		// makeList로 새로운 리스트 만들기
		// 만들어진 리스트 출력하기
		
		List<Integer> lst2 = makeIntList(spr, 10);
		for(Integer a: lst2) {
			System.out.println(a);
		}
		
		
		
		Consumer<String> c = data -> System.out.println(data);
		c.accept("안녀엉");
		
		ObjIntConsumer<String> oc = (e, i) -> {
			System.out.println("[" + i + "] " + e);
		};
		
		int n = 1;
		oc.accept("반가웡1", n++);
		oc.accept("반가웡2", n++);
		oc.accept("반가웡3", n);
			 
		
		BiConsumer<Box<String>, String> bc = (Box<String> box, String str) -> {
			box.set(str);
		};
		
		BiConsumer<Box<Integer>, Integer> bc2 = (Box<Integer> box, Integer ing) -> {
			box.set(ing);
		};
		
		BiConsumer<Box<Double>, Double> bc3 = (Box<Double> box, Double dou) -> {
			box.set(dou);
		};
		
		Box<String> b1 = new Box<>();
		bc.accept(b1, "내 마음 속에 저장~");
		
		Box<Integer> b2 = new Box<>();
		bc2.accept(b2, 3);
		
		Box<Double> b3 = new Box<>();
		bc3.accept(b3, 3.0);
		
		System.out.println(b1.get());
		System.out.println(b2.get());
		System.out.println(b3.get());
		
		System.out.println("-----------------");
		
		// Function<T, R> R apply(T, t)
		Function<String, Integer> f = (str) -> {
			return str.length();
		};
		
		System.out.println(f.apply("Robot"));
		
		// DoubleUnaryOperator double applyAsDouble(double operand)
		DoubleUnaryOperator cmToInch = d -> d * 0.393701;
		DoubleUnaryOperator inchToCm = d -> d * 2.54;
		
		System.out.println(cmToInch.applyAsDouble(1.0) + "inch");
		System.out.println(inchToCm.applyAsDouble(1.0) + "cm");
		
		// 두 수 중 큰 수 구하기
		BiFunction<Double, Integer, String> bf = (Double dou, Integer in) -> {
			Double result = 0.0;
			if(dou > in) {
				result = dou;
			} else {
				result = (double)in;
			}
			return result + "가 더 큽니다.";
		};
		
		System.out.println(bf.apply(1.1, 1));
		
		
		// 아이디와 이메일로 User 객체 생성하기
		BiFunction<String, String, String> bf2 = (String username, String email) -> {
			User u = new User(username, email);
			
			return "만들었어용 : " + u.toString();
		};
		
		
		System.out.println(bf2.apply("감자", "냠냠"));
	}
	
	public static List<Integer> makeIntList(Supplier<Integer> spr, int n) {
		List<Integer> lst = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			lst.add(spr.get());
		}
		return lst;
	}
	
	public static int sum(Predicate<Integer> p, List<Integer> lst) {
		int s = 0;
		for(Integer i : lst) {
			if(p.test(i)) {
				s += i;
			}	
		}
		return s;
	}
	
	/*
	 * Predicate<T>를 구체화하고 다양화 한 인터페이스들
	 * - IntPredicate boolean test(int value)
	 * - LongPredicate boolean test(long value)
	 * - DoublePredicate boolean test(double value)
	 * - BiPredicate<T, U> boolean test(T t, U u)
	 */
	
	/*
	 * Supplier<T>를 구체화 한 인터페이스들
	 * - IntSupplier int getAsInt()
	 * - LongSupplier long getAsLong()
	 * - DoubleSupplier double getAsDouble()
	 * - BooleanSupplier double getAsBoolean()
	 */
	
	/*
	 * Consumer<T>를 구체화하고 다양화 한 인터페이스들
	 * IntConsumer void accept(int value)
	 * ObjIntConsumer<T> void accept(T t, int value)
	 * Long Consumer void accept(long value)
	 * ObjLongConsumer<T> void accept(long value)
	 * DoubleConsumer void accept(int value)
	 * ObjDoubleConsumer<T> void accept(int value)
	 * BiConsumer<T, U> void accept(T t, U u)
	 */
	
	/*
	 * Function<T, R>을 구체화하고 다양화 한 인터페이스들
	 * IntToDoubleFunction double applyAsDouble(int value)
	 * DoubleToIntFunction int applyAsInt(double value)
	 * IntUnaryOperator double applyAsDouble(double operand)
	 * BiFunction<T, U, R> R apply(T t, U u)
	 * IntFunction<R> R apply(int value)
	 * DoubleFunction<R> R apply(double value)
	 * ToIntFunction<T> int apply(T value)
	 * ToDoubleFunction<T> double applyAsDouble(T value)
	 * ToIntBiFunction<T, U> int applyAsInt(T t, U u)
	 * ToDoubleBiFunction<T, U> double apply(T t, U u)
	 */
}
