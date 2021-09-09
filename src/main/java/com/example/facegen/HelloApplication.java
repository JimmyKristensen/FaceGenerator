package com.example.facegen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        //Her fra: Ikke relevant
        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);
        // Her til

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a colour Black or white");
        String colourChoice = scanner.nextLine();


        drawFace();

        stage.show();
    }

    public static void drawFace(){
            drawFaceShape();
            drawEyesShape();
    }

    public static void drawFaceShape(){
        gc.strokeOval(150, 150, 300, 250);
    }

    public static void drawEyesShape(){
        // Pick your eye colour
        gc.setFill(Color.BLACK);
        gc.fillOval(220,220,30,30);
        gc.fillOval(360,220,30,30);

    }

    /*
    public static void drawPrimitiveFace() {
        drawShape();
        drawMouth(50);
        drawEyes();
    }

    public static void drawShape() {
        gc.strokeOval(150, 150, 300, 300);
    }

    public static void drawMouth(int mouthSize) {
        gc.setFill(Color.BLACK);
        gc.fillOval(280,370,mouthSize,mouthSize);
    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        gc.fillOval(220,220,20,20);
        gc.fillOval(360,220,20,20);
    }

     */

    public static void main(String[] args) {
        launch();
    }
}