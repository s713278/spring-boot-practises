package com.srtech;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component(value = "mathService")
public class MathService {
	public String getLuckyNumber(String name){
			Random random= new Random();
			try {
				Thread.sleep(1000); //1 Second
				return "Hey "+name+"! Your Lucky Numer is :"+random.nextInt();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hey "+name+"! Your Lucky Numer is :-1";
		}
}

