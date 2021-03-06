import java.util.Date;

public final class HourlyEmployee extends Employee {

    private final double hourlyWage;
    private final double monthlyHours;

    public HourlyEmployee(HourlyEmployee other) {
        super(other);
        this.hourlyWage = other.hourlyWage;
        this.monthlyHours = other.monthlyHours;
    }

    /**
     * Constructs an HourlyEmployee with hourly wage of 20 and 
     * monthly hours of 160.
     */
    public HourlyEmployee(String aName, Date aHireDate) {
        this(aName, aHireDate, 20.00, 160.0);
    }

    public HourlyEmployee(String aName, Date aHireDate,
                          double anHourlyWage, double aMonthlyHours) {
        super(aName, aHireDate);
        disallowZeroesAndNegatives(anHourlyWage, aMonthlyHours);
        hourlyWage = anHourlyWage;
        monthlyHours = aMonthlyHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getMonthlyHours() {
        return monthlyHours;
    }

    public double monthlyPay() {
        return hourlyWage * monthlyHours;
    }

    public String toString() {
        return getName() + "; Hire Date: " + getHireDate() + "; Hourly Wage: "
            + hourlyWage + "; Monthly Hours: " + monthlyHours;
    }

    private void disallowZeroesAndNegatives(double ... args) {
        boolean shouldThrowException = false;
        String nonPositives = "";
        for (double arg: args) {
            if (arg <= 0.0) {
                shouldThrowException = true;
                nonPositives += arg + " ";
            }
        }
        if (shouldThrowException) {
            String msg = "Following arguments were <= 0: " + nonPositives;
            throw new IllegalArgumentException(msg);
        }
    }
}
