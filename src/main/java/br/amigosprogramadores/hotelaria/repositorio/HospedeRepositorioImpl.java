package br.amigosprogramadores.hotelaria.repositorio;

import br.amigosprogramadores.hotelaria.config.ConexaoBD;
import br.amigosprogramadores.hotelaria.entidades.Hospede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospedeRepositorioImpl {

    public int criar(Hospede hospede) {

        Connection conn = new ConexaoBD().obterConexao();

        int resultado = 0;

        try {

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO HOSPEDES (IDHOSPEDES, NOMEHOSPEDE, IDADEHOSPEDE, CPFHOSPEDE) VALUE (?, ?, ?, ?)");

            pstmt.setInt(1, hospede.getIdHospede());
            pstmt.setString(2, hospede.getNomeHospede());
            pstmt.setInt(3,hospede.getIdadeHospede());
            pstmt.setString(4, hospede.getCpfHospede());

            resultado = pstmt.executeUpdate();

            conn.commit();

            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return resultado;
    }

    public Hospede obter(int id) {

        Hospede hospede = null;

        Connection conn = new ConexaoBD().obterConexao();

        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOSPEDES WHERE IDHOSPEDES = ?");

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                hospede = new Hospede();

                hospede.setIdHospede(rs.getInt(1));
                hospede.setNomeHospede(rs.getString(2));
                hospede.setIdadeHospede(rs.getInt(3));
                hospede.setCpfHospede(rs.getString(4));
            }

            rs.close();
            pstmt.close();

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return hospede;

    }

    public int atualizar(Hospede hospede) {

        Connection conn = new ConexaoBD().obterConexao();

        int resultado = 0;

        try {

            PreparedStatement pstmt = conn.prepareStatement("UPDATE HOSPEDES SET NOMEHOSPEDE = ?, IDADEHOSPEDE = ?, CPFHOSPEDE = ? WHERE IDHOSPEDES = ?");

            pstmt.setString(1, hospede.getNomeHospede());
            pstmt.setInt(2, hospede.getIdadeHospede());
            pstmt.setString(3, hospede.getCpfHospede());
            pstmt.setInt(4, hospede.getIdHospede());

            resultado = pstmt.executeUpdate();
            conn.commit();

            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return resultado;
    }

    public int remover(int id) {

        Connection conn = new ConexaoBD().obterConexao();

        int resultado = 0;

        try {

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM HOSPEDES WHERE IDHOSPEDES = ?");

            pstmt.setInt(1, id);

            resultado = pstmt.executeUpdate();
            conn.commit();

            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return resultado;
    }

    public List<Hospede> listar() {

        Connection conn = new ConexaoBD().obterConexao();

        List<Hospede> hospedes = new ArrayList<Hospede>();

        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HOSPEDES");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Hospede hospede = new Hospede();

                hospede.setIdHospede(rs.getInt(1));
                hospede.setNomeHospede(rs.getString(2));
                hospede.setIdadeHospede(rs.getInt(3));
                hospede.setCpfHospede(rs.getString(4));

                hospedes.add(hospede);

            }

            rs.close();
            pstmt.close();

        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return hospedes;

    }
}
