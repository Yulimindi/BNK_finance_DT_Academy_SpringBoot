package com.example.testPrj.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.testPrj.dto.UserRequestDto;
import com.example.testPrj.dto.UserResponseDto;
import com.example.testPrj.service.UserService;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockitoBean
	private UserService us;
	
	@Autowired
	private ObjectMapper om;
	
	@Test
	@DisplayName("사용자 생성 API 테스트")
	void createUser() throws Exception {
		// given
		UserRequestDto request = UserRequestDto.builder().name("홍길동").email("hong@email.com").password("00000000").build();		
		UserResponseDto response = UserResponseDto.builder().id(1L).name("홍길동").email("hong@email.com").build();
		
		given(us.createUser(any(UserRequestDto.class))).willReturn(response);
		
		// when & then 가짜 서버를 흉내냄
		mvc.perform(post("/api/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(request)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(1L))
			.andExpect(jsonPath("$.name").value("홍길동"))
			.andExpect(jsonPath("$.email").value("hong@email.com"));
			
		then(us).should(times(1)).createUser(any(UserRequestDto.class));
	}
	
	private String asJsonString(Object obj) {
		try {
			return om.writeValueAsString(obj);
		} catch(JacksonException e) {
			throw new RuntimeException(e);
		}
	}
	
}
