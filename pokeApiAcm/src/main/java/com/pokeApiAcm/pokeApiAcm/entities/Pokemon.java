package com.pokeApiAcm.pokeApiAcm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
}
