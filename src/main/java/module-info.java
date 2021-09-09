module com.example.facegen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.facegen to javafx.fxml;
    exports com.example.facegen;
}