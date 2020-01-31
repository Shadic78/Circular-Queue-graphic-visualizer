package Codigo;

import Cola.ColaCircular;
import Vista.DrawAnillo;
import Vista.DrawCola;
import Vista.DrawFlechas;
import Vista.DrawIndices;
import Vista.DrawSimbologia;
import Vista.DrawValores;
import Vista.Menu;
import processing.core.*;

public class VentanaPrincipal extends PApplet {
    private DrawAnillo anillo;    
    private DrawIndices indices;
    private DrawValores valores;
    private DrawFlechas flechas;
    private DrawSimbologia simbologia;
    private DrawCola dibujarCola;
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
        
        anillo = new DrawAnillo(this, cola, this.width / 2, this.height / 2, this.width / 2);
        anillo.setColorBackground(colorBackground);
        anillo.setColorBordes(0);
        anillo.setColorCeldasOcupadas(color(12, 234, 74));
        anillo.setColorCeldasVacias(color(255, 255, 255));
        
        indices = new DrawIndices(this, cola, this.width / 2, this.height / 2, this.width / 2);
        valores = new DrawValores(this, cola, this.width / 2, this.height / 2, this.width / 2);
        
        flechas = new DrawFlechas(this, cola, this.width / 2, this.height / 2, this.width / 2, 10);
        flechas.setColorFlechaInicial(color(242, 75, 217));
        flechas.setColorFlechaFinal(color(247, 84, 59));
        flechas.setTamFlecha(10);
        
        simbologia = new DrawSimbologia(this);
        simbologia.setColorFlechaInicial(color(242, 75, 217));
        simbologia.setColorFlechaFinal(color(247, 84, 59));        

        dibujarCola = new DrawCola();
        dibujarCola.setAnillo(anillo);
        dibujarCola.setIndices(indices);
        dibujarCola.setValores(valores);
        dibujarCola.setFlechas(flechas);
        dibujarCola.setSimbologia(simbologia);
    }
    
    @Override
    public void draw() {
        background(colorBackground);
        dibujarCola.draw();
    }

    public void cambiarCola(ColaCircular cola) {
        anillo.setCola(cola);
        indices.setCola(cola);
        valores.setCola(cola);
        flechas.setCola(cola);
        setCola(cola);
    }
    
    public ColaCircular getCola() {
        return cola;
    }

    public void setCola(ColaCircular cola) {
        this.cola = cola;
    }
    
}
