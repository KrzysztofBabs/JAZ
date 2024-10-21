package org.example.queries.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.function.Predicate;

public class GeneralFilter implements IFilterPeople{
    SearchParameters searchParams;
    Predicate<SearchParameters> canFilterPredicate;
    DualPredicate filterDualPrediacte;

    public GeneralFilter(SearchParameters searchParams, Predicate<SearchParameters> canFilterPredicate, DualPredicate filterDualPrediacte) {
        this.searchParams = searchParams;
        this.canFilterPredicate = canFilterPredicate;
        this.filterDualPrediacte = filterDualPrediacte;
    }


    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParams = searchParameters;

    }

    @Override
    public boolean canFilter() {
        return canFilterPredicate.test(searchParams);
    }

    @Override
    public List<Person> filter(List<Person> items) {
        return items.stream().filter(p->filterDualPrediacte.check(searchParams, p)).toList();
    }
}
