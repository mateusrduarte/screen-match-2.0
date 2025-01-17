package com.example.screenmatch.application;

import com.example.screenmatch.model.DadosSerie;
import com.example.screenmatch.service.ConsumoAPI;
import com.example.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoAPI();
        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=bb69bdfd");
        System.out.println(json);

//        json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//        System.out.println(json);

        ConverteDados converteDados = new ConverteDados();
        DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);
    }
}
