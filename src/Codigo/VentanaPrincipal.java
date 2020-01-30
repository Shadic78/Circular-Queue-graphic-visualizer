package Codigo;

import Cola.ColaCircular;
import Vista.AnilloCola;
import Vista.Menu;
import processing.core.*;

public class VentanaPrincipal extends PApplet {
    private AnilloCola anillo;
    private Menu menu;
    private ColaCircular cola;
    int colorBackground = color(12,32,123);
        
    @Override
    public void settings() {
        size(512, 512);
    }
    
    @Override
    public void setup() {
        background(colorBackground);        
        cola = new ColaCircular(0, 10);
        
        menu = new Menu();
        menu.setVentana(this);
        menu.setAlwaysOnTop(true);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        
        anillo = new AnilloCola(cola, this);
        anillo.setColorBackground(colorBackground);
    }
    
    @Override
    public void draw() {
        background(colorBackground);
        anillo.draw();
    }

    public void cambiarCola(ColaCircular cola) {
        anillo.setCola(cola);
        setCola(cola);
    }
    
    public ColaCircular getCola() {
        return cola;
    }

    public void setCola(ColaCircular cola) {
        this.cola = cola;
    }
    
}
