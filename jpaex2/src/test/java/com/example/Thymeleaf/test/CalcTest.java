package com.example.Thymeleaf.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Thymeleaf.dto.Member;
import com.example.Thymeleaf.dto.Memo;
import com.example.Thymeleaf.repository.MemberRepository;

public class CalcTest {
	
	int add(int n1, int n2) {
		return n1 + n2;
	}
	
	@Test
	@Disabled
	public void plus() {
		int result = add(1, 3);
//		if(result == 4) {
//			System.out.println("정상");
//		}
//		System.out.println("비정상");
//		assertEquals(5, result);
		assertNotEquals(5, result);
	}
	
	@Test
	@Disabled
	void tfTest() {
		assertTrue(1>3);
		
	}
	
	@Test
	@Disabled
	void nullTest() {
		Member m = null;
		assertNull(m);
	}
	
	@Test
	@Disabled
	void arrayTest() {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		
		assertArrayEquals(arr1, arr2);
		
	}
	
	@Test
	@Disabled
	void exceptionTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			f();
		});
	}
	
	@Test
	@Disabled
	void f() {
		int[] a = {1, 2, 3, 4};
		a[4] = 4;
	}
	
}
