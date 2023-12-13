/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.dto;

import java.util.Date;
import pablogb.digestvuelos.logica.LogicaNegocio;

/**
 *
 * @author Pablo
 */
public class VueloBase {
    private String codigoVuelo;
    private int numeroPlazas;
    private Date horaSalida;
    private Date horaLlegada;
    private String diasOperacion;
    private String codigoAeropuertoOrigen;
    private String codigoAeropuertoDestino;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;

    public VueloBase() {
    }

    public VueloBase(String codigoVuelo, int numeroPlazas, Date horaSalida, Date horaLlegada, String diasOperacion, String codigoAeropuertoOrigen, String codigoAeropuertoDestino) {
        this.codigoVuelo = codigoVuelo;
        this.numeroPlazas = numeroPlazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOperacion = diasOperacion;
        this.setCodigoAeropuertoOrigen (codigoAeropuertoOrigen);
        this.setCodigoAeropuertoDestino(codigoAeropuertoDestino);
    }

    public VueloBase(String codigoVuelo, int numeroPlazas, Date horaSalida, Date horaLlegada, String diasOperacion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino) {
        this.codigoVuelo = codigoVuelo;
        this.numeroPlazas = numeroPlazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOperacion = diasOperacion;
        this.setAeropuertoOrigen (aeropuertoOrigen);
        this.setAeropuertoDestino (aeropuertoDestino);
    }


    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDiasOperacion() {
        return diasOperacion;
    }

    public void setDiasOperacion(String diasOperacion) {
        this.diasOperacion = diasOperacion;
    }

    public String getCodigoAeropuertoOrigen() {
        return codigoAeropuertoOrigen;
    }

    public void setCodigoAeropuertoOrigen(String codigoAeropuertoOrigen) {
        this.codigoAeropuertoOrigen = codigoAeropuertoOrigen;
        this.aeropuertoOrigen=LogicaNegocio.getAeropuertoByCodigoIATA(codigoAeropuertoOrigen);
    }

    public String getCodigoAeropuertoDestino() {
        return codigoAeropuertoDestino;
    }

    public void setCodigoAeropuertoDestino(String codigoAeropuertoDestino) {
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
        this.aeropuertoDestino=LogicaNegocio.getAeropuertoByCodigoIATA(codigoAeropuertoDestino);
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.codigoAeropuertoOrigen=aeropuertoOrigen.getCodigoIATA();
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
        this.codigoAeropuertoDestino=aeropuertoDestino.getCodigoIATA();
    }
    
    
    
    
}
