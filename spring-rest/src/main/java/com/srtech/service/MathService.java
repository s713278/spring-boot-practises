package com.srtech.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MathService {

	/**
	 * <p>
	 * <p/>
	 * 
	 * @param size
	 * @return
	 */
	private Integer[] febanacciSeries(int size) {
		Integer[] array = new Integer[size];
		array[0] = 1;
		if(size==1) {
			return array;
		}
		array[1] = 1;
		if(size==2) {
			return array;
		}
		for (int i = 2; i < size; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array;
	}

	public List<Integer[]> getFebancciSeries(int howMany) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		//ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
		List<Integer[]> result = new ArrayList<>();
		List<Callable<Integer[]>> callable = new ArrayList<>(); // Arrays.asList(() -> febanacciSeries(3), () -> febanacciSeries(5),
			//	() -> febanacciSeries(8));
		
		for(int i=1;i<=howMany;i++) {
			final int size= i; 
			callable.add(()->{return febanacciSeries(size);});
		}
		
		try {
			List<Future<Integer[]>> futures = executorService.invokeAll(callable);
			futures.stream().forEach((future)->{
				try {
					result.add(future.get());
					System.out.println("Series :"+Arrays.toString(future.get()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			});
		}catch (Exception e) {
			
		}
		if (!executorService.isShutdown()) {
			executorService.shutdownNow();
		}
		System.out.println("");
		return result;
	}
	
	
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
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a,int b) {
		return a+b;
	}
}
