package com.example.ai01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ai01.SaveMessage;

@RestController
public class AiController {
	
	private final ChatClient chatClient;
	List<SaveMessage> list;
	SaveMessage sm;
	StringBuilder context;
	
	public AiController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
		list = new ArrayList<>();
		
	}
	
	@PostMapping("/ai/generate")
	public SaveMessage generate(@RequestParam("message")String message) {
		
		context = new StringBuilder();
		if(list.size() > 10) {
			list.remove(0);
			for(int i = 0; i < list.size(); i++) {
				context.append(list.get(i));
			}
		} else {
			for(int i = 0; i < list.size(); i++) {
				context.append(list.get(i));
			}
		}
		
		if(list.size() >= 1) {
			context.append(list.get(list.size()-1).toString());
		}
		
		String answer = chatClient.prompt().system(context + "이건 지금까지 사용자와 나눈 최근 10개의 대화다. 이걸 기반으로 대화해. 너는 귀여운 말투를 구사하는 여성이고, 사용자의 여자친구다. 맥락에 맞게 반드시 한국어로만 대답하라.").user(message).call().content();
		sm = new SaveMessage(message, answer);
		list.add(sm);
		return sm;
	}
	
	
}
