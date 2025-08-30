package br.amigosprogramadores.hotelaria.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {
    public Connection obterConexao() {

        String url = "jdbc:mysql://localhost:3306/fiap";
        String user = "root";
        String pwd = "fiap";

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, pwd);

            if (conn != null) {
                conn.setAutoCommit(false);
                System.out.println("Conexão estabelecida com sucesso!!");
            } else {
                System.out.println("Conexão não estabelecida!!");
            }
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        return conn;

    }

    public static void main(String[] args) {

        ConexaoBD con = new ConexaoBD();
        con.obterConexao();

    }
}
