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
public class DrawValores extends CtrlDibujarCola {

    public DrawValores(PApplet p, ColaCircular cola, int x, int y, int diametro) {
        super(p, cola, x, y, diametro);
        setAnguloInicial( -PApplet.PI / 2 );                
    }
 
    public void draw() {
        float anguloAux = getAnguloInicial();
        float x, y, radio;
        setAnguloCeldas(PApplet.radians(360 / getNumCeldas()));        
        this.setNumCeldas( getCola().getMaxSize() );             
        for(int i = 0; i < getNumCeldas(); i++) {
            // Coordenadas donde se imprimira el texto
            radio = 3 * (getDiametro() / 8);
            x = (float) (radio * Math.cos(anguloAux + (getAnguloCeldas() / 2)));
            y = (float) (radio * Math.sin(anguloAux + (getAnguloCeldas() / 2)));            
            anguloAux += getAnguloCeldas();
            
       
            /********* Solo imprimir el valor de las celdas ocupadas **********/
            if (i >= getCola().getInicio() && i < getCola().getInicio() + getCola().getActualSize() || i < getDesbordamientoCola()) {
                getP().fill(0);
                getP().text(getCola().getCola()[i], x + getX(), y + getY());
            }          

        }
    }  
    
}
