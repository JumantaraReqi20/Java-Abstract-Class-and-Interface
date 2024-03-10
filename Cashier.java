package store;

public class Cashier extends AbstractStoreEmployee {
    private double completedSales;

    public Cashier(double numberOfHoursWorked, double hourlyRate, String storeDetails, double basePay, String employeeName, double completedSales) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, employeeName);
        this.completedSales = completedSales;
    }

    @Override
    public int countDay(double jamKerja) {
        return ((int) jamKerja / 24);
    }

    @Override
    public double calculateTaxShop(double completedSales) {
        return completedSales * 0.1;
    }

    @Override
    public void assignTask(String task) {
        System.out.println(getEmployeeName() + " has been assigned the task: " + task);
    }

    @Override
    public double calculatePay() {
        double totalPay = getBasePay() + (getNumberOfHoursWorked() * getHourlyRate());
        return totalPay - calculateTaxShop(completedSales); // Menyimpan pajak dari penjualan yang dilakukan
    }

    @Override
    public boolean checkPromotionEligibility() {
        // Logika untuk mengecek kelayakan promosi Cashier
        if (getNumberOfHoursWorked() >= 40 && completedSales >= 1000) {
            return true;
        } else {
            return false;
        }
    }

    // Getters and Setters for completedSales
    public double getCompletedSales() {
        return completedSales;
    }

    public void setCompletedSales(double completedSales) {
        this.completedSales = completedSales;
    }
}