package jeriel;
import jeriel.ui.DialogBox;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainWindow {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Jeriel jeriel; // Your main class

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setJeriel(Jeriel jeriel) {
        this.jeriel = jeriel;
    }

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = jeriel.getResponse(input);  // Assuming your chatbot class has this method
        dialogContainer.getChildren().addAll(
            DialogBox.getUserDialog(input),
            DialogBox.getDukeDialog(response)
        );
        userInput.clear();
    }
}
