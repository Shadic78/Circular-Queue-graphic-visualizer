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
    private int colorFlechaInicial, colorFlechaFinal;
    //  Variables para dibujar las celdas
    private float anguloInicial;
    private float anguloCeldas;
    private int numCeldas;
    //
    private int coordX, coordY;
    private int tamFlecha;
    
    public AnilloCola(ColaCircular cola, PApplet parent) {
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
        dibujarAnillo();
        dibujarIndices();
        dibujarValores();
        dibujarFlechas();
        dibujarSimbologia();
    }
    
    public void dibujarAnillo() {
        for (int i = 0; i < numCeldas; i++) {
            // Si i esta en el rango de celdas ocupadas de la cola se rellena con cierto color 
            if (i >= cola.getInicio() && i < cola.getInicio() + cola.getActualSize() || i < getDesbordamientoCola()) {
                p.fill(colorCeldasOcupadas);
            } else {
                p.fill(colorCeldasVacias);
            }
            p.stroke(colorBordes);
            p.arc(coordX, coordY,
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

            p.fill(255);
            p.text("[" + i + "]", x + coordX, y + coordY);
        }
    }
    
    public void dibujarValores() {
        float anguloAux = anguloInicial;
        float x, y, radio;
        for(int i = 0; i < numCeldas; i++) {
            // Coordenadas donde se imprimira el texto
            radio = 3 * (diametroAnillo / 8);
            x = (float) (radio * Math.cos(anguloAux + (anguloCeldas / 2)));
            y = (float) (radio * Math.sin(anguloAux + (anguloCeldas / 2)));            
            anguloAux += anguloCeldas;
            
       
            /********* Solo imprimir el valor de las celdas ocupadas **********/
            if (i >= cola.getInicio() && i < cola.getInicio() + cola.getActualSize() || i < getDesbordamientoCola()) {
                p.fill(0);
                p.text(cola.getCola()[i], x + coordX, y + coordY);
            }          

        }
    }    
    
    private int getDesbordamientoCola() {
        /******** Obtener el rango de celdas ocupadas *******/
        int finCola = cola.getInicio() + cola.getActualSize();
        int desbordamiento = 0;
        if (finCola > cola.getMaxSize()) {
            desbordamiento = finCola % cola.getMaxSize();
        }        
        return desbordamiento;
    }
    
    private void dibujarFlechas() {
        dibujarFlechaInicio();
        if(!cola.colaVacia()) {
            dibujarFlechaFinal();            
        }
        
        p.fill(95, 98, 107);
        p.ellipse(coordX, coordY, tamFlecha * 3, tamFlecha * 3);        
    }
    
    private void dibujarFlechaInicio() {
        float anguloCeldaInicial = anguloInicial + ( anguloCeldas * cola.getInicio() ) + (anguloCeldas / 2);
        
        p.pushMatrix();
        p.translate(coordX, coordY);
        // Flecha que apunta al indice inicial
        p.rotate(anguloCeldaInicial);
        p.fill(colorFlechaInicial);
        p.triangle(-tamFlecha, -tamFlecha, -tamFlecha, tamFlecha, tamFlecha * 5, 0);   
        p.popMatrix();
        
    }
    
    private void dibujarFlechaFinal() {
        float anguloCeldaFinal = anguloInicial + ( anguloCeldas * (cola.getInicio() + cola.getActualSize() - 1)) + (anguloCeldas / 2);     
        
        p.pushMatrix();
        p.translate(coordX, coordY);
        // Flecha que apunta al indice final
        p.rotate(anguloCeldaFinal);
        p.fill(colorFlechaFinal);
        p.triangle(-tamFlecha, -tamFlecha, -tamFlecha, tamFlecha, tamFlecha * 5, 0);
        p.popMatrix();      
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
    
}
