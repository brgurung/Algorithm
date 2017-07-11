import java.util.EnumSet;

public class TestEnum {

	public enum SimpleColorEnum
	{
		RED,
		BLUE,
		GREEN,
		ORANGE
	};
	
	public enum ComplexBookEnum
	{
		JAVA("Head First Java", 10),
		ANDROID("Head First Android", 8),
		DSP("Image Processing", 5),
		CPLUSPLUS("Effective C++", 9);
		
		private final String name;
		private final int rating;
		
		ComplexBookEnum(String name, int rating)
		{
			this.name = name;
			this.rating = rating;
		}
		
		public String getName()
		{
			return name;
		}
		
		public int getRating()
		{
			return rating;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(SimpleColorEnum.GREEN);
		
		for(ComplexBookEnum book: ComplexBookEnum.values())
		{
			System.out.println(book + " : " + book.getName() + " " + book.getRating());
		}
		
		
		System.out.println(EnumSet.range(ComplexBookEnum.JAVA, ComplexBookEnum.DSP));
	}
}
