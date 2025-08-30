package br.amigosprogramadores.hotelaria.entidades;

public class Quarto {
    private int idQuarto;
    private int numeroQuarto;
    private String tipoQuarto;
    private int andarQuarto;
    private double valorQuarto;

    public Quarto(){};

    public Quarto(int idQuarto, int numeroQuarto, String tipoQuarto, int andarQuarto, double valorQuarto) {
        this.idQuarto = idQuarto;
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.andarQuarto = andarQuarto;
        this.valorQuarto = valorQuarto;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getAndarQuarto() {
        return andarQuarto;
    }

    public void setAndarQuarto(int andarQuarto) {
        this.andarQuarto = andarQuarto;
    }

    public double getValorQuarto() {
        return valorQuarto;
    }

    public void setValorQuarto(double valorQuarto) {
        this.valorQuarto = valorQuarto;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "idQuarto=" + idQuarto +
                ", numeroQuarto=" + numeroQuarto +
                ", tipoQuarto='" + tipoQuarto + '\'' +
                ", andarQuarto=" + andarQuarto +
                ", valorQuarto=" + valorQuarto +
                '}';
    }
}
