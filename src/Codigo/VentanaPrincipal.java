package Codigo;

import Cola.ColaCircular;
import Vista.AnilloCola;
import processing.core.*;

public class VentanaPrincipal extends PApplet {
    AnilloCola anillo;
    int colorBackground = color(12,32,123);
        
    @Override
    public void settings() {
        size(512, 512);
    }
    
    @Override
    public void setup() {
        background(colorBackground);
        ColaCircular cola = new ColaCircular(3, 12);
        cola.insertar(1);
        cola.insertar(2);
        cola.insertar(3);
        cola.insertar(4);   
        cola.insertar(5);
        System.out.println(cola);
        
        anillo = new AnilloCola(cola, this);
        anillo.setColorBackground(colorBackground);
    }
    
    @Override
    public void draw() {
        background(colorBackground);
        anillo.draw();
    }
    
}
