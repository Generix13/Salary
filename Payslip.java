import java.text.NumberFormat;
import java.util.Locale;

public class Payslip {
    public static void main(String[] args) {
        // Use a standard currency formatter
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        // Employee Information
        String employeeName = "Magdalena Leones";
        double grossMonthlySalary = 35000.00;
        int regularWorkingDays = 21;

        // Daily and Hourly Rates
        double dailySalary = grossMonthlySalary / regularWorkingDays;
        double hourlyRate = dailySalary / 8;

        // Absences and Leaves
        int absentDays = 5;
        int leaveCredits = 3;
        int netAbsentDays = absentDays - leaveCredits;
        double lateHours = 0.5; // 30 mins

        // Computations
        double absentDeduction = netAbsentDays * dailySalary;
        double lateDeduction = (lateHours / 8) * dailySalary;
        double totalDeductionAbsences = absentDeduction + lateDeduction;
        double netPayAfterAbsences = grossMonthlySalary - totalDeductionAbsences;

        // Mandatory Deductions
        double sssRate = 0.045; // 4.5%
        double sss = netPayAfterAbsences * sssRate;
        double pagibig = 200.00;
        double withholdingTaxRate = 0.1; // 10% Tax
        double withholdingTax = netPayAfterAbsences * withholdingTaxRate; // 10%
        double totalMandatoryDeductions = sss + pagibig + withholdingTax;

        // Adjustments
        double latePagibigMonths = 2;
        double pagibigAdjustment = 200.00 * latePagibigMonths;

        // Final Computation
        double netPay = netPayAfterAbsences - totalMandatoryDeductions - pagibigAdjustment;

        // Display Payslip
        System.out.println("=======================================");
        System.out.println("            PAYSLIP SUMMARY            ");
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("Employee: " + employeeName);
        System.out.println("Gross Monthly Salary: PhP " + formatter.format(grossMonthlySalary));
        System.out.println("Regular Working Days: " + regularWorkingDays + " days");
        System.out.println("Daily Rate: PhP " + formatter.format(dailySalary));
        System.out.println("Hourly Rate: PhP " + formatter.format(hourlyRate));
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("Absent: " + absentDays + " days = PhP " + formatter.format(absentDays * dailySalary));
        System.out.println("Leave Credits: " + leaveCredits + " days = PhP " + formatter.format(leaveCredits * dailySalary));
        System.out.println("Net Absent: " + netAbsentDays + " days = PhP " + formatter.format(absentDeduction));
        System.out.println("Late: " + lateHours + " hrs = PhP " + formatter.format(lateDeduction));
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("Net Pay After Absences: PhP " + formatter.format(netPayAfterAbsences));
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("SSS (4.5%): PhP " + formatter.format(sss));
        System.out.println("Pag-Ibig: PhP " + formatter.format(pagibig));
        System.out.println("W/Tax (10%): PhP " + formatter.format(withholdingTax));
        System.out.println("Total Deductions: PhP " + formatter.format(totalMandatoryDeductions));
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("Adjustments: Late Pag-Ibig (" + (int)latePagibigMonths + " months) = PhP " + formatter.format(pagibigAdjustment));
        System.out.println("");
        System.out.println("---------------------------------------");
        System.out.println("");
        System.out.println("NET PAY: PhP " + formatter.format(netPay));
        System.out.println("");
        System.out.println("=======================================");
    }
}
