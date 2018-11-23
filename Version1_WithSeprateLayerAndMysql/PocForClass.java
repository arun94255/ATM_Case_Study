package working.horrorisnotnecessary;

import java.lang.reflect.Method;

public class PocForClass {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		
		
		Object o = f1();
		Class c = o.getClass();
		System.out.println(c.getName());
		if(o instanceof B)
		{
		
			Method m = c.getMethod("f3", null);
			System.out.println("f3 is found");
		}
		else
			System.out.println("what we got is not B something else");
		
		
		//c is a Class class object for B class 
		
		//I will get the Class class object for the class to which the object o is pointing to.
		
		
		
		
		
		
		
		
		
		/*// TODO Auto-generated method stub
		Object o = "hello";
		Object o1 = "hello";
		
		//you want to know whether o and o1 point to objects of same class or differnet class
		
		if(o.getClass() == o1.getClass())
			System.out.println("the both belong to same class");
		else
			System.out.println("they dont belong to same class");
		
	*/	
	
		
		
		
		
		
		
		
		
		

	}

	//assume this code you dont know
	private static Object f1() {
		// TODO Auto-generated method stub
		return new Integer(3);
	}

}
