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
public class DrawIndices extends CtrlDibujarCola {
    
    public DrawIndices(PApplet p, ColaCircular cola, int x, int y, int diametro) {
        super(p, cola, x, y, diametro);    
        setAnguloInicial( -PApplet.PI / 2 );        
    }
    
    public void draw() {
        setAnguloCeldas(PApplet.radians(360 / getNumCeldas()));        
        this.setNumCeldas( getCola().getMaxSize() );                       
        float anguloAux = getAnguloInicial();
        float x, y;
        for(int i = 0; i < getNumCeldas(); i++) {
            x = (float) ((getDiametro() / 2 + 25)*Math.cos(anguloAux + (getAnguloCeldas() / 2)));
            y = (float) ((getDiametro() / 2 + 25)*Math.sin(anguloAux + (getAnguloCeldas() / 2)));            
            anguloAux += getAnguloCeldas();

            getP().fill(255);
            getP().text("[" + i + "]", x + getX(), y + getY());
        }
    }
    
}
