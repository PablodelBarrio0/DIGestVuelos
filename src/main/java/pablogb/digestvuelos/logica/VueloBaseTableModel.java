/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pablogb.digestvuelos.dto.VueloBase;

/**
 *
 * @author Pablo
 */
public class VueloBaseTableModel extends AbstractTableModel {

    public List<VueloBase> lstRegistros;
    ArrayList<String> columnNames;
    ArrayList<Class> columnClasses;

    public VueloBaseTableModel(List<VueloBase> lstRegistros) {

        this.lstRegistros = lstRegistros;
        columnClasses = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("Codigo Vuelo");
        columnNames.add("Nº Plazas");
        columnNames.add("H. Salida");
        columnNames.add("H. Llegada");
        columnNames.add("Dias Operacion");
        columnNames.add("Aeropuerto Origen");
        columnNames.add("Aeropuerto Destino");
        columnClasses.add(String.class);
        columnClasses.add(int.class);
        columnClasses.add(Date.class);
        columnClasses.add(Date.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
    }

    @Override
    public int getRowCount() {
        return lstRegistros.size();
    }

    @Override
    public int getColumnCount() {
        return columnClasses.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VueloBase current = lstRegistros.get(rowIndex);
        if (current != null
                && columnIndex >= 0
                && columnIndex < getColumnCount()) {
            switch (columnIndex) {
                case 0:
                    return current.getCodigoVuelo();
                case 1:
                    return current.getNumeroPlazas();
                case 2:
                    return current.getHoraSalida();
                case 3:
                    return current.getHoraLlegada();
                case 4:
                    return current.getDiasOperacion();
                case 5:
                    return current.getAeropuertoOrigen().getNombre();
                case 6:
                    return current.getAeropuertoDestino().getNombre();
                default:
                    return "";
            }

        } else {
            return "";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

}
