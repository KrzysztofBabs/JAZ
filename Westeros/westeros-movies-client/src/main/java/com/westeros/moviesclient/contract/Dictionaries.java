package com.westeros.moviesclient.contract;

public class Dictionaries {
    public record GenreDto(int id, String name){}
    public record CountryDto(String englishName, String nativeName, String isoCode){}
    public record LanguageDto(String name, String englishName, String isoCode){}
}
