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
public class DrawAnillo extends CtrlDibujarCola {
    private int colorCeldasOcupadas, colorCeldasVacias;
    private int colorBordes, colorBackground;     

    public DrawAnillo(PApplet p, ColaCircular cola, int x, int y, int diametro) {
        super(p, cola, x, y, diametro);   
    }
    
    public void draw() {
        setAnguloCeldas(PApplet.radians(360 / getNumCeldas()));
        this.setNumCeldas( getCola().getMaxSize() );               
        for (int i = 0; i < getNumCeldas(); i++) {
            // Si i esta en el rango de celdas ocupadas de la cola se rellena con cierto color 
            if (i >= getCola().getInicio() && i < getCola().getInicio() + getCola().getActualSize() || i < getDesbordamientoCola()) {
                getP().fill(colorCeldasOcupadas);
            } else {
                getP().fill(colorCeldasVacias);
            }
            getP().stroke(colorBordes);
            getP().arc(getX(), getY(),
                    getDiametro(), getDiametro(),
                    getAnguloInicial(), getAnguloInicial() + getAnguloCeldas(), PApplet.PIE);
            setAnguloInicial(getAnguloInicial() + getAnguloCeldas());
        }
        setAnguloInicial( -PApplet.PI / 2 );

        // Circulo que da la ilusion de que se esta dibujando un anillo
        getP().fill(colorBackground);
        getP().stroke(colorBordes);
        getP().ellipse(getX(), getY(), getDiametro() / 2, getDiametro() / 2);
    }    

    public int getColorCeldasOcupadas() {
        return colorCeldasOcupadas;
    }

    public void setColorCeldasOcupadas(int colorCeldasOcupadas) {
        this.colorCeldasOcupadas = colorCeldasOcupadas;
    }

    public int getColorCeldasVacias() {
        return colorCeldasVacias;
    }

    public void setColorCeldasVacias(int colorCeldasVacias) {
        this.colorCeldasVacias = colorCeldasVacias;
    }

    public int getColorBordes() {
        return colorBordes;
    }

    public void setColorBordes(int colorBordes) {
        this.colorBordes = colorBordes;
    }

    public int getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(int colorBackground) {
        this.colorBackground = colorBackground;
    }
    
}
