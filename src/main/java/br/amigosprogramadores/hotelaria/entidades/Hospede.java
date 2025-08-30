package br.amigosprogramadores.hotelaria.entidades;

public class Hospede {

    private int idHospede;
    private String nomeHospede;
    private int idadeHospede;
    private String cpfHospede;

    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    public String getCpfHospede() {
        return cpfHospede;
    }

    public void setCpfHospede(String cpfHospede) {
        this.cpfHospede = cpfHospede;
    }

    public int getIdadeHospede() {
        return idadeHospede;
    }

    public void setIdadeHospede(int idadeHospede) {
        this.idadeHospede = idadeHospede;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    @Override
    public String toString() {
        return "Hospede{" + "idHospede: " + idHospede + "; nomeHospede: " + nomeHospede +
                "; idadeHospede: " + idadeHospede + "; cpfHospede: " + cpfHospede + "}";
    }
}
