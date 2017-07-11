
public class Employee {
    private String firstName;
    private String lastName;
    private Integer employeeId;
    private double salary;
    private String department;
    
    public Employee(String firstName, String lastName, Integer employeeId, double salary, String department)
    {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.employeeId = employeeId;
    	this.department = department;
    	this.salary = salary;
    }
    
    public String getFirstName()
    {
    	return firstName;
    }
    
    public String getLastName()
    {
    	return lastName;
    }
    
    public Integer getEmployeeId()
    {
    	return employeeId;
    }
    
    public String getDepartment()
    {
    	return department;
    }
    
    public String getName()
    {
    	return (firstName + " " + lastName);
    }

    public double getSalary()
    {
    	return salary;
    }

    @Override
    public String toString()
    {
    	return String.format("%-8s %-8s %8d %8.2f %s", getFirstName(), getLastName(), getEmployeeId(), getSalary(), getDepartment());
    }
}
