public class HourlyEmployee extends Person {
    private String department;
    private Double hourlyRate;
    private Double hoursPerWeek;

    //constructor
    public HourlyEmployee(String firstName, String lastName, String department, double hourlyRate, double hoursPerWeek) {
        super(firstName, lastName);
        this.department = department;
        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = hoursPerWeek;
    }

    // get methods
    public String getDepartment() {return department;}
    public Double getHourlyRate() {return hourlyRate;}
    public Double getHoursPerWeek() {return hoursPerWeek;}
    public Double getTotalHours() {return hoursPerWeek * 4;}
    public Double getTotalWage() {return hourlyRate * getTotalHours();}

    // set methods
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void setHoursPerWeek(Double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
}

