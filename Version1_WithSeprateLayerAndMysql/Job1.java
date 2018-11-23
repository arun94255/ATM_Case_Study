package working.horrorisnotnecessary;

import java.util.concurrent.Callable;

public class Job1 implements Callable<Integer> {

	private int i;
	private int j;

	public Job1(int i, int j) {
		// TODO Auto-generated constructor stub
		this.i =i;
		this.j = j;
	}

	@Override
	
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("addition thread job");
		takingTimeToAdd();
		
		
		return i+j;
	}

	private void takingTimeToAdd() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
