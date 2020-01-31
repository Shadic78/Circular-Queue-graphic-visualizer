package Vista;

import Cola.ColaCircular;
import processing.core.PApplet;

public class DrawCola {
    private DrawAnillo anillo;
    private DrawIndices indices;
    private DrawValores valores;
    private DrawFlechas flechas;
    
    private ColaCircular cola;
    private PApplet p;
    private int diametroAnillo;
    private int colorCeldasVacias;
    private int colorCeldasOcupadas;
    private int colorBordes;
    private int colorBackground;
    private int colorFlechaInicial, colorFlechaFinal;
    //  Variables para dibujar las celdas
    private float anguloInicial;
    private float anguloCeldas;
    private int numCeldas;
    //
    private int coordX, coordY;
    private int tamFlecha;
    
    public DrawCola(ColaCircular cola, PApplet parent) {
        this.cola = cola;
        this.p = parent;
        definirValores();
        
        this.numCeldas = cola.getMaxSize();                
        this.anguloInicial = -(PApplet.PI) / 2;
        this.anguloCeldas = PApplet.radians(360 / numCeldas);        
        this.colorBackground = p.color(255, 255, 255);
        
        this.coordX = p.width / 2;
        this.coordY = p.height / 2;
        this.tamFlecha = 10;
    }
    
    public void draw() {
        this.numCeldas = cola.getMaxSize(); 
        this.anguloCeldas = PApplet.radians(360 / numCeldas);                
        anillo.draw();
        indices.draw();
        valores.draw();
        flechas.draw();
        dibujarSimbologia();
    } 
    
    private void dibujarSimbologia() {
        p.fill(255);
        p.text("Inicio de la cola", 50, p.height - 50);
        p.text("Fin de la cola", 50, p.height - 25);        
        
        p.fill(colorFlechaInicial);
        p.rect(25, p.height - 62, 20, 15);
        p.fill(colorFlechaFinal);
        p.rect(25, p.height - 37, 20, 15);        
    }
    
    private void definirValores() {
        this.colorCeldasVacias = p.color(255, 255, 255);
        this.colorCeldasOcupadas = p.color(12, 234, 74);
        this.colorBordes = p.color(0, 0, 0);
        this.diametroAnillo = p.width / 2;
        this.colorFlechaInicial = p.color(242, 75, 217);
        this.colorFlechaFinal = p.color(247, 84, 59);
    }

    public ColaCircular getCola() {
        return cola;
    }

    public void setCola(ColaCircular cola) {
        this.cola = cola;
    }

    public PApplet getP() {
        return p;
    }

    public void setP(PApplet p) {
        this.p = p;
    }

    public int getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(int colorBackground) {
        this.colorBackground = colorBackground;
    }

    public DrawAnillo getAnillo() {
        return anillo;
    }

    public void setAnillo(DrawAnillo anillo) {
        this.anillo = anillo;
    }

    public DrawIndices getIndices() {
        return indices;
    }

    public void setIndices(DrawIndices indices) {
        this.indices = indices;
    }

    public DrawValores getValores() {
        return valores;
    }

    public void setValores(DrawValores valores) {
        this.valores = valores;
    }

    public DrawFlechas getFlechas() {
        return flechas;
    }

    public void setFlechas(DrawFlechas flechas) {
        this.flechas = flechas;
    }
    
}
