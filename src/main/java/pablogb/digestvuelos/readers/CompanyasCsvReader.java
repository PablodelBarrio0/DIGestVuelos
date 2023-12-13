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
import pablogb.digestvuelos.dto.Companya;

/**
 *
 * @author Pablo
 */
public class CompanyasCsvReader {
    
    public List<Companya> readCompanyas() {
        List<Companya> companyas = new ArrayList<>();
        String path="./src/main/resources/Companyas.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valor = linea.split(";");
                if (valor.length >= 7) {
                    Companya companya = new Companya(valor[0], valor[1], valor[2], valor[3], valor[4], valor[5], valor[6]);
                    companyas.add(companya);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyas;
    }
}
