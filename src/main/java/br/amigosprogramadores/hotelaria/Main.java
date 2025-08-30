package br.amigosprogramadores.hotelaria;

import br.amigosprogramadores.hotelaria.config.ConexaoBD;
import br.amigosprogramadores.hotelaria.entidades.Hospede;
import br.amigosprogramadores.hotelaria.entidades.Quarto;
import br.amigosprogramadores.hotelaria.entidades.Reserva;
import br.amigosprogramadores.hotelaria.repositorio.HospedeRepositorioImpl;
import br.amigosprogramadores.hotelaria.repositorio.QuartoRepositorioImpl;
import br.amigosprogramadores.hotelaria.repositorio.ReservaRepositorioImpl;

import java.sql.Date;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ConexaoBD conexao = new ConexaoBD();

        //HOSPEDES

        Hospede hospede = new Hospede();
        HospedeRepositorioImpl hospedeRepositorio = new HospedeRepositorioImpl();

        hospede.setIdHospede(3);
        hospede.setNomeHospede("José");
        hospede.setIdadeHospede(20);
        hospede.setCpfHospede("55555555510");

        //hospedeRepositorio.criar(hospede);
        //hospedeRepositorio.obter(3);
        //hospedeRepositorio.atualizar(hospede);
        //System.out.println(hospedeRepositorio.listar());


        //QUARTOS
        Quarto quarto = new Quarto(1,50,"Família",5,400.00);
        Quarto quarto2 = new Quarto(2,22,"Individual",2,200.00);
        QuartoRepositorioImpl quartoRepositorio = new QuartoRepositorioImpl();

        //TESTES

        //quartoRepositorio.criar(quarto);
        //quartoRepositorio.criar(quarto2);
        //System.out.println(quartoRepositorio.obter(1));
        //quartoRepositorio.atualizar(quarto2);
        //quartoRepositorio.remover(2);
        //quartoRepositorio.criar(quarto2);
        //System.out.println(quartoRepositorio.listar());

        //RESERVAS
        Reserva reserva = new Reserva(1, LocalDate.parse("2025-08-10"), LocalDate.parse("2025-08-15"), 50, 4, "Manoel");
        Reserva reserva2 = new Reserva(2, LocalDate.parse("2025-08-10"), LocalDate.parse("2025-08-15"), 50, 4, "Manoel");
        ReservaRepositorioImpl reservaRepositorio = new ReservaRepositorioImpl();

        //reservaRepositorio.criar(reserva);
        //System.out.println(reservaRepositorio.obter(1));
        //System.out.println(reservaRepositorio.listar());
        //reservaRepositorio.criar(reserva2);
        //reservaRepositorio.remover(2);

    }
}
