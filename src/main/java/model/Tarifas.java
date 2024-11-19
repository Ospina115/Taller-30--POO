package model;

public interface Tarifas {
    int PARQUEADERO = 3000;
    int LAVADO_AUTOMOVIL = 30000;
    double LAVADO_CAMPERO = LAVADO_AUTOMOVIL * 1.5;

    int valorLavar(String tipoCarro);
    int valorParqueo(int horas, boolean conLavado);
}