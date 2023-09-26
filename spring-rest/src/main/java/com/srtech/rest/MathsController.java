package com.srtech.rest;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srtech.dto.MathRequest;
import com.srtech.dto.MathResponse;
import com.srtech.service.MathService;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/api/maths")
@Slf4j
public class MathsController {
	
	@Autowired
	private MathService mathService;

	@PostMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
	public MathResponse hello(@RequestBody MathRequest input) {
		
		MathResponse response = new MathResponse();
		response.setNo1(input.getNo1());
		response.setNo2(input.getNo2());
		
		Function<MathRequest, Integer> result = t -> {
			Integer result1 =0;
			if("+".equalsIgnoreCase(t.getMathOperator())) {
				return t.getNo1()+t.getNo2();
			}else if("*".equalsIgnoreCase(t.getMathOperator())) {
				result1 = t.getNo1()*t.getNo2();
			}else if("/".equalsIgnoreCase(t.getMathOperator())) {
				result1 = t.getNo1()/t.getNo2();
			}else if("-".equalsIgnoreCase(t.getMathOperator())) {
				result1 = t.getNo1()-t.getNo2();
			}
			return result1;
		};
		response.setResult(result.apply(input));
		return response;
	}
	
	@GetMapping("/febenacci/{howMany}")
	public ResponseEntity<List<Integer[]>> getFebanacciSeries(@PathVariable Integer howMany){
		List<Integer[]>  result = mathService.getFebancciSeries(howMany);
		return new ResponseEntity<List<Integer[]>>(result,HttpStatus.ACCEPTED);
	}
}
