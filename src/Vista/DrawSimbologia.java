/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import processing.core.PApplet;

/**
 *
 * @author Usuario
 */
public class DrawSimbologia {
    private int colorFlechaInicial, colorFlechaFinal;
    private int x, y;
    private PApplet p;

    public DrawSimbologia(PApplet p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public void draw() {
        p.fill(255);
        p.text("Inicio de la cola", 50, p.height - 50);
        p.text("Fin de la cola", 50, p.height - 25);

        p.fill(colorFlechaInicial);
        p.rect(25, p.height - 62, 20, 15);
        p.fill(colorFlechaFinal);
        p.rect(25, p.height - 37, 20, 15);
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
