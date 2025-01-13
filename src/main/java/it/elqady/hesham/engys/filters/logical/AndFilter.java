package it.elqady.hesham.engys.filters.logical;

import it.elqady.hesham.engys.filters.Filter;

import java.util.List;
import java.util.Map;

public class AndFilter implements Filter {

    private final List<Filter> filters;

    public AndFilter(Filter... filters) {
        this.filters = List.of(filters);
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return filters.stream().allMatch(filter -> filter.matches(resource));
    }

    @Override
    public String toString() {
        return filters.stream()
                .map(Filter::toString)
                .reduce((a, b) -> String.format("and(%s, %s)", a, b))
                .orElse("true");
    }
}
