package com.pokeApiAcm.pokeApiAcm.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.pokeApiAcm.pokeApiAcm.models.PokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PokeService {

    private HttpClient client;

    public PokeService(@Autowired HttpClient client) {
        this.client = client;
    }

    public PokemonDTO getPokeByName(String name) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = "https://pokeapi.co/api/v2/pokemon/" +
                name;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(str)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        PokemonDTO pokemonDTO = gson.fromJson(response.body(), PokemonDTO.class);
        gson.toJson(pokemonDTO, PokemonDTO.class, new JsonWriter(new FileWriter("src/main/resources/pokemon.json")));
        System.out.println(pokemonDTO.toString());
        return pokemonDTO;
    };
}
