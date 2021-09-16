package com.example.facegen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();

    // Global Array with colour options
    static String[] arrayColour = {"Black", "Green", "Yellow", "Red"};

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        //Her fra: ikke relevant
        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);
        // Her til

        Random random = new Random();
        // User can choose what colour they want

        Scanner scanner = new Scanner(System.in);
        System.out.print("Pls pick a colour ");
        for (int i = 0; i < arrayColour.length; i++){
            System.out.print(arrayColour[i]+ ", ");
        }
        System.out.println("random");
        String userChoice = scanner.nextLine();
        userChoice = getString(userChoice);

        if (userChoice.equals("random") || userChoice.equals("Random")){
            drawEyesShape(randomIndexNumber());
        } else {
            // Finds the index of the string it's looking for in the array.
            int indexOfChoice = Arrays.asList(arrayColour).indexOf(userChoice);
            drawEyesShape(indexOfChoice);
        }
        drawFaceShape();
        drawSmileShape();



        stage.show();

        // Gif maker
        /*
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            gc.clearRect(0, 0, width, height);
            drawEyesShape(randomIndexNumber());
            drawFaceShape();
            drawSmileShape();
        }));
        timeline.setCycleCount(360);
        timeline.play();
        */

    }

    public static String getString (String makeStringUpperCase){
        // Get the first letter of the string
        String firstLetStr = makeStringUpperCase.substring(0,1);
        // Get the remaining letter of the string
        String remainingLetStr = makeStringUpperCase.substring(1);
        // Makes the first letter uppercase
        firstLetStr = firstLetStr.toUpperCase(Locale.ROOT);
        // Combine the two string
        return firstLetStr + remainingLetStr;
    }

    public static int randomIndexNumber(){
        int min = 0;
        int max = 4;
        return new Random().nextInt(max - min) + min;
    }

    public static void drawFaceShape(){
        gc.strokeOval(150, 150, 300, 250);
    }


    public static void drawSmileShape(){
        gc.setFill(Color.BLACK);
        gc.fillArc(250, 290, 100, 100, 180, 180, ArcType.ROUND);
    }


    public static void drawEyesShape(int chosenColour){
        // Pick your eye colour
        switch (chosenColour){
            case 0:
                gc.setFill(Color.BLACK);
                break;
            case 1:
                gc.setFill(Color.GREEN);
                break;
            case 2:
                gc.setFill(Color.YELLOW);
                break;
            case 3:
                gc.setFill(Color.RED);
                break;
        }
        gc.fillOval(220, 220, 30, 30);
        gc.fillOval(360, 220, 30, 30);
    }

    public static void main(String[] args) {
        launch();
    }
}