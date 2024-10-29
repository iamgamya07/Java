// Derived class: HourlyEmployee
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    // Constructor
    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = validateRate(hourlyRate);
        this.hoursWorked = validateHours(hoursWorked);
    }

    // Validation methods
    private double validateRate(double rate) {
        return rate >= 0 ? rate : 0; // Ensure hourly rate is non-negative
    }

    private int validateHours(int hours) {
        return hours >= 0 ? hours : 0; // Ensure hours worked is non-negative
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.10; // Example: 10% of weekly salary as bonus
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
        System.out.println("Bonus: $" + calculateBonus());
    }
}
