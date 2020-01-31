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
public class DrawFlechas extends CtrlDibujarCola {
    private int tamFlecha;
    private int colorFlechaInicial, colorFlechaFinal;

    public DrawFlechas(PApplet p, ColaCircular cola, int x, int y, int diametro, int tamFlecha) {
        super(p, cola, x, y, diametro);
        this.tamFlecha = tamFlecha;   
    }
    
    public void draw() {
        setNumCeldas(getCola().getMaxSize());
        setAnguloCeldas(PApplet.radians(360 / getNumCeldas()));        
        setAnguloInicial( -PApplet.PI / 2 );            
        
        dibujarFlechaInicio();
        if(!getCola().colaVacia()) {
            dibujarFlechaFinal();            
        }
        
        getP().fill(95, 98, 107);
        getP().ellipse(getX(), getY(), tamFlecha * 3, tamFlecha * 3);        
    }
    
    private void dibujarFlechaInicio() {
        float anguloCeldaInicial = getAnguloInicial() + ( getAnguloCeldas() * getCola().getInicio() ) + (getAnguloCeldas() / 2);
        
        getP().pushMatrix();
        getP().translate(getX(), getY());
        // Flecha que apunta al indice inicial
        getP().rotate(anguloCeldaInicial);
        getP().fill(colorFlechaInicial);
        getP().triangle(-tamFlecha, -tamFlecha, -tamFlecha, tamFlecha, tamFlecha * 5, 0);   
        getP().popMatrix();
        
    }
    
    private void dibujarFlechaFinal() {
        float anguloCeldaFinal = getAnguloInicial() + ( getAnguloCeldas() * (getCola().getInicio() + getCola().getActualSize() - 1)) + (getAnguloCeldas() / 2);     
        
        getP().pushMatrix();
        getP().translate(getX(), getY());
        // Flecha que apunta al indice final
        getP().rotate(anguloCeldaFinal);
        getP().fill(colorFlechaFinal);
        getP().triangle(-tamFlecha, -tamFlecha, -tamFlecha, tamFlecha, tamFlecha * 5, 0);
        getP().popMatrix();      
    }

    public int getTamFlecha() {
        return tamFlecha;
    }

    public void setTamFlecha(int tamFlecha) {
        this.tamFlecha = tamFlecha;
    }

    public int getColorFlechaInicial() {
        return colorFlechaInicial;
    }

    public void setColorFlechaInicial(int colorFlechaInicial) {
        this.colorFlechaInicial = colorFlechaInicial;
    }

    public int getColorFlechaFinal() {
        return colorFlechaFinal;
    }

    public void setColorFlechaFinal(int colorFlechaFinal) {
        this.colorFlechaFinal = colorFlechaFinal;
    }
    
}
