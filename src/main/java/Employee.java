import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee {
    private static final BigDecimal COEFFICIENTS_SALARY = BigDecimal.valueOf(0.06);
    private String name;
    private String dob;
    private String role;
    private String startdate;
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    private int getAge() {
        LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.BASIC_ISO_DATE);
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    private Period getSenior() {
        LocalDate seniorDate = LocalDate.parse(startdate, DateTimeFormatter.BASIC_ISO_DATE);
        return Period.between(seniorDate, LocalDate.now());
    }

    private String calculateSalary(int yearSenior) {
        BigDecimal currentSalary = salary.multiply(COEFFICIENTS_SALARY.add(BigDecimal.ONE).pow(yearSenior));
        return NumberFormat.getIntegerInstance().format(currentSalary);
    }

    @Override
    public String toString() {
        int yearSenior = getSenior().getYears();
        int monthSenior = getSenior().getMonths();
        return "Nhân viên: " + name + "\n"
                + "Tuổi: " + getAge() + "\n"
                + "Thâm niên: " + yearSenior + " năm " + monthSenior + " tháng\n"
                + "Lương hiện tại: " + calculateSalary(yearSenior) + "\n";
    }
}
