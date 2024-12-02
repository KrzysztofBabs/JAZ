package com.westeros.moviesclient.contract;


import java.time.LocalDate;
import java.util.List;

public record MovieDto(
         boolean adult,
         String backdropPath,
         int budget,
         List<Dictionaries.GenreDto> genres,
         String homepage,
         String originalLanguage,
         String originalTitle,
         String overview,
         double popularity,
         String posterPath,
         List<CompanySummaryDto> productionCompanies,
         List<Dictionaries.CountryDto> productionCountries,
         LocalDate releaseDate,
         int runtime,
         List<Dictionaries.LanguageDto> spokenLanguages,
         int voteCount,
         double voteAverage
        
) {

    public record CompanySummaryDto(int id, String logoPath,String name, String originCountry){}
}
