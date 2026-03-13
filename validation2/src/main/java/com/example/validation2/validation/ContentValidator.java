package com.example.validation2.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// 검증 처리 객체 직접 만들기
public class ContentValidator implements Validator {
	@Override // 검증 가능한 클래스인지 확인 (정형화 되어있음 return의 클래스 명만 바꿔주면 됨)
	public boolean supports(Class<?> clazz) {
		// clazz가 ContentDto 이거나 ContentDto의 자식 클래스인지 확인
		return ContentDto.class.isAssignableFrom(clazz);
	}
	
	@Override // 실제 검증 로직
	public void validate(Object target, Errors errors) {
		ContentDto dto = (ContentDto)target;
		
//		String sWriter = dto.getWriter();
//		if(sWriter == null || sWriter.trim().isEmpty()) {
//			System.out.println("Writer is null or empty");
//			errors.rejectValue("writer", "trouble");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "writer is empty");
		String sWriter = dto.getWriter();
		if(sWriter.length() < 3) {
			errors.rejectValue("writer", "writer is too short");
		}
		
//		String sContent = dto.getContent();
//		if(sContent == null || sContent.trim().isEmpty()) {
//			System.out.println("Content is null or empty");
//			errors.rejectValue("content", "trouble"); // 에러 메시지를 따로 기록
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content is empty");
	}
}
