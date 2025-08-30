package br.amigosprogramadores.hotelaria.repositorio;

import br.amigosprogramadores.hotelaria.config.ConexaoBD;
import br.amigosprogramadores.hotelaria.entidades.Quarto;
import br.amigosprogramadores.hotelaria.entidades.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositorioImpl {

    public int criar(Reserva reserva) {

        Connection conn = new ConexaoBD().obterConexao();

        int resultado = 0;

        try {

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO RESERVA (IDRESERVA, DATAINICIO, DATAFINAL, NUMEROQUARTO, QUANTIDADEHOSPEDES, RESPONSAVELRESERVA) VALUE (?, ?, ?, ?, ?, ?)");

            pstmt.setInt(1, reserva.getIdReserva());
            pstmt.setDate(2, java.sql.Date.valueOf(reserva.getDataInicio()));
            pstmt.setDate(3, java.sql.Date.valueOf(reserva.getDataFinal()));
            pstmt.setInt(4, reserva.getNumeroQuarto());
            pstmt.setInt(5, reserva.getQuantidadeHospedes());
            pstmt.setString(6, reserva.getResponsavelReserva());


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

    public Reserva obter(int id) {

        Reserva reserva = null;

        Connection conn = new ConexaoBD().obterConexao();

        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM RESERVA WHERE IDRESERVA = ?");

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                reserva = new Reserva();

                reserva.setIdReserva(rs.getInt(1));
                reserva.setDataInicio(rs.getDate(2).toLocalDate());
                reserva.setDataFinal(rs.getDate(3).toLocalDate());
                reserva.setNumeroQuarto(rs.getInt(4));
                reserva.setQuantidadeHospedes(rs.getInt(5));
                reserva.setResponsavelReserva(rs.getString(6));
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

        return reserva;

    }

    public int atualizar(Reserva reserva) {

        Connection conn = new ConexaoBD().obterConexao();

        int resultado = 0;

        try {

            PreparedStatement pstmt = conn.prepareStatement("UPDATE RESERVA SET DATAINICIO = ?, DATAFINAL = ?, NUMEROQUARTO = ?, QUANTIDADEHOSPEDES = ?, NOMERESPONSAVEL = ? WHERE IDRESERVA = ?");



            pstmt.setDate(1, java.sql.Date.valueOf(reserva.getDataInicio()));
            pstmt.setDate(2, java.sql.Date.valueOf(reserva.getDataFinal()));
            pstmt.setInt(3, reserva.getNumeroQuarto());
            pstmt.setInt(4, reserva.getQuantidadeHospedes());
            pstmt.setString(5, reserva.getResponsavelReserva());
            pstmt.setInt(6, reserva.getIdReserva());

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

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM RESERVA WHERE IDRESERVA = ?");

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

    public List<Reserva> listar() {

        Connection conn = new ConexaoBD().obterConexao();

        List<Reserva> reservas = new ArrayList<Reserva>();

        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM RESERVA");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Reserva reserva = new Reserva();

                reserva.setIdReserva(rs.getInt(1));
                reserva.setDataInicio(rs.getDate(2).toLocalDate());
                reserva.setDataFinal(rs.getDate(3).toLocalDate());
                reserva.setNumeroQuarto(rs.getInt(4));
                reserva.setQuantidadeHospedes(rs.getInt(5));
                reserva.setResponsavelReserva(rs.getString(6));

                reservas.add(reserva);

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

        return reservas;

    }
}
