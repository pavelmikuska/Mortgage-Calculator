/*
 * Created by Pavel Mikuska
 */

package com.pavelmikuska.mortgagecalculatorfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.text.DecimalFormat;

public class CalculatorController {
    DecimalFormat decimalFormat = new DecimalFormat( "#,###,###,##0.00" );
    InputValidator inputValidator = new InputValidator();

    @FXML
    private Label messageLabel;
    @FXML
    private TextField mortgageTextField;
    @FXML
    private TextField interestRateTextField;
    @FXML
    private TextField periodTextField;
    @FXML
    private Label monthlyPaymentLabel;
    @FXML
    private Label mortgageValueLabel;
    @FXML
    private Label totalInterestLabel;
    @FXML
    private Label totalSumLabel;

    @FXML
    private void handleCalculateButtonAction(ActionEvent event) {
        String mortgage = mortgageTextField.getText().replaceAll(",", ".");
        String interestRate = interestRateTextField.getText().replaceAll(",", ".");
        String period = periodTextField.getText().replaceAll(",", ".");

        // validate input
        if (!inputValidator.isValid(mortgage, 5000, 2000000)) {
            messageLabel.setText("Enter mortgage in range between 5 000 and 2 000 000");
            return;
        }
        if (!inputValidator.isValid(interestRate, 0.1, 20)) {
            messageLabel.setText("Enter interest rate between 0,1 and 20");
            return;
        }
        if (!inputValidator.isValid(period, 5, 30)) {
            messageLabel.setText("Enter years period between 5 and 30");
            return;
        }

        // calculation and printing result if input is valid
        messageLabel.setText("");
        MortgageCalculator calculator = new MortgageCalculator(
                Double.parseDouble(mortgage),
                Double.parseDouble(interestRate),
                Double.parseDouble(period)
        );

        monthlyPaymentLabel.setText(decimalFormat.format(calculator.calculateMonthlyPayment()));
        mortgageValueLabel.setText(decimalFormat.format(calculator.getMortgage()));
        totalInterestLabel.setText(decimalFormat.format(calculator.calculateTotalInterest()));
        totalSumLabel.setText(decimalFormat.format(calculator.calculateMortgageCosts()));
    }


}