/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pablogb.digestvuelos;

import java.util.Date;
import java.util.List;
import pablogb.digestvuelos.dto.Aeropuerto;
import pablogb.digestvuelos.dto.Companya;
import pablogb.digestvuelos.dto.VueloBase;
import pablogb.digestvuelos.gui.FrmMain;
import pablogb.digestvuelos.logica.LogicaNegocio;

public class DIGestVuelos {

    public static void main(String[] args) {
        FrmMain main = new FrmMain();
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        
        
        Aeropuerto aeropuertoBase=LogicaNegocio.getAeropuertoBase();
        
        List<Companya> lista=LogicaNegocio.getAllCompanyas();
        List<Companya> compMadrid=LogicaNegocio.getCompanyasByMunicipio("28079");
        
        
        //List<VueloBase> listavuelos=LogicaNegocio.getAllVuelosBase();
        
        Date fechaActual=new Date();
        List<VueloBase> vuelos=LogicaNegocio.getVueloBaseByFecha(fechaActual);
        String horaCadena = LogicaNegocio.getHoraByFecha(fechaActual);
        
        
        
    }
}
