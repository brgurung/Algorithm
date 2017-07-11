import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.function.Function;
import java.util.Map;
import java.util.stream.Collectors;

public class TestLambdaStreamEmployee {

	
	public static void main(String[] args)
	{
		// Create list of employees and print
		Employee[] employee = {
				new Employee("Jason", "Red", 1234, 5000, "IT"),
				new Employee("Ashley", "Green", 1235, 7000, "IT"),
				new Employee("Matthew", "Indigo", 2000, 3587, "Sales"),
				new Employee("James", "Indigo", 2010, 4700, "Marketing"),
				new Employee("Jason", "Blue", 4000, 3200, "Sales")
		};
		
		List<Employee> list = Arrays.asList(employee);
		System.out.println("Employee List: ");
		Arrays.stream(employee).forEach(System.out::println);
		
	    Predicate<Employee> fourToSevenThousand = e -> (e.getSalary() >= 2000 && e.getSalary() <= 7000);
		
	    System.out.println("Employee earning 2k-4k per month: ");
	    list.stream()
	    	.filter(fourToSevenThousand)
	    	.sorted(Comparator.comparing(Employee::getSalary))
	    	.forEach(System.out::println);
	    
	    /*
	    list.stream()
    	.filter(fourToSevenThousand)
    	.sorted(Comparator.comparing(e -> e.getSalary()))
    	.forEach(System.out::println);
	     */
	    
	    // display first employee with 2k-7k salary
	    list.stream()
	    	.filter(fourToSevenThousand)
	    	.findFirst()
	    	.get();
	    
	    // get array from the stream
	    Employee[] nameWithJ = 
	    		list.stream()
	    			.filter(e-> e.getName().toUpperCase().startsWith("J"))
	    			.toArray(Employee[]::new); // toArray() without argument doesn't work. it returns compilation error.
	    
	    System.out.println("Name starting with J: " + Arrays.asList(nameWithJ));
	    
	    
	    // sort by multiple fileds - first and last name
	    Function<Employee, String> byFirstName = Employee::getFirstName;
	    Function<Employee, String> byLastName = e -> e.getLastName();
	    
	    Comparator<Employee> lastThenFirst = Comparator.comparing(byFirstName).thenComparing(byLastName);
	    
	    System.out.println("Employes in ascending order by name: ");
	    list.stream()
	    	.sorted(lastThenFirst)
	    	.forEach(System.out::println);
	    
	    System.out.printf("%nEmployees in descending order by name: %n");
	    list.stream()
	    	.sorted(lastThenFirst.reversed())
	    	.forEach(System.out::println);
	    
	    // Display unique last name
	    System.out.println("Unique last name: ");
	    list.stream()
	    	.map(Employee::getLastName)
	    	.distinct()
	    	.sorted()
	    	.forEach(System.out::println);
	    
	    // Grouping by department
	    Function<Employee, String> byDepartment = Employee::getDepartment;
	    
	    Map<String, List<Employee>> groupedByDepartment = list.stream().collect(Collectors.groupingBy(byDepartment));
	 
	    groupedByDepartment.forEach(
	    		(department, employeeInDepartment) -> {
	    			System.out.printf("%n%s%n", department);
	    			employeeInDepartment.forEach(System.out::println);
	    		}
	    	);
	    
	    //sum of employee salaries
	    System.out.printf("%nSum of employees' salaries: %.2f%n",
	    		list.stream()
	    			.mapToDouble(Employee::getSalary)
	    			.sum());
	}
}
