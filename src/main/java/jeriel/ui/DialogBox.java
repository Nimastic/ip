package jeriel.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class DialogBox extends HBox {

    @FXML
    private Label dialog;                     // This links to fx:id="dialog" in the FXML file
    @FXML
    private ImageView displayPicture;         // This links to fx:id="displayPicture" in the FXML file

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);     // Set this instance as the controller
            fxmlLoader.setRoot(this);           // Set this as the root for the FXML
            fxmlLoader.load();                  // Load the FXML
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ensure that dialog and displayPicture are set after loading the FXML
        dialog.setText(text);
        displayPicture.setImage(img);
    }

    // Static method for user dialog
    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img);
    }

    // Static method for Duke dialog, which flips the dialog box
    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        db.flip();
        return db;
    }

    // Flip the dialog box to display Duke's dialog (Image on the left, Text on the right)
    private void flip() {
        getChildren().setAll(displayPicture, dialog);  // Rearrange children so the image comes first
    }
}
