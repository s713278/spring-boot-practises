package com.srtech;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		return null;
	}
	
}
public class VirtualThreadDemo {

	public Integer getNext() {
		try {
			Thread.sleep(100);
			return new Random().nextInt(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public static void main(String[] args) {
		//var executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		var executor=Executors.newVirtualThreadPerTaskExecutor();
		List<Future<Integer>> result=new ArrayList<>();
		for(int i=1;i<1000;i++) {
			final int num=i;
			Future<Integer> future= executor.submit(()->new VirtualThreadDemo().getNext());
			result.add(future);
		}
		System.out.println("Size :"+result.size());
		result.parallelStream().forEach(future->{
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
		executor.shutdown();
	}

}
