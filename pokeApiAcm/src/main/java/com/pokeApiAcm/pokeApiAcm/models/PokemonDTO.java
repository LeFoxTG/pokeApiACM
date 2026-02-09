package com.pokeApiAcm.pokeApiAcm.models;

import com.google.gson.annotations.SerializedName;

public record PokemonDTO(
        @SerializedName("id")int id,
        @SerializedName("name")String name,
        @SerializedName("height") int height,
        @SerializedName("weight") int weight,
        Sprites sprites) {

        public record Sprites(
                @SerializedName("other") Other other) {
        }

        public record Other(
                @SerializedName("dream_world") DreamWorld dreamWorld) {
        }

        public record DreamWorld(
                @SerializedName("front_default") String front_default) {
        }
}
