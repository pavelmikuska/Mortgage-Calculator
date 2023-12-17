/*
 * Created by Pavel Mikuska
 */

package com.pavelmikuska.mortgagecalculatorfx;

public class MortgageCalculator {
    private double mortgage;

    private double monthlyInterestRate;
    private int numberOfPayments;
    public MortgageCalculator(double mortgage, double interest, double period) {
        this.mortgage = mortgage;
        monthlyInterestRate = interest / 12 / 100;
        numberOfPayments  = (int ) period * 12;
        System.out.println("Number of payments: " + numberOfPayments);
    }

    public double calculateMonthlyPayment() {
        return (double) (mortgage * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments)
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1));
    }

    public double calculateMortgageCosts() {
        return calculateMonthlyPayment() * numberOfPayments;
    }

    public double calculateTotalInterest() {
        return calculateMortgageCosts() - mortgage;
    }

    public double getMortgage() {
        return mortgage;
    }
}


