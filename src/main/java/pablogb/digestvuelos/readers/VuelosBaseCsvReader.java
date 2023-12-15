/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pablogb.digestvuelos.dto.VueloBase;

/**
 *
 * @author Pablo
 */
public class VuelosBaseCsvReader {

    public List<VueloBase> readVuelosBase() {
        List<VueloBase> vuelos = new ArrayList<>();
        String path = "./src/main/resources/VuelosBase.csv";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valor = linea.split(";");
                if (valor.length >= 7) {
                    try {
                        int numeroPlazas = Integer.parseInt(valor[1]);
                        LocalTime horaSalida = LocalTime.parse(valor[2]);
                        LocalTime horaLlegada = LocalTime.parse(valor[3]);

                        VueloBase vueloBase = new VueloBase(valor[0], numeroPlazas, horaSalida, horaLlegada, valor[4], valor[5], valor[6]);
                        vuelos.add(vueloBase);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vuelos;
    }
}
