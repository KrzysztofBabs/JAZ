package org.example.queries.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

public interface DualPredicate {
    boolean check(SearchParameters searchParameters, Person person);

}
