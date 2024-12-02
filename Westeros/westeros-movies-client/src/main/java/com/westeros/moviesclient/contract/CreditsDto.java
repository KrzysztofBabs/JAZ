package com.westeros.moviesclient.contract;

import java.util.List;

public record CreditsDto(int id, List<ActorSummaryDto> cast) {

    public record ActorSummaryDto(
            long id,
            String name,
            String character,
            String profilePath){

    }
}
