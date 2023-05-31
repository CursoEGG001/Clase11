/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class RuletaRusaDeAgua extends Application {

    private Parent createContent() {

        boolean[] revolver = new boolean[6];
        Revolver(revolver, revolver.length);
        int disparos = (int) (Math.random() * 5);

        // Create a StackPane
        StackPane stackPane = new StackPane();

        // Create the containers for positioning
        VBox primaryPane = new VBox();
        HBox secondaryPane = new HBox();
        BorderPane stagePane = new BorderPane();

        // Create a thick circumference
        Ellipse ellipse = new Ellipse(200, 100, 150, 150);
        ellipse.setFill(Color.TRANSPARENT);
        ellipse.setStroke(Color.GRAY);
        ellipse.setStrokeWidth(22);

        // Create 6 circles inscribed around the circumference
        Circle circle1 = new Circle(0, 0, 40, (revolver[0] ? Color.BLUEVIOLET : Color.RED));
        Circle circle2 = new Circle(0, 0, 40, (revolver[1] ? Color.BLUEVIOLET : Color.RED));
        Circle circle3 = new Circle(0, 0, 40, (revolver[2] ? Color.BLUEVIOLET : Color.RED));
        Circle circle4 = new Circle(0, 0, 40, (revolver[3] ? Color.BLUEVIOLET : Color.RED));
        Circle circle5 = new Circle(0, 0, 40, (revolver[4] ? Color.BLUEVIOLET : Color.RED));
        Circle circle6 = new Circle(0, 0, 40, (revolver[5] ? Color.BLUEVIOLET : Color.RED));
        Text loHizo = new Text((revolver[disparos]) ? "Le dio" : "Zafó");
        // Add the circles to the StackPane

        stackPane.getChildren().addAll(ellipse, circle1, circle2, circle3, circle4, circle5, circle6);

        circle1.setTranslateX(122 * Math.cos(2 * Math.PI * 0 / 6));
        circle1.setTranslateY(122 * Math.sin(2 * Math.PI * 0 / 6));
        circle2.setTranslateX(122 * Math.cos(2 * Math.PI * 1 / 6));
        circle2.setTranslateY(122 * Math.sin(2 * Math.PI * 1 / 6));
        circle3.setTranslateX(122 * Math.cos(2 * Math.PI * 2 / 6));
        circle3.setTranslateY(122 * Math.sin(2 * Math.PI * 2 / 6));
        circle4.setTranslateX(122 * Math.cos(2 * Math.PI * 3 / 6));
        circle4.setTranslateY(122 * Math.sin(2 * Math.PI * 3 / 6));
        circle5.setTranslateX(122 * Math.cos(2 * Math.PI * 4 / 6));
        circle5.setTranslateY(122 * Math.sin(2 * Math.PI * 4 / 6));
        circle6.setTranslateX(122 * Math.cos(2 * Math.PI * 5 / 6));
        circle6.setTranslateY(122 * Math.sin(2 * Math.PI * 5 / 6));

        Button button = new Button("Corchazo");
        button.setOnAction((ActionEvent e) -> {
            Revolver(revolver, revolver.length);
            // Generate a new random index
            int randomIndex = (int) (Math.random() * revolver.length);
            circle1.setFill((revolver[0] ? Color.BLUEVIOLET : Color.RED));
            circle2.setFill((revolver[1] ? Color.BLUEVIOLET : Color.RED));
            circle3.setFill((revolver[2] ? Color.BLUEVIOLET : Color.RED));
            circle4.setFill((revolver[3] ? Color.BLUEVIOLET : Color.RED));
            circle5.setFill((revolver[4] ? Color.BLUEVIOLET : Color.RED));
            circle6.setFill((revolver[5] ? Color.BLUEVIOLET : Color.RED));
            // Update the text
            loHizo.setText((revolver[randomIndex]) ? "Ahora Sí" : "No lo funó");
        });

        // stack appropiately the elements
        primaryPane.getChildren().addAll(stackPane, loHizo);
        secondaryPane.getChildren().add(primaryPane);
        primaryPane.getChildren().add(button);

        // Set properties of position
        button.setAlignment(Pos.CENTER);
        loHizo.setTextAlignment(TextAlignment.JUSTIFY);
        secondaryPane.setAlignment(Pos.BASELINE_LEFT);
        primaryPane.setAlignment(Pos.BASELINE_CENTER);

        stagePane.getChildren().add(secondaryPane);
        return stagePane;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Los funados");
        stage.show();
        stage.setScene(new Scene(createContent(), 320, 400));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean[] Revolver(boolean[] tambor, int n) {

        // Check if the array is null or empty
        if (tambor == null || tambor.length == 0) {
            return null;
        }
        for (int i = 0; i < tambor.length; i++) {
            tambor[i] = false;

        }

        // Generate a random index between 0 and n-1
        int randomIndex = (int) (Math.random() * n);

        // Set the element at the random index to true
        tambor[randomIndex] = true;

        // Return the array
        return tambor;
    }

}
