package jeriel;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Jeriel extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setJeriel(this);  // Pass reference to controller
            stage.setTitle("Jeriel's Chatbot");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResponse(String input) {
        // Your chatbot logic for generating responses goes here.
        return "Jeriel heard: " + input;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
