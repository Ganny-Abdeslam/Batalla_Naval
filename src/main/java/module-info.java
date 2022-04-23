module com.example.batallanaval {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.batallanaval to javafx.fxml;
    exports com.example.batallanaval;
    exports com.example.batallanaval.controller;
    opens com.example.batallanaval.controller to javafx.fxml;
}