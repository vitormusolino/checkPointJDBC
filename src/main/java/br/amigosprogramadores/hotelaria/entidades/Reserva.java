package br.amigosprogramadores.hotelaria.entidades;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private int numeroQuarto;
    private int quantidadeHospedes;
    private String responsavelReserva;

    public Reserva(int id, LocalDate dataInicio, LocalDate dataFinal, int numeroQuarto, int qtdHospedes, String responsavel) {
        this.idReserva = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.numeroQuarto = numeroQuarto;
        this.quantidadeHospedes = qtdHospedes;
        this.responsavelReserva = responsavel;
    }


    public Reserva(){};

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    public void setQuantidadeHospedes(int quantidadeHospedes) {
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public String getResponsavelReserva() {
        return responsavelReserva;
    }

    public void setResponsavelReserva(String responsavelReserva) {
        this.responsavelReserva = responsavelReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", numeroQuarto=" + numeroQuarto +
                ", quantidadeHospedes=" + quantidadeHospedes +
                ", responsavelReserva='" + responsavelReserva + '\'' +
                '}';
    }
}
