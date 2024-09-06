package jeriel;

import jeriel.ui.DialogBox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

public class MainWindow {
    
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox dialogContainer;

    @FXML
    private TextField userInput;

    @FXML
    private Button sendButton;

    private Jeriel jeriel;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/view/images/User.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/view/images/Duke.png"));
    

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());  // Automatically scroll down on new message
    }

    public void setJeriel(Jeriel d) {
        jeriel = d;
    }

    @FXML
    private void handleUserInput() {
        System.out.println("Handling user input...");  // Debugging input handling
        String input = userInput.getText();
        System.out.println("Input received: " + input);  // Log input
        
        if (input.trim().isEmpty()) {
            return;  // Ignore empty input
        }

        String response = jeriel.getResponse(input);

        dialogContainer.getChildren().addAll(
            DialogBox.getUserDialog(input, userImage),
            DialogBox.getDukeDialog(response, dukeImage)
        );

        userInput.clear();  // Clear the input field
    }

}
