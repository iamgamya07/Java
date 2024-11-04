// Derived class: SalariedEmployee
public class SalariedEmployee extends Employee {
    private double monthlySalary;

    // Constructor
    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = validateSalary(monthlySalary);
    }

    // Validation for monthly salary
    private double validateSalary(double salary) {
        return salary >= 0 ? salary : 0; // Ensure monthly salary is non-negative
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary() {
        return monthlySalary / 4; // Assuming a 4-week month
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.15; // Example: 15% of weekly salary as bonus
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Monthly Salary: $" + monthlySalary);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
        System.out.println("Bonus: $" + calculateBonus());
    }
}
