/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ativadi.controler;

import ativadi.AtivaDI;
import ativadi.model.Professor;
import ativadi.model.Turma;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.CodTurmaEscolaridade;
import service.CodTurmaPre;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class CadastroTurmaController implements Initializable {
    
    List<Professor> list = new ArrayList<>();
    Professor professor = new Professor();
    
    @FXML
    private TextField tfAno;
    @FXML
    private TextArea taObservacao;
    @FXML
    private ComboBox<String> cbEscolaridade;
    @FXML
    private ComboBox<String> cbProfessor;
    @FXML
    private ComboBox<String> cbSemestre;
    @FXML
    private Button btCriarTurma;
    @FXML
    private Button btVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbEscolaridade.getItems().addAll("PRE","ESCOLARIDADE");
        cbSemestre.getItems().addAll("01","02");
        try {
            list = professor.getAllProfessores();
            for(Professor p : list){
                cbProfessor.getItems().add(p.getNome());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no BD!");
            Logger.getLogger(CadastroTurmaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar professores!");
            Logger.getLogger(CadastroTurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }    

    @FXML
    private void criarTurma(ActionEvent event) {
         //VALIDAÇÃO DOS CAMPOS 
        if (cbEscolaridade.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione a escolaridade da turma!"); 
        }
        else if (cbProfessor.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione o professor da turma!"); 
        }
        else if (cbSemestre.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione o semestre da turma!"); 
        }
        else if ("".equals(tfAno.getText())){
            JOptionPane.showMessageDialog(null, "Informe o ano da turma!"); 
        }
        else{
            Turma turma = new Turma(
                    cbEscolaridade.getSelectionModel().getSelectedItem(),
                    taObservacao.getText(),
                    cbSemestre.getSelectionModel().getSelectedItem(),
                    Integer.parseInt(tfAno.getText()), (cbProfessor.getSelectionModel().getSelectedIndex()+1));
            switch(cbEscolaridade.getSelectionModel().getSelectedItem()){
                case "PRE":
                    CodTurmaPre cod = new CodTurmaPre();
                    cod.setEscolaridade(cbEscolaridade.getSelectionModel().getSelectedItem());
                    cod.setAno(tfAno.getText());
                    cod.setSemestre(cbSemestre.getSelectionModel().getSelectedItem());
                    cod.setNumTurma("1");
                    turma.setCodTurma(cod.iniciar());
                    turma.criarTurma(turma);
                    AtivaDI.mudaTela("turmas");
                    break;
                case "ESCOLARIDADE" :
                    CodTurmaEscolaridade codE = new CodTurmaEscolaridade();
                    codE.setEscolaridade(cbEscolaridade.getSelectionModel().getSelectedItem());
                    codE.setAno(tfAno.getText());
                    codE.setSemestre(cbSemestre.getSelectionModel().getSelectedItem());
                    codE.setNumTurma("1");
                    turma.setCodTurma(codE.iniciar());
                    turma.criarTurma(turma);
                    AtivaDI.mudaTela("turmas");
                    //Consolidate Duplicate Conditional Fragments
                    //OLHAR SLIDE REFATORAÇÃO
                    break;
            }
        }
        
    }

    @FXML
    private void voltarTela(ActionEvent event) {
        AtivaDI.mudaTela("turmas");
    }
    
}
