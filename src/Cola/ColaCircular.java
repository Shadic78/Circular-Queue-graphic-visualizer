/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

import Excepciones.ColaLlenaException;
import Excepciones.ColaVaciaException;

/**
 *
 * @author A18016316
 */
public class ColaCircular {
    private int[] cola;
    private int maxSize;
    private int actualSize;
    private int inicio;

    public ColaCircular() {
        this.maxSize = 10;
        this.actualSize = 0;
        this.inicio = 0;
        this.cola = new int[maxSize];
    }
    
    public ColaCircular(int inicio, int size) {
        this.maxSize = size;
        this.actualSize = 0;
        this.inicio = inicio;
        this.cola = new int[maxSize];
    }    
    
    public void insertar(int obj) {
        if(!colaLlena()) {
            int posInsertar = (inicio + actualSize) % maxSize;
            cola[posInsertar] = obj;
            actualSize++;
        }
        else {
            throw new ColaLlenaException();
        }
    }
    
    public void quitar() {
        if(!colaVacia()) {
            actualSize--;
            // Va en sentido del reloj
            inicio++;
            if(inicio >= maxSize) {
                inicio = 0;
            }
        }  
        else {
            throw new ColaVaciaException();
        }
    }
    
    public boolean colaVacia() {
        boolean vacio = false;
        if(actualSize == 0) {
            vacio = true;
        }
        return vacio;
    }
    
    public boolean colaLlena() {
        boolean llena = false;
        if(actualSize == maxSize) {
            llena = true;
        }
        return llena;
    }
    
    public int frente() {
        int frente;
        if(actualSize > 0) {
            frente = cola[inicio];            
        }
        else {
            throw new ColaVaciaException();
        }
        return frente;
    }
    
    public int tamCola() {
        return actualSize;
    }

    @Override
    public String toString() {
        String imprimir = "";
        if(actualSize == 1) {
            imprimir += cola[inicio];
        }
        else {
            for (int i = inicio; i < (inicio + actualSize); i++) {
                int pos = i % maxSize;                
                if(i != (inicio + actualSize) - 1) {
                    imprimir += cola[pos] + "<-";                    
                }
                else {
                    imprimir += cola[pos];
                }
            }        
        }        
        return imprimir;        
    }
    
    public String toStringNormal() {
        String imprimir = "";
        if(actualSize == 1) {
            imprimir += cola[0];
        }
        else {
            for (int i = 0; i < actualSize; i++) {
                if(i != actualSize - 1) {
                    imprimir += cola[i] + "<-";                    
                }
                else {
                    imprimir += cola[i];
                }
            }        
        }
        return imprimir;
    }

    public int[] getCola() {
        return cola;
    }

    public void setCola(int[] cola) {
        this.cola = cola;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }
    
}
