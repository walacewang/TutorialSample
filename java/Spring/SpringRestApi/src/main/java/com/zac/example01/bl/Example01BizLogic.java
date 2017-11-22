package com.zac.example01.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zac.config.message.BundleMessageSource;
import com.zac.example01.model.Example01RequestDto;
import com.zac.example01.model.Example01ResponseDto;
import com.zac.service.Example01Service.Example01Service;


@Component
public class Example01BizLogic {

	@Value("${door.key}")
	private String doorKey;

	@Autowired
	private BundleMessageSource messageSource;
	
	@Autowired
	private Example01Service service;


	public Example01ResponseDto getInfoById(Example01RequestDto requestDto) {


		String name = service.getNameById(requestDto.getId());
		Example01ResponseDto responseDto = new Example01ResponseDto();
		
		responseDto.setName(name);
		responseDto.setDoorKey(doorKey);
		responseDto.setWelcomeMessage(messageSource.getBizErrorResponse("000").getError_description());
		
		// return
		return responseDto;
	}
}
