package model;

public class Carros implements Tarifas {
    private String tipo; // "automovil" o "campero"

    public Carros(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int valorLavar(String tipoCarro) {
        if (tipoCarro.equalsIgnoreCase("automovil")) {
            return LAVADO_AUTOMOVIL;
        } else if (tipoCarro.equalsIgnoreCase("campero")) {
            return (int) LAVADO_CAMPERO;
        }
        return 0;
    }

    @Override
    public int valorParqueo(int horas, boolean conLavado) {
        if (conLavado) {
            horas--; // Descontar una hora si hay lavado
        }
        return PARQUEADERO * Math.max(horas, 0);
    }

    public String getTipo() {
        return tipo;
    }
}