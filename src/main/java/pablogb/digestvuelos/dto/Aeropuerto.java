/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.dto;

/**
 *
 * @author Pablo 
 */
public class Aeropuerto {
    private int id;
    private String codigoIATA;
    private String nombre;
    private String codMunicipio;

    public Aeropuerto() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public Aeropuerto(int id, String codigoIATA, String nombre, String codMunicipio) {
        this.id = id;
        this.codigoIATA = codigoIATA;
        this.nombre = nombre;
        this.codMunicipio = codMunicipio;
    }
    
    public Aeropuerto( String codigoIATA, String nombre, String codMunicipio) {
        this.codigoIATA = codigoIATA;
        this.nombre = nombre;
        this.codMunicipio = codMunicipio;
    }
    
    private boolean isInternacional(){
        return this.getCodMunicipio().equals("00000"); 
    }
    
    
}
