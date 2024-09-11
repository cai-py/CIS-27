public class FullTimeEmployee extends Person {
    private String department;
    private Double salary;

    //constructor
    public FullTimeEmployee (String firstName, String lastName, String department, double salary) {
        super(firstName, lastName);
        this.department = department;
        this.salary = salary;
    }

    // get methods
    public String getDepartment() {return department;}
    public Double getSalary() {return salary;}

    // set methods
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}