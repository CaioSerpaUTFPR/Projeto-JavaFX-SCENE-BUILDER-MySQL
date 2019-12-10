/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Caio
 */
public class CodTurmaPre extends CodTurma{
    private String escolaridade;
    private String semestre;
    private String ano;
    private String numTurma;
    @Override
    public String escolaridade() {
        return this.escolaridade;
    }

    @Override
    public String semestre() {
        return this.semestre;
    }

    @Override
    public String ano() {
        String digitos; //aqui pega os dois ultimos digitos do ano digitado
        digitos = (ano.substring(2, 4));
        return digitos;
    }

    @Override
    public String numTurma() {
        return this.numTurma;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setNumTurma(String numTurma) {
        this.numTurma = numTurma;
    } 
}
