package br.amigosprogramadores.hotelaria.repositorio;

import br.amigosprogramadores.hotelaria.config.ConexaoBD;
import br.amigosprogramadores.hotelaria.entidades.Hospede;
import br.amigosprogramadores.hotelaria.entidades.Quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepositorioImpl {

    public int criar(Quarto quarto) {

        Connection conn = new ConexaoBD().obterConexao();

        int resultado = 0;

        try {

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO QUARTOS (IDQUARTO, NUMEROQUARTO, TIPOQUARTO, ANDARQUARTO, VALORQUARTO) VALUE (?, ?, ?, ?, ?)");

            pstmt.setInt(1, quarto.getIdQuarto());
            pstmt.setInt(2, quarto.getNumeroQuarto());
            pstmt.setString(3, quarto.getTipoQuarto());
            pstmt.setInt(4,quarto.getAndarQuarto());
            pstmt.setDouble(5, quarto.getValorQuarto());

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

    public Quarto obter(int id) {

        Quarto quarto = null;

        Connection conn = new ConexaoBD().obterConexao();

        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM QUARTOS WHERE IDQUARTO = ?");

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                quarto = new Quarto();

                quarto.setIdQuarto(rs.getInt(1));
                quarto.setNumeroQuarto(rs.getInt(2));
                quarto.setTipoQuarto(rs.getString(3));
                quarto.setAndarQuarto(rs.getInt(4));
                quarto.setValorQuarto(rs.getDouble(5));
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

        return quarto;

    }

    public int atualizar(Quarto quarto) {

        Connection conn = new ConexaoBD().obterConexao();

        int resultado = 0;

        try {

            PreparedStatement pstmt = conn.prepareStatement("UPDATE QUARTOS SET NUMEROQUARTO = ?, TIPOQUARTO = ?, ANDARQUARTO = ?, VALORQUARTO = ? WHERE IDQUARTO = ?");


            pstmt.setInt(1, quarto.getNumeroQuarto());
            pstmt.setString(2, quarto.getTipoQuarto());
            pstmt.setInt(3,quarto.getAndarQuarto());
            pstmt.setDouble(4, quarto.getValorQuarto());
            pstmt.setInt(5, quarto.getIdQuarto());

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

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM QUARTOS WHERE IDQUARTO = ?");

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

    public List<Quarto> listar() {

        Connection conn = new ConexaoBD().obterConexao();

        List<Quarto> quartos = new ArrayList<Quarto>();

        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM QUARTOS");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Quarto quarto = new Quarto();

                quarto.setIdQuarto(rs.getInt(1));
                quarto.setNumeroQuarto(rs.getInt(2));
                quarto.setTipoQuarto(rs.getString(3));
                quarto.setAndarQuarto(rs.getInt(4));
                quarto.setValorQuarto(rs.getDouble(5));

                quartos.add(quarto);

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

        return quartos;

    }
}
