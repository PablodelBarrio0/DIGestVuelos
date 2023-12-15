/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pablogb.digestvuelos.dto.Aeropuerto;

/**
 *
 * @author Pablo
 */
public class AeropuertosCsvReader {
    
     public List<Aeropuerto> readAeropuertos() {
        List<Aeropuerto> aeropuertos = new ArrayList<>();
        String path="./src/main/resources/Aeropuertos.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valor = linea.split(";");
                if (valor.length >= 4) {
                    Aeropuerto aeropuerto = new Aeropuerto(valor[0], valor[1],valor[2], valor[3]);
                    aeropuertos.add(aeropuerto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aeropuertos;
    }
}
