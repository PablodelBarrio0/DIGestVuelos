/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pablogb.digestvuelos.logica;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import pablogb.digestvuelos.dto.Aeropuerto;
import pablogb.digestvuelos.dto.Companya;
import pablogb.digestvuelos.dto.Municipio;
import pablogb.digestvuelos.dto.VueloBase;
import pablogb.digestvuelos.dto.VueloDiario;
import pablogb.digestvuelos.readers.CompanyasCsvReader;
import pablogb.digestvuelos.readers.MunicipiosCsvReader;
import pablogb.digestvuelos.readers.VuelosBaseCsvReader;

/**
 *
 * @author Pablo
 */
public class LogicaNegocio {

    //Inicializacion de variables
    public static void initializeProgram() {
        initializeMunicipios();
        initializeAeropuerto();
        initializeCompanyas();
    }

    //Logica de Municipios
    private static List<Municipio> lstMunicipios = new ArrayList<>();

    private static void initializeMunicipios() {
        MunicipiosCsvReader reader = new MunicipiosCsvReader();
        List<Municipio> municipio = reader.readMunicipios();
        if (municipio.size() > 1) {
            for (int i = 1; i < municipio.size(); i++) {
                lstMunicipios.add(municipio.get(i));
            }
        }
    }

    public static Municipio MunicipioByCod(String codigo) {
        for (Municipio municipio : lstMunicipios) {
            if (municipio.getCodigo().equals(codigo)) {
                return municipio;
            }
        }
        return null;
    }

    public static List<Municipio> getAllMunicipios() {
        return lstMunicipios;
    }

    //Logica de Aeropuerto
    private static List<Aeropuerto> lstAeropuerto = new ArrayList<Aeropuerto>();

    public static ValidationResult addAeropuerto(Aeropuerto aero) {
        ValidationResult retValue = new ValidationResult(true, "");
        Aeropuerto aux = getAeropuertoByCodigoIATA(aero.getCodigoIATA());
        if (aux == null) {
            lstAeropuerto.add(aero);
        } else {
            retValue = new ValidationResult(false, "El código IATA del aeropuerto ya existe.No se añadirá a la lista.");
        }
        return retValue;
    }

    public static void initializeAeropuerto() {
        addAeropuerto(new Aeropuerto("ABC", "Aeropuerto de Albacete", "02003"));
        addAeropuerto(new Aeropuerto("OVD", "Aeropuerto de Asturias", "33016"));
        addAeropuerto(new Aeropuerto("LEN", "Aeropuerto de León", "24189"));
        addAeropuerto(new Aeropuerto("OSL", "Aeropuerto de Oslo-Gardermoen", "00000"));
    }

    public static List<Aeropuerto> getAllAeropuertos() {
        return lstAeropuerto;
    }

    public static Aeropuerto getAeropuertoByCodigoIATA(String codigoIATA) {

        for (Aeropuerto a : lstAeropuerto) {
            if (a.getCodigoIATA().equals(codigoIATA)) {
                return a;
            }
        }
        return null;
    }

    public static Aeropuerto getAeropuertoBase() {
        return getAeropuertoByCodigoIATA("OVD");
    }

    //Logica de compañias
    private static List<Companya> lstCompanyas = new ArrayList<Companya>();

    private static void initializeCompanyas() {
        CompanyasCsvReader reader = new CompanyasCsvReader();
        List<Companya> companyas = reader.readCompanyas();
        if (companyas.size() > 1) {
            for (int i = 1; i < companyas.size(); i++) {
                lstCompanyas.add(companyas.get(i));
            }
        }
    }

    public static List<Companya> getAllCompanyas() {
        lstCompanyas.clear();
        initializeCompanyas();

        return lstCompanyas;
    }

    public static Companya getCompanyaByPrefijo(int prefijo) {
        for (Companya c : lstCompanyas) {
            if (c.getPrefijo().equals(prefijo)) {
                return c;
            }
        }
        return null;
    }

    public static Companya getCompanyaByCodigo(String codigo) {
        Optional<Companya> optValorSalida = lstCompanyas.stream()
                .filter(value -> value.getCodigo().equals(codigo))
                .findFirst();
        if (optValorSalida.isPresent()) {
            return optValorSalida.get();
        } else {
            return null;
        }
    }

    public static List<Companya> getCompanyasByMunicipio(String municipio) {
        return lstCompanyas.stream()
                .filter(value -> value.getMunicipio().equals(municipio))
                .toList();
    }

    public static ValidationResult addCompanya(Companya newComp) {
        ValidationResult retValue = new ValidationResult(true, "");
        Companya aux = getCompanyaByCodigo(newComp.getCodigo());
        if (aux == null) {
            lstCompanyas.add(newComp);
        } else {
            retValue = new ValidationResult(false, "El código de la compañia ya existe.No se añadirá a la lista.");
        }
        return retValue;
    }

    public static void updateCompanyaByCodigo(String codigo, Companya newComp) {
        Companya oldComp = getCompanyaByCodigo(codigo);
        if (oldComp != null) {
            oldComp.setDireccion(newComp.getDireccion());
            oldComp.setMunicipio(newComp.getMunicipio());
            oldComp.setNombre(newComp.getNombre());
            oldComp.setPrefijo(newComp.getPrefijo());
            oldComp.setTelefonoInformacion(newComp.getTelefonoInformacion());
            oldComp.setTelefonoPasajeros(newComp.getTelefonoPasajeros());
        }

    }

    public static void deleteCompanyaByCodigo(String codigo) {
        Companya delComp = getCompanyaByCodigo(codigo);
        if (delComp != null) {
            lstCompanyas.remove(delComp);
        }
    }

    public static void escribirCompanyasCsv(List<Companya> companyas) {
        try (FileWriter fw = new FileWriter("./src/main/resources/Companyas.csv")) {
            for (Companya comp : companyas) {
                fw.write(comp.toCsvString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Logica de vuelo base
    private static List<VueloBase> lstVuelosBase = new ArrayList<VueloBase>();

    private static void initializeVueloBase() {
        VuelosBaseCsvReader reader = new VuelosBaseCsvReader();
        List<VueloBase> vuelosBase = reader.readVuelosBase();
        if (vuelosBase.size() >= 1) {
            for (int i = 0; i < vuelosBase.size(); i++) {
                lstVuelosBase.add(vuelosBase.get(i));
            }
        }
    }

    public static List<VueloBase> getAllVuelosBase() {
        lstVuelosBase.clear();
        initializeVueloBase();

        return lstVuelosBase;
    }

    public static ValidationResult addVueloBase(VueloBase v) {
        ValidationResult retValue = new ValidationResult(true, "");
        VueloBase aux = getVueloBaseByCodigo(v.getCodigoVuelo());
        if (aux == null) {
            lstVuelosBase.add(v);
        } else {
            retValue = new ValidationResult(false, "El vuelo base ya existe.No se añadirá a la lista.");
        }
        return retValue;
    }

    public static VueloBase getVueloBaseByCodigo(String codigoVuelo) {
        Optional<VueloBase> optValorSalida = lstVuelosBase.stream()
                .filter(value -> value.getCodigoVuelo().equals(codigoVuelo))
                .findFirst();
        if (optValorSalida.isPresent()) {
            return optValorSalida.get();
        } else {
            return null;
        }
    }

    public static List<VueloBase> getVueloBaseByFecha(Date fecha) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);

        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        String diaSemanaCad = "";
        switch (diaSemana) {
            case Calendar.SUNDAY:
                diaSemanaCad = "D";
                break;
            case Calendar.MONDAY:
                diaSemanaCad = "L";
                break;
            case Calendar.TUESDAY:
                diaSemanaCad = "M";
                break;
            case Calendar.WEDNESDAY:
                diaSemanaCad = "X";
                break;
            case Calendar.THURSDAY:
                diaSemanaCad = "J";
                break;
            case Calendar.FRIDAY:
                diaSemanaCad = "V";
                break;
            case Calendar.SATURDAY:
                diaSemanaCad = "S";
                break;
            default:
                diaSemanaCad = "";
        }
        return getVuelosBaseByDiaSemana(diaSemanaCad);
    }

    public static List<VueloBase> getVuelosBaseByDiaSemana(String diaSemana) {
        //.matches("*"+diaSemana+"*"))
        List<VueloBase> lstVuelosByDiaSemana = lstVuelosBase.stream()
                .filter(v -> v.getDiasOperacion()
                .contains(diaSemana))
                .toList();
        return lstVuelosByDiaSemana;
    }

    public static List<VueloBase> getVueloBaseByAeropuertoOrigen(String codigoIATA) {
        return lstVuelosBase.stream()
                .filter(v -> v.getCodigoAeropuertoOrigen().equals(codigoIATA))
                .toList();
    }

    public static List<VueloBase> getVueloBaseByAeropuetoDestino(String codigoIATA) {
        return lstVuelosBase.stream()
                .filter(v -> v.getCodigoAeropuertoDestino().equals(codigoIATA))
                .toList();
    }

    public static void updateVueloBaseByCodigo(String codigo, VueloBase newVuelo) {
        VueloBase oldVuelo = getVueloBaseByCodigo(codigo);
        if (oldVuelo != null) {
            oldVuelo.setAeropuertoDestino(newVuelo.getAeropuertoDestino());
            oldVuelo.setAeropuertoOrigen(newVuelo.getAeropuertoOrigen());
            oldVuelo.setDiasOperacion(newVuelo.getDiasOperacion());
            oldVuelo.setHoraLlegada(newVuelo.getHoraLlegada());
            oldVuelo.setHoraSalida(newVuelo.getHoraSalida());
            oldVuelo.setNumeroPlazas(newVuelo.getNumeroPlazas());
        }
    }

    public static void escribirVuelosBaseCsv(List<VueloBase> vuelos) {
        String encabezado = "CODIGOVUELO;NUMEROPLAZAS;HORASALIDA;HORALLEGADA;DIASOPERACION;CODIGOAEROPUERTOORIGEN;CODIGOAEROPUERTODESTINO";
        try (FileWriter fw = new FileWriter("./src/main/resources/VuelosBase.csv")) {
            fw.write(encabezado + "\n");
            for (VueloBase v : vuelos) {
                fw.write(v.toCsvString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteVueloBaseByCodigo(String codigo) {
        VueloBase delVuelo = getVueloBaseByCodigo(codigo);
        if (delVuelo != null) {
            lstVuelosBase.remove(delVuelo);
        }
    }

    //Logica de Vuelo Diario
    private static List<VueloDiario> lstVuelosDiarios = new ArrayList<VueloDiario>();

    public static List<VueloDiario> getAllVuelosDiarios() {
        return lstVuelosDiarios;
    }

    public static VueloDiario getVueloDiarioByCodigoVueloBase(String codigo) {
        return new VueloDiario();
    }

    public static List<VueloDiario> getVueloDiarioByFecha(Date fecha) {
        List<VueloDiario> lstVueloDiarioByFecha = lstVuelosDiarios.stream()
                .filter(v -> v.getFechaVuelo()
                .equals(fecha))
                .toList();
        return lstVueloDiarioByFecha;
    }

    public static Date getFechaByHora(int horas, int minutos) {
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 1, 1, horas, minutos);
        Date fecha = cal.getTime();
        return fecha;
    }

    public static String getHoraByFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(fecha);
    }
}
