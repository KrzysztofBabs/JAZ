package org.example.queries.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class ByNameFilter implements IFilterPeople {
    SearchParameters searchParams;

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParams = searchParameters;

    }

    @Override
    public boolean canFilter() {
        return searchParams.getName() != null && searchParams.getName().length() > 0;
    }

    @Override
    public List<Person> filter(List<Person> items) {
        return items.stream().filter(p -> p.getName().contains(searchParams.getName())).toList();
    }
}
