module com.pavelmikuska.mortgagecalculatorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pavelmikuska.mortgagecalculatorfx to javafx.fxml;
    exports com.pavelmikuska.mortgagecalculatorfx;
}