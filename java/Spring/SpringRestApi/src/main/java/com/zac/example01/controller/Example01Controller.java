package com.zac.example01.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zac.example01.bl.Example01BizLogic;
import com.zac.example01.model.Example01RequestDto;
import com.zac.example01.model.Example01ResponseDto;

@RestController
public class Example01Controller {

	@Autowired
	private Example01BizLogic bizlogic;

	@PostMapping(value = "/name")
	public ResponseEntity<Example01ResponseDto> getBalanceInfo(HttpServletResponse response,
			@RequestBody Example01RequestDto requestDto,
			BindingResult result) {

		// BL
		Example01ResponseDto responseDto = bizlogic.getInfoById(requestDto);

		// return
		return new ResponseEntity<Example01ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/name/{id}")
	public ResponseEntity<Example01ResponseDto> getBalanceInfo(@PathVariable String id) {

		Example01RequestDto requestDto = new Example01RequestDto();
		requestDto.setId(id);
		// BL
		Example01ResponseDto responseDto = bizlogic.getInfoById(requestDto);

		/**/
		//int a=0,b=1;a=b/a;
		// */
		
		// return
		return new ResponseEntity<Example01ResponseDto>(responseDto, HttpStatus.OK);
	}

}
