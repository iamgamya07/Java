// Derived class: ExecutiveEmployee
public class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    // Constructor
    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = validateBonusPercentage(bonusPercentage);
    }

    // Validation for bonus percentage
    private double validateBonusPercentage(double percentage) {
        return (percentage >= 0 && percentage <= 100) ? percentage : 0; // Ensure percentage is within 0-100%
    }

    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double additionalBonus = (getMonthlySalary() * 12) * (bonusPercentage / 100); // Annual bonus calculation
        return baseBonus + additionalBonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Total Bonus: $" + calculateBonus());
    }

    public double getMonthlySalary() {
        return super.calculateWeeklySalary() * 4; // Access monthly salary via weekly calculation
    }
}
