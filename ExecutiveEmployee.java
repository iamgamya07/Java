// Further derived class ExecutiveEmployee
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary); // Using super to call SalariedEmployee constructor
        this.bonusPercentage = bonusPercentage;
    }

    // Overriding calculateBonus to add executive bonus based on percentage
    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus(); // Calling SalariedEmployee's calculateBonus using super
        return baseBonus + (getMonthlySalary() * 12 * (bonusPercentage / 100)); // Annual bonus based on percentage
    }

    // Display detailed information for ExecutiveEmployee
    public void displayInfo() {
        super.displayInfo(); // Calling SalariedEmployee's displayInfo using super
        System.out.println("Annual Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Executive Bonus: $" + calculateBonus());
    }
}
