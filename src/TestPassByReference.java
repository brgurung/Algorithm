
public class TestPassByReference
{
    String str = new String("Hello");
    
	private class MyObject
	{
		Integer i;
		
		void set(Integer j)
		{
			i = j;
		}
		
		Integer get()
		{
			return i;
		}
	}
	
	class MyObject2
	{
	    MyObject obj;
	    
	    MyObject2( MyObject obj)
	    {
	    	this.obj = obj;
	    }
	    
	    Integer get()
	    {
	    	return obj.get();
	    }
	}

	public static void main(String [] args)
	{
		TestPassByReference testObj = new TestPassByReference();
		
		System.out.println(testObj.str); // this works fine
		
		// MyObject obj = new testObj.MyObject();  - testObj access not valid			
		MyObject obj = new TestPassByReference().new MyObject();
		// MyObject obj2 = testObj.new MyObject(); - another valid instantiation

		Integer k = 2;
		
		obj.set(k);

		k = 3;
		System.out.println(obj.get());

		MyObject2 obj2 = testObj.new MyObject2(obj);
		System.out.println("Before: " + obj2.get());
		
		obj.set(5);
		
		System.out.println("After: " + obj2.get());
	}

}




