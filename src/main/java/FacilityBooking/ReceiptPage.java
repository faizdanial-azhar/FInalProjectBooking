package FacilityBooking;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import StudentAuthGUI.Student;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReceiptPage extends Stage {

    public ReceiptPage(Student student, Map<Facility, PaymentPage.BookingInfo> bookingMap) {
        setTitle("Receipt");

        VBox mainVBox = new VBox(15);
        mainVBox.setPadding(new Insets(15));
        mainVBox.setStyle("-fx-background-color: white;");

        //student info section - pull from student.txt - from student registration
        VBox studentInfoBox = new VBox(5);
        studentInfoBox.setPadding(new Insets(10));
        studentInfoBox.setStyle("-fx-border-color: black; -fx-border-width: 1;");

        Label studentTitle = new Label("Student Info");
        studentTitle.setFont(Font.font("Arial", 18));
        studentInfoBox.getChildren().add(studentTitle);
        studentInfoBox.getChildren().add(new Label("Matric No: " + student.getMatric()));
        studentInfoBox.getChildren().add(new Label("Name: " + student.getName()));
        studentInfoBox.getChildren().add(new Label("Faculty: " + student.getFaculty()));

        mainVBox.getChildren().add(studentInfoBox);

        //separator
        mainVBox.getChildren().add(new Separator());

        //prepare DateTimeFormatters for LocalDate and LocalTime
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        //facilities section
        for (Map.Entry<Facility, PaymentPage.BookingInfo> entry : bookingMap.entrySet()) {
            Facility facility = entry.getKey();
            PaymentPage.BookingInfo info = entry.getValue();

            VBox facilityBox = new VBox(5);
            facilityBox.setPadding(new Insets(10));
            facilityBox.setStyle("-fx-background-color: #D3D3D3; -fx-border-color: black; -fx-border-width: 1;");
            facilityBox.setMaxWidth(Double.MAX_VALUE);

            Label facilityTitle = new Label(facility.getName());
            facilityTitle.setFont(Font.font("Arial", 16));
            facilityBox.getChildren().add(facilityTitle);

            facilityBox.getChildren().add(new Label("Facility No: " + facility.getFacilityNo()));

            //format LocalDate and LocalTime properly
            facilityBox.getChildren().add(new Label("Date: " + info.date.format(dateFormatter)));
            facilityBox.getChildren().add(new Label("Time: " + info.time.format(timeFormatter)));

            facilityBox.getChildren().add(new Label("Hours: " + info.hours));
            facilityBox.getChildren().add(new Label(String.format("Total: RM %.2f", info.total)));

            //add QR code image (dummy)
            try {
                // Use classpath resource loading for the QR code image
                String imagePath = "/images/qrcode.png";
                Image qrImage = new Image(getClass().getResourceAsStream(imagePath), 100, 100, true, true);
                ImageView qrView = new ImageView(qrImage);
                facilityBox.getChildren().add(qrView);
            } catch (Exception e) {
                System.out.println("Failed to load QR code image: " + e.getMessage());
                facilityBox.getChildren().add(new Label("QR Code image not found."));
            }

            mainVBox.getChildren().add(facilityBox);
        }

        ScrollPane scrollPane = new ScrollPane(mainVBox);
        scrollPane.setFitToWidth(true);

        //buttons at bottom
        Button printButton = new Button("Print Receipt");
        printButton.setStyle("-fx-background-color: #009900; -fx-text-fill: white;");
        printButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Receipt will be downloaded as PDF.");
            alert.showAndWait();
        });

        Button continueButton = new Button("Continue Booking");
        continueButton.setOnAction(e -> {
            this.close();
            //open BookingPage in a new stage
            Stage bookingStage = new Stage();
            BookingPage bookingPage = new BookingPage(student);
            bookingPage.start(bookingStage);
        });

        HBox buttonsBox = new HBox(20, printButton, continueButton);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setPadding(new Insets(10));

        VBox root = new VBox(scrollPane, buttonsBox);

        Scene scene = new Scene(root, 520, 700);
        setScene(scene);
        setResizable(true);
    }
}
