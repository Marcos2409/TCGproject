module project.tcgproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.tcgproject to javafx.fxml;
    exports project.tcgproject;
}