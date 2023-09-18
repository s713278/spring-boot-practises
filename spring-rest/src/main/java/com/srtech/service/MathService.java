package com.srtech.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
		array[1] = 1;
		for (int i = 2; i < size; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array;
	}

	public List<Integer[]> getFebancciSeries() {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<Integer[]> result = null;
		List<Callable<Integer[]>> callable = Arrays.asList(() -> febanacciSeries(3), () -> febanacciSeries(5),
				() -> febanacciSeries(8));

		try {
			List<Future<Integer[]>> futures = executorService.invokeAll(callable);
			boolean allcompleted = false;
			do {
				long incompletedJobCnt = futures.stream().filter(future -> !future.isDone()).count();
				System.out.println("incompletedJobCnt \t::" + incompletedJobCnt);
				if (incompletedJobCnt == 0) {
					allcompleted = true;
				}

			} while (!allcompleted);
			try {
				result = futures.stream()
						.map(future -> {
							try {
								return future.get();
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (ExecutionException e) {
								e.printStackTrace();
							}
							return null;
						})
						.collect(Collectors.toList());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		if (!executorService.isShutdown()) {
			executorService.shutdownNow();
		}
		System.out.println("");
		return result;
	}
}
