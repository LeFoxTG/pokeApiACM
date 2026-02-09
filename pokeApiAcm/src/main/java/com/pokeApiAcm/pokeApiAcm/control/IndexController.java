package com.pokeApiAcm.pokeApiAcm.control;

import com.pokeApiAcm.pokeApiAcm.models.PokemonDTO;
import com.pokeApiAcm.pokeApiAcm.services.PokeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.IOException;

@Controller
@RequestMapping("/pokemon")
public class IndexController {

    private PokeService pokeService;

    public IndexController(@Autowired PokeService pokeService) {
        this.pokeService = pokeService;
    }

    @GetMapping("/consult")
    public String consult(Model model) {
        return "index";
    }

    @GetMapping("/consulted")
    public String consulted(HttpServletRequest request, Model model) throws IOException, InterruptedException {
        String name =request.getParameter("name");

        PokemonDTO pokemonDTO = pokeService.getPokeByName(name);

        model.addAttribute("name", pokemonDTO.name());
        model.addAttribute("id", pokemonDTO.id());
        model.addAttribute("height", pokemonDTO.height());
        model.addAttribute("weight", pokemonDTO.weight());
        model.addAttribute("sprites", pokemonDTO.sprites().other().dreamWorld().front_default());
        model.addAttribute("name", name);
        return "pokeView";
    }

}
