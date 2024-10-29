public class PayrollSystem {
    public static void main(String[] args) {
        HourlyEmployee hourlyEmp = new HourlyEmployee(1, "Alice", "Teaching Assistant", 25.0, 40);
        SalariedEmployee salariedEmp = new SalariedEmployee(2, "Bob", "Professor", 4000.0);
        ExecutiveEmployee execEmp = new ExecutiveEmployee(3, "Carol", "Dean", 8000.0, 15.0);

        System.out.println("Hourly Employee Details:");
        hourlyEmp.displayInfo();
        
        System.out.println("\nSalaried Employee Details:");
        salariedEmp.displayInfo();
        
        System.out.println("\nExecutive Employee Details:");
        execEmp.displayInfo();
    }
}
