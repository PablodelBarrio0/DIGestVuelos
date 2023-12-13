/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pablogb.digestvuelos.logica;

/**
 *
 * @author Pablo
 */
public enum DiasSemana {
    Domingo("D"), Lunes("L"), Martes("M"), Miercoles("X"), Jueves("J"), Viernes("V"), Sabado("S");
    
    public final String label;
    
    private DiasSemana(String label){
        this.label=label;
    }
}
