package working.horrorisnotnecessary;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DivideAndConquer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ExecutorService e= Executors.newFixedThreadPool(3);
		Callable c =new Job1(4,5);  //thread1 job
		Callable c2 =new Job2(4,3);  //thread 2 job
		//all we did becuase of 16 and 17 is told what is job thread should do, it will not start
		// we have defined the job.
		
		
		Future<Integer> i = e.submit(c);
		Future<Integer> j = e.submit(c2);
		
		
		try {
			Integer r1 = i.get();
			Integer r2 = j.get();
			System.out.println(r1 * r2);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		e.shutdown();
		
		
		
		

	}

}
