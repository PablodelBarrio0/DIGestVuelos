/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.dto;

/**
 *
 * @author Pablo
 */
public record Municipio (String codigo, String nombre){
    @Override
    public String toString() {
        return nombre;
    }
}
