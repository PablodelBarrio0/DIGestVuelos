
package pablogb.digestvuelos.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pablogb.digestvuelos.dto.Municipio;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class MunicipiosCsvReader {
    
    public List<Municipio> readMunicipios() {
        List<Municipio> companyas = new ArrayList<>();
        String path="./src/main/resources/Municipios.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valor = linea.split(";");
                if (valor.length >= 2) {
                    Municipio companya = new Municipio(valor[0], valor[1]);
                    companyas.add(companya);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyas;
    }
}
