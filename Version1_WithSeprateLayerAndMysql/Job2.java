package working.horrorisnotnecessary;

import java.util.concurrent.Callable;

public class Job2 implements Callable<Integer> {

	private int i;
	private int j;

	public Job2(int i, int j) {
		// TODO Auto-generated constructor stub
		this.i = i;
		this.j = j;
		
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("this is job2 ");
		return i-j;
	}

}
