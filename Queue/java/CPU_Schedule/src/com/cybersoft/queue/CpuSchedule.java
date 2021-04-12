package com.cybersoft.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CpuSchedule {
	final static int MAX_THREAD = 2;
	public static void main(String[] args) {
		System.out.println("Main thread running... ");

		String task[] = { "task 1", "task 2", "task 3", "task 4", "task 5" };
		Queue<String> queueCpu = new LinkedList<String>();
		queueCpu.addAll(Arrays.asList(task));

		RunnableDemo R1 = new RunnableDemo("Thread-1-HR-Database");
		R1.start();

		RunnableDemo R2 = new RunnableDemo("Thread-2-Send-Email");
		R2.start();
		
//		for (int i = 0; i < task.length; i++) {
//			
//		}
		
		if (R1.isDone()==false) {
			System.out.println("Chua hoan thanh R1");
		}

		System.out.println("==> Main thread stopped!!! ");
	}

}
