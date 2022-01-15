module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens ChatClient to javafx.fxml;
    exports ChatClient;
}