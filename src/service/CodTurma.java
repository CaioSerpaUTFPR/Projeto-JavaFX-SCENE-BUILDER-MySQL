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
public abstract class CodTurma {
   
    
    public final String iniciar() {
        this.escolaridade();
        this.semestre();
        this.ano();
        this.numTurma();
        return this.finalizar();
    }
    
    public abstract String escolaridade();
    public abstract String semestre();
    public abstract String ano();
    public abstract String numTurma();
    
    public String finalizar() {
        return (this.escolaridade() + this.semestre() + this.ano() + "-" + this.numTurma());
    }  
}
