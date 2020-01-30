package Vista;

import Cola.ColaCircular;
import processing.core.PApplet;

public class AnilloCola {
    private ColaCircular cola;
    private PApplet p;
    private int diametroAnillo;
    private int colorCeldasVacias;
    private int colorCeldasOcupadas;
    private int colorBordes;
    private int colorBackground;
    //  Variables para dibujar las celdas
    private float anguloInicial;
    private float anguloCeldas;
    private int numCeldas;
    
    public AnilloCola(ColaCircular cola, PApplet parent) {
        this.cola = cola;
        this.p = parent;
        definirValores();
        
        this.anguloInicial = -(PApplet.PI) / 2;
        this.numCeldas = cola.getMaxSize();
        this.anguloCeldas = PApplet.radians(360 / numCeldas);        
        this.colorBackground = p.color(255, 255, 255);
    }
    
    public void draw() {
        dibujarAnillo();
        dibujarIndices();
        dibujarValores();
    }
    
    public void dibujarAnillo() {
        for (int i = 0; i < numCeldas; i++) {
            // Si i esta en el rango de celdas ocupadas de la cola se rellena con cierto color REVISAR
            if (i >= cola.getInicio() && i < (cola.getInicio() + cola.getActualSize()) % cola.getMaxSize() || cola.colaLlena()) {
                p.fill(colorCeldasOcupadas);
            } else {
                p.fill(colorCeldasVacias);
            }
            p.stroke(colorBordes);
            p.arc(p.width / 2, p.height / 2,
                    diametroAnillo, diametroAnillo,
                    anguloInicial, anguloInicial + anguloCeldas, PApplet.PIE);
            anguloInicial += anguloCeldas;
        }
        anguloInicial = -(PApplet.PI) / 2;

        // Circulo que da la ilusion de que se esta dibujando un anillo
        p.fill(colorBackground);
        p.stroke(colorBordes);
        p.ellipse(p.width / 2, p.height / 2, diametroAnillo / 2, diametroAnillo / 2);
    }
    
    public void dibujarIndices() {
        float anguloAux = anguloInicial;
        float x, y;
        for(int i = 0; i < numCeldas; i++) {
            x = (float) ((diametroAnillo / 2 + 25)*Math.cos(anguloAux + (anguloCeldas / 2)));
            y = (float) ((diametroAnillo / 2 + 25)*Math.sin(anguloAux + (anguloCeldas / 2)));            
            anguloAux += anguloCeldas;

            p.fill(0);
            p.text("[" + i + "]", x + (p.width / 2), y + (p.height / 2));
        }
    }
    
    public void dibujarValores() {
        float anguloAux = anguloInicial;
        float x, y, radio;
        for(int i = 0; i < numCeldas; i++) {
            radio = 3 * (diametroAnillo / 8);
            x = (float) (radio * Math.cos(anguloAux + (anguloCeldas / 2)));
            y = (float) (radio * Math.sin(anguloAux + (anguloCeldas / 2)));            
            anguloAux += anguloCeldas;

            p.fill(0);
            p.text(cola.getCola()[i], x + (p.width / 2), y + (p.height / 2));
        }
    }    
    
    private void definirValores() {
        this.colorCeldasVacias = p.color(255, 255, 255);
        this.colorCeldasOcupadas = p.color(12, 234, 74);
        this.colorBordes = p.color(0, 0, 0);
        this.diametroAnillo = p.width / 2;
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
    
}
