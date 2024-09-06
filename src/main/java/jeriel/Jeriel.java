package jeriel;
import jeriel.command.*;
import jeriel.util.*;
import jeriel.ui.DialogBox;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Jeriel extends Application {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Jeriel() {
        ui = new Ui();
        storage = new Storage("data/tasks.txt");
        try {
            tasks = new TaskList(storage.load());  // Load tasks from storage
        } catch (IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setJeriel(this);
            stage.setTitle("Jeriel's Chatbot");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResponse(String... inputs) {
        // Concatenate all input strings into a single string
        StringBuilder inputBuilder = new StringBuilder();
        for (String input : inputs) {
            inputBuilder.append(input).append(" ");
        }
        String input = inputBuilder.toString().trim();
        
        System.out.println("Jeriel received input: " + input);  // Log input for debugging
        
        try {
            Command command = Parser.parse(input);  // Parse the input
            System.out.println("Command parsed: " + command.getClass().getSimpleName());  // Log command for debugging
            
            return command.execute(tasks, ui, storage);  // Execute command and return response
        } catch (JerielException | IOException e) {
            return e.getMessage();  // Return error message if something goes wrong
        }
    }
    
    

    public static void main(String[] args) {
        Jeriel jeriel = new Jeriel();
        System.out.println(jeriel.getResponse("test"));  // Single input
        System.out.println(jeriel.getResponse("test", "multiple", "inputs"));  // Multiple inputs
    }
}
