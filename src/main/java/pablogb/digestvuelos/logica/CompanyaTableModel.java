/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pablogb.digestvuelos.dto.Companya;

/**
 *
 * @author Pablo
 */
public class CompanyaTableModel extends AbstractTableModel {

    public List<Companya> lstRegistros;
    ArrayList<String> columnNames;
    ArrayList<Class> columnClasses;

    public CompanyaTableModel(List<Companya> lstRegistros) {
        this.lstRegistros = lstRegistros;
        columnClasses = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("Prefijo");
        columnNames.add("Código");
        columnNames.add("Nombre");
        columnNames.add("Direccion");
        columnNames.add("Tel. Pasajeros");
        columnNames.add("Tel. Información");
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
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
        Companya current = lstRegistros.get(rowIndex);
        if (current != null
                && columnIndex >= 0
                && columnIndex < getColumnCount()) {
            switch (columnIndex) {
                case 0:
                    return current.getPrefijo();
                case 1:
                    return current.getCodigo();
                case 2:
                    return current.getNombre();
                case 3:
                    return current.getDireccion();
                case 4:
                    return current.getTelefonoPasajeros();
                case 5:
                    return current.getTelefonoInformacion();
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
