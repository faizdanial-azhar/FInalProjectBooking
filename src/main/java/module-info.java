module com.example.finalprojectbooking {
    requires javafx.controls;
    requires javafx.fxml;

    // Add exports for StudentAuthGUI and FacilityBooking packages
    exports StudentAuthGUI;
    exports FacilityBooking;

    // Open packages to javafx.fxml if they use FXML
    opens StudentAuthGUI to javafx.fxml;
    opens FacilityBooking to javafx.fxml;
}
