/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author A18016316
 */
public class ColaVaciaException extends RuntimeException {
    
    @Override
    public String getMessage() {
        return "La cola esta vacia"; //To change body of generated methods, choose Tools | Templates.
    }    
    
}
