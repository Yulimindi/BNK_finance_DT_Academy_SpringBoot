package com.example.secu.auth;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
	public String passwordEncoder(String pw) {
		
		// 마지막에 비밀번호 길이만큼의 아스키코드 문자를 붙이기
		// 하나씩 짤라서 리스트에 넣어서 걔네를 각각 문자면 ~ 숫자면~ 나눠서 10씩 더하기
		char[] list = pw.toCharArray();

		for(int i = 0; i < list.length; i++) {
			if(list[i] >= 'a' && list[i] <= 'z' || list[i] >= 'A' && list[i] <= 'Z') { // 문자면
				int num = (int) list[i];
				num += 4;
				char ch = (char)num;
				list[i] = ch;
			} else { // 숫자면
				list[i] += 6;
				char ch = (char)list[i];
				list[i] = ch;
			}
		}
		
		String secretWord = "";
		for(int i = 0; i < list.length; i++) {
			secretWord += list[i];
		}
		
		secretWord += list.length;
		
		return secretWord;
	}
	
	public String Decryption(String pw) {
		
		// 마지막에 비밀번호 길이만큼의 아스키코드 문자를 붙이기
		// 하나씩 짤라서 리스트에 넣어서 걔네를 각각 문자면 ~ 숫자면~ 나눠서 10씩 더하기
		char[] list = pw.toCharArray();
		for(int i = 0; i < list.length; i++) {
			if(list[i] >= 'A' && list[i] <= '~') { // 문자면
				int num = (int) list[i];
				num -= 4;
				char ch = (char)num;
				list[i] = ch;
			} else { // 숫자면
				list[i] -= 6; 
				char ch = (char)list[i];
				list[i] = ch;
			}
			
		}

		
		String secretWord = "";
		for(int i = 0; i < list.length - 1; i++) {
			secretWord += list[i];
		}
		return secretWord;
	}
}
