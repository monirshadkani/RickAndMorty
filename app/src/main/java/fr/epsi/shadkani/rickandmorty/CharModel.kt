package fr.epsi.shadkani.rickandmorty

import java.io.Serializable

class CharModel(
    private val char_name: String,
    private val char_status: String,
    private val char_species: String,
    private val char_origin: String,
    private val char_image: String
) : Serializable {
    fun getCharName() = char_name
    fun getCharStatus() = char_status
    fun getCharSpecies() = char_species
    fun getCharOrigin() = char_origin
    fun getCharImage() = char_image
}