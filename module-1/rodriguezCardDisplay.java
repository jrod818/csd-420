
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class rodriguezCardDisplay extends Application {

    private final HBox cardBox = new HBox(10);

    @Override
    public void start(Stage stage) {

        // Center the cards in the window.
        cardBox.setAlignment(Pos.CENTER);

        // Create a button to display new cards.
        Button refreshButton = new Button("Refresh Cards");

        // Lambda expression for the button click.
        refreshButton.setOnAction(event -> showCards());

        // Arrange the cards and button vertically.
        VBox root = new VBox(20, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);

        // Display four random cards when the program starts.
        showCards();

        // Create the application window.
        Scene scene = new Scene(root, 650, 300);
        stage.setTitle("Random Playing Cards");
        stage.setScene(scene);
        stage.show();
    }

    // Randomly select and display four different cards.
    private void showCards() {

        // Remove the previously displayed cards.
        cardBox.getChildren().clear();

        // Create a list containing all 52 card numbers.
        ArrayList<Integer> cards = new ArrayList<>();

        for (int i = 1; i <= 52; i++) {
            cards.add(i);
        }

        // Shuffle the deck randomly.
        Collections.shuffle(cards);

        // Display the first four cards from the shuffled deck.
        for (int i = 0; i < 4; i++) {

            int cardNumber = cards.get(i);

            // Load the card image from the cards folder.
            File file = new File("cards/" + cardNumber + ".png");
            Image image = new Image(file.toURI().toString());

            ImageView imageView = new ImageView(image);

            // Set the displayed card dimensions.
            imageView.setFitWidth(120);
            imageView.setFitHeight(170);
            imageView.setPreserveRatio(true);

            cardBox.getChildren().add(imageView);
        }
    }

    // Start the JavaFX application.
    public static void main(String[] args) {
        launch(args);
    }
}
