package model;

public class Parqueadero {
    private int horas;
    private String tipoCarro;
    private boolean conLavado;

    public Parqueadero(int horas, String tipoCarro, boolean conLavado) {
        this.horas = horas;
        this.tipoCarro = tipoCarro;
        this.conLavado = conLavado;
    }

    public String calcularValores() {
        Carros carro = new Carros(tipoCarro);

        int valorLavado = 0;
        if (conLavado) {
            valorLavado = carro.valorLavar(tipoCarro);
        }
        int valorParqueo = carro.valorParqueo(horas, conLavado);

        // FACTURA
        StringBuilder resultado = new StringBuilder();
        resultado.append("Valor Parqueo: ").append(valorParqueo);
        if (conLavado) {
            resultado.append("\nValor Lavado: ").append(valorLavado);
            resultado.append("\nTotal a Pagar: ").append(valorParqueo + valorLavado);
        } else {
            resultado.append("\nTotal a Pagar: ").append(valorParqueo);
        }

        return resultado.toString();
    }
}