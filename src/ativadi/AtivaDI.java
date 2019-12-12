/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi;

import Banco.BancoSingleton;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Caio
 */
public class AtivaDI extends Application {
    private static Stage stage;
    
    private static Scene turmasTela;
    private static Scene criarTurmaTela;
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        stage = primaryStage;
        primaryStage.setTitle("TURMAS");
        
        //TELA ABERTURA
        Parent abertura = FXMLLoader.load(getClass().getResource("view/turma.fxml"));
        turmasTela = new Scene(abertura,758,564);
        
        //TELA ABERTURA
        Parent cadastroTurma = FXMLLoader.load(getClass().getResource("view/cadastroTurma.fxml"));
        criarTurmaTela = new Scene(cadastroTurma,758,564);
        
        primaryStage.setScene(turmasTela);
        primaryStage.show();
    }
    
      
    public static void mudaTela(String tela){
        switch(tela){
            case "criarTurma":
                stage.setScene(criarTurmaTela);
                break;
            case "turmas":
                stage.setScene(turmasTela);
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
