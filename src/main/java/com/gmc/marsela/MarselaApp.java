package com.gmc.marsela;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MarselaApp extends Application {

    public MarselaApp(){
        System.out.println("Metodo constructor");
    }

    @Override
    public void init(){
        System.out.println("Metodo Init");
    }



    @Override
    public void start(Stage stage) throws IOException {

        System.out.println("Metodo Start");


        FXMLLoader fxmlLoader = new FXMLLoader(MarselaApp.class.getResource("view/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 802, 662);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("marsela_stylesheet.css")).toExternalForm());
        stage.setTitle("MARSELA");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        System.out.println("Metodo Stop");
    }

    public static void main(String[] args) {
        launch();
    }
}