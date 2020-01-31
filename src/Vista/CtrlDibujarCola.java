/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Cola.ColaCircular;
import processing.core.PApplet;

/**
 *
 * @author Usuario
 */
public class CtrlDibujarCola {
    private PApplet p;
    private ColaCircular cola;    
    private int x, y;
    private float anguloInicial, anguloCeldas;    
    private int diametro, numCeldas;

    public CtrlDibujarCola(PApplet p, ColaCircular cola, int x, int y, int diametro) {
        this.p = p;
        this.cola = cola;
        this.x = x;
        this.y = y;
        this.diametro = diametro;
        this.numCeldas = cola.getMaxSize();
    }    
    
    public int getDesbordamientoCola() {
        /******** Obtener el rango de celdas ocupadas *******/
        int finCola = cola.getInicio() + cola.getActualSize();
        int desbordamiento = 0;
        if (finCola > cola.getMaxSize()) {
            desbordamiento = finCola % cola.getMaxSize();
        }        
        return desbordamiento;
    }    

    public PApplet getP() {
        return p;
    }

    public void setP(PApplet p) {
        this.p = p;
    }

    public ColaCircular getCola() {
        return cola;
    }

    public void setCola(ColaCircular cola) {
        this.cola = cola;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getAnguloInicial() {
        return anguloInicial;
    }

    public void setAnguloInicial(float anguloInicial) {
        this.anguloInicial = anguloInicial;
    }

    public float getAnguloCeldas() {
        return anguloCeldas;
    }

    public void setAnguloCeldas(float anguloCeldas) {
        this.anguloCeldas = anguloCeldas;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public int getNumCeldas() {
        return numCeldas;
    }

    public void setNumCeldas(int numCeldas) {
        this.numCeldas = numCeldas;
    }
    
}
