package clase11;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CineJFX extends Application {

    private String movieTitle = "The Shawshank Redemption";
    private int movieDuration = 142;
    private int minimumAge = 13;
    private String movieDirector = "Frank Darabont";
    private int priceOfTicket = 10;

    private boolean[][] seats = new boolean[8][6];
    private ArrayList<Circle> seatCircles = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Label movieTitleLabel = new Label("Película: " + movieTitle);
        Label movieDurationLabel = new Label("Duración: " + movieDuration + " minutos");
        Label minimumAgeLabel = new Label("Edad mínima: " + minimumAge);
        Label priceOfTicketLabel = new Label("Precio de la entrada: " + priceOfTicket);

        Label nameLabel = new Label("Nombre:");
        Label ageLabel = new Label("Edad:");
        Label moneyLabel = new Label("Dinero:");
        Label statusLabel = new Label("Preparado...");

        TextField nameTextField = new TextField();
        TextField ageTextField = new TextField();
        TextField moneyTextField = new TextField();

        Button addSpectatorButton = new Button("Agregar espectador");
        TilePane seatPane = new TilePane();
        seatPane.setPrefTileWidth(22); // Establecer el ancho deseado de cada celda
        seatPane.setPrefTileHeight(22); // Establecer la altura deseada de cada celda
        seatPane.setPrefColumns(6); // Establecer el número de columnas
        seatPane.setPrefRows(8); // Establecer el número de filas
        seatPane.setHgap(10);
        seatPane.setVgap(10);
        seatPane.setPadding(new Insets(10));

        HBox primaryPane = new HBox();
        VBox secondaryPane = new VBox();
        VBox fieldsPane = new VBox();
        HBox namePane = new HBox();
        HBox agePane = new HBox();
        HBox moneyPane = new HBox();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                Circle seatCircle = new Circle(10);
                seatCircle.setFill(seats[i][j] ? Color.RED : Color.GREEN);
                seatCircles.add(seatCircle);
                seatPane.getChildren().add(seatCircle);
            }
        }

        addSpectatorButton.setOnAction((ActionEvent event) -> {
            String name = "";
            int age = 0;
            int money = 0;

            name = nameTextField.getText();
            age = Integer.parseInt(ageTextField.getText());
            money = Integer.parseInt(moneyTextField.getText());

            if (age >= minimumAge && money >= priceOfTicket && name != "") {
                boolean foundSeat = false;
                for (int i = 0; i < 8 && !foundSeat; i++) {
                    for (int j = 0; j < 6 && !foundSeat; j++) {
                        if (!seats[i][j]) {
                            int randRow = (int) (Math.random() * 7);
                            int randCol = (int) (Math.random() * 5);
                            seats[randRow][randCol] = true;
                            foundSeat = true;
                            seatCircles.get(randRow * 6 + randCol).setFill(Color.RED);
                            String message = name + " se asentó en el asiento " + (char) ('A' + randRow) + (j + randCol);
                            statusLabel.setText(message);
                            showStatusMessage(message);

                        }
                    }
                }
            } else {
                String message = name + " no puede ver la película.";
                statusLabel.setText(message);
                showStatusMessage(message);

            }
        });

        namePane.getChildren().addAll(nameLabel,nameTextField);
        agePane.getChildren().addAll(ageLabel,ageTextField);
        moneyPane.getChildren().addAll(  moneyLabel,moneyTextField);
        GridPane gridPane = new GridPane();

        minimumAgeLabel.setAlignment(Pos.TOP_LEFT);
        nameLabel.setAlignment(Pos.TOP_RIGHT);
        ageLabel.setAlignment(Pos.CENTER_RIGHT);
        moneyLabel.setAlignment(Pos.BASELINE_RIGHT);
        addSpectatorButton.setAlignment(Pos.BOTTOM_RIGHT);

        secondaryPane.getChildren().addAll(movieTitleLabel, minimumAgeLabel,  gridPane, statusLabel);
        fieldsPane.getChildren().addAll(movieDurationLabel, priceOfTicketLabel,namePane,agePane,moneyPane);
//        gridPane.add(movieTitleLabel, 0, 0, 3, 1);
//        gridPane.add(movieDurationLabel, 0, 0, 1, 1);
//        gridPane.add(minimumAgeLabel, 3, 0, 3, 1);
//        gridPane.add(priceOfTicketLabel, 3, 4, 1, 1);
//        gridPane.add(nameLabel, 0, 4, 1, 1);
//        gridPane.add(nameTextField, 1, 4, 1, 1);
//        gridPane.add(ageLabel, 2, 4, 1, 1);
//        gridPane.add(ageTextField, 3, 4, 1, 1);
//        gridPane.add(moneyLabel, 2, 5);
//        gridPane.add(moneyTextField, 3, 5);
        gridPane.add(addSpectatorButton, 0, 0, 6, 1);
        gridPane.add(seatPane, 0, 2, 6, 8);
//        gridPane.add(statusLabel, 0, 15, 6, 1);

        secondaryPane.setAlignment(Pos.TOP_RIGHT);
        statusLabel.setAlignment(Pos.BASELINE_LEFT);

        primaryPane.getChildren().addAll(secondaryPane, fieldsPane);

        Scene scene = new Scene(primaryPane, 600, 500);
        primaryStage.setTitle("CineJFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showStatusMessage(String message) {
        // Aquí puedes usar la etiqueta de la barra de estado para mostrar el mensaje
        System.out.println(message);

    }

    public static void main(String[] args) {
        launch(args);
    }
}

//package clase11;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
///**
// *
// * @author pc
// */
//public class CineJFX extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}
