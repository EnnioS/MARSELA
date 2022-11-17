package com.gmc.marsela.controller;

import com.gmc.marsela.MarselaApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class EstudioController implements Initializable {
    @FXML
    private ComboBox<String> cbNivelContaminacion,  cbUnidadMedida;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private Button btnCalcular;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtCantDepBin;
    @FXML
    private TextField txtCantDepMal;
    @FXML
    private TextField txtSitio;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtMedidaArea;
    @FXML
    private TextArea txtaObservaciones;
    @FXML
    private TextArea txtaRes;

    private ArrayList<String> errores;
    private ArrayList<String> respuesta;

    @FXML
    public TextField getTxtCantDepBin() {
        return txtCantDepBin;
    }
   //IEstudioService<Estudio> service = new EstudioServiceImp();
    @FXML
    protected void onCalc() {

        double cod;
        float newCod;
        Integer puntaje;
        Integer codRes = 0;
        Integer  nc = onCbNivelContaminacion();
        Integer um = cbUnidadMedida();
        ArrayList<String> respuesta = new ArrayList<>();


        validarCampos();
        if (errores.size()>0){
            StringBuilder cadenadeErrores = new StringBuilder();
            String headerText = "Se encontraron los siguieentes errores";
            int msgType= 1;
            String title = "Error";
            for (int i =0; i< errores.size(); i++){
                cadenadeErrores.append(errores.get(i)).append("\n");
            }

           alertBox(msgType, title, headerText, cadenadeErrores.toString());

            return;
        }

        cod = (Double.parseDouble(txtCantDepBin.getText()) / Double.parseDouble(txtMedidaArea.getText()));
        System.out.println("C.O.D: " + cod);



        System.out.println("INDEX UM: " + um);
        switch (um){
            case 0:
                if(cod >= 0.02){
                    codRes = 2;
                }else if(cod < 0.02 ){
                    codRes = 1;
                }else if(cod < 0.01) {
                    codRes = 0;
                }
                break;
            case 1:

                if(cod >= 0.0012){
                    codRes = 2;
                }else if(cod < 0.0012 ){
                    codRes = 1;
                }else if(cod < 0.0008) {
                    codRes = 0;
                }
                break;

        }

        System.out.println("variable 1 COD: " + codRes);

        System.out.println("variable 2 NC: " + nc);

        puntaje = codRes + nc;

        System.out.println("Respuesta: " + puntaje);

        respuesta = posiblesRspustas(puntaje, codRes, nc);

        System.out.println("Resultado : " +respuesta.get(0));
        System.out.println("Sugerencias : " +respuesta.get(1));

        txtaRes.setText("variable 1 COD: " + codRes + "\n\n" +
                        "variable 2 NC: " + nc + "\n\n" +
                        "Puntaje: " + puntaje + "\n\n" +
                "Resultado : \n" +respuesta.get(0)+ "\n\n" +
                "Sugerencias : \n" +respuesta.get(1));

        btnGuardar.setDisable(false);

    }

    @FXML
    protected int onCbNivelContaminacion(){
        return cbNivelContaminacion.getSelectionModel().getSelectedIndex();
    }

    @FXML
    protected  int cbUnidadMedida(){
        return cbUnidadMedida.getSelectionModel().getSelectedIndex();
    }

    @FXML
    protected void onSave() {





    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //inicializa los valores al cargar


        //Forma uno para agregar items al combobox
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, new String[]{
                "Metro lineal",
                "Metro cuadrado"
        });

        errores     = new ArrayList<>();
        respuesta   = new ArrayList<>();

        cbUnidadMedida.getItems().addAll(list);

        //Forma doa para agregar items al combobox
        cbNivelContaminacion.getItems().add("Alta");
        cbNivelContaminacion.getItems().add("Media");
        cbNivelContaminacion.getItems().add("Baja");
        cbNivelContaminacion.getItems().add("Ninguna");



    }

    public void validarCampos(){
        errores.clear();
        if(dateFecha.getValue() == null){
            errores.add("Debe ingresar una fecha valida");
        }

        if(txtCiudad.getText().isEmpty()){
            errores.add("Campo Ciudad es obliatorio");
        }

        if(txtSitio.getText().isEmpty()){
            errores.add("Campo Sitio es obliatorio");
        }

        if(txtCantDepBin.getText().isEmpty() || txtMedidaArea.getText().isEmpty() || txtCantDepMal.getText().isEmpty() || cbNivelContaminacion.getSelectionModel().getSelectedItem() == null ||  cbUnidadMedida.getSelectionModel().getSelectedItem() == null){
            errores.add("Variables de calculo no deben estar vacia");
        }else{
            if(!txtCantDepBin.getText().isEmpty() || !txtMedidaArea.getText().isEmpty() || !txtCantDepMal.getText().isEmpty()){

                try{
                    Integer.parseInt(txtMedidaArea.getText());
                    Integer.parseInt(txtCantDepMal.getText());
                    Integer.parseInt(txtCantDepBin.getText());
                }
                catch(NumberFormatException e){
                    errores.add("los campos: Area, Mal estado y Buen estado deben ser númericos");
                }
            }
        }

    }

    public void alertBox(int MsgType, String title, String headerText, String cadenadeErrores){
        switch(MsgType){
            case 1:
                Alert mensajeError = new Alert(Alert.AlertType.ERROR);
                mensajeError.setTitle("Error");
                mensajeError.setHeaderText("Se encontraron los siguientes errores");
                mensajeError.setContentText(cadenadeErrores);
                mensajeError.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                mensajeError.showAndWait();
                break;
            case 2:
                mensajeError = new Alert(Alert.AlertType.WARNING);
                mensajeError.setTitle("Error");
                mensajeError.setHeaderText("Se encontraron los siguientes errores");
                mensajeError.setContentText(cadenadeErrores);
                mensajeError.initStyle(StageStyle.UTILITY);
                java.awt.Toolkit.getDefaultToolkit().beep();
                mensajeError.showAndWait();
                break;
        }

    }


    private ArrayList<String> posiblesRspustas(Integer puntaje, Integer cod, Integer nc){
        respuesta.clear();

        switch (puntaje){
            case 0:
                if (cod == 0 && nc == 0){
                    respuesta.add("Manejo deficiente: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +"tiene una longitud aproximada de "+ txtMedidaArea.getText()+""+cbUnidadMedida.getSelectionModel().getSelectedItem()+"." +
                            " Presenta insuficientes depósitos para desechos (poner el numero observado). " +
                            "La presencia de desechos es alta, con focos de botaderos, presencia de abundante basura dispersa." +
                            " __________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____ Vigilancia, Educación ambiental.");
                }
                break;
            case 1:
                if (cod == 0 && nc == 1){
                    respuesta.add("Manejo deficiente: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta insuficientes depósitos para desechos (poner el numero observado). Presencia " +
                            "de abúndate basura dispersa pero no hay focos de botaderos. __________(en este espacio se " +
                            "puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____ Vigilancia Educación ambiental.");
                }
                if (cod == 1 && nc == 0){
                    respuesta.add("Manejo deficiente: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos para desechos mínima (poner el numero observado). " +
                            "La presencia de desechos es alta, con focos de botaderos, presencia de abundante basura dispersa. " +
                            "__________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____ Vigilancia Educación ambiental");
                }
                break;
            case 2:

                if (cod == 1 && nc == 1){
                    respuesta.add("Manejo no adecuado: El sitio"  + txtSitio.getText() +", "+ txtCiudad.getText() +"tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos para desechos mínima (poner el numero observado). " +
                            "Presencia de abúndate basura dispersa pero no hay focos de botaderos. __________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____ Vigilancia Educación ambiental");
                }

                if (cod == 2 && nc == 0){
                    respuesta.add("Manejo no adecuado: El sitio " + txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos adecuada (poner el numero observado). " +
                            "Sin embargo, la presencia de desechos es alta, con focos de botaderos, presencia de abundante basura dispersa. " +
                            "__________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Vigilancia, Educación ambiental");
                }

                if (cod == 0 && nc == 2){
                    respuesta.add("Manejo no adecuado: El sitio " + txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta insuficientes depósitos para desechos (poner el numero observado). " +
                            "La presencia de desechos es baja se observan algunos residuos dispersos, pero no abundantes. " +
                            "__________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____, Educación ambiental");
                }
                break;
            case 3:
                if (cod == 1 && nc == 2){
                    respuesta.add("Manejo no adecuado: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos para desechos mínima (poner el numero observado). " +
                            "La presencia de desechos es baja se observan algunos residuos dispersos, pero no abundantes. " +
                            "__________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____, Educación ambiental");
                }

                if (cod == 2 && nc == 1){
                    respuesta.add("Manejo no adecuado: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos adecuada (poner el numero observado). " +
                            "Presencia de abúndate basura dispersa pero no hay focos de botaderos. " +
                            "__________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Vigilancia Educación ambiental");
                }

                if (cod == 0 && nc == 3){
                    respuesta.add("Manejo no adecuado: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos adecuada (poner el numero observado). " +
                            "Presencia de abúndate basura dispersa pero no hay focos de botaderos. " +
                            "__________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____");
                }
                break;
            case 4:
                if (cod == 1 && nc == 3){
                    respuesta.add("Manejo adecuado: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos para desechos mínima (poner el numero observado).   " +
                            "Sitio limpio, residuos imperceptibles __________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Incrementar los depósitos de basura a _____");
                }

                if (cod == 2 && nc == 2){
                    respuesta.add("Manejo adecuado: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos adecuada (poner el numero observado).  " +
                            "La presencia de desechos es baja se observan algunos residuos dispersos, pero no abundantes." +
                            " __________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Educación ambiental");
                }
                break;
            case 5:
                if (cod == 2 && nc == 3){
                    respuesta.add("Eficiente: El sitio "+ txtSitio.getText() +", "+ txtCiudad.getText() +" tiene una longitud aproximada de "+ txtMedidaArea.getText() +""+cbUnidadMedida.getSelectionModel().getSelectedItem()+". " +
                            "Presenta una cantidad de depósitos adecuada (poner el numero observado).  " +
                            "Sitio limpio, residuos imperceptibles __________(en este espacio se puede agregar la observación puntual).");

                    respuesta.add("Educación ambiental");
                }
                break;
        }

        return respuesta;
    }

    @FXML
    private void cerrarApp(){
        //salir de la aplicación
        System.exit(0);
    }


    @FXML
    public void verHistorial(javafx.event.ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/historial-view.fxml"));

        try {
            Parent root = loader.load();
            HistorialController historialController = loader.getController();
            Scene scene = new Scene(root,802, 662);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);//esto no deja volver a la ventana anterir

            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("marsela_stylesheet.css")).toExternalForm());
            stage.setTitle("MARSELA - HISTORIAL");
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

