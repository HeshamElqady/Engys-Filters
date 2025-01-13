package it.elqady.hesham.engys.filters.logical;

import it.elqady.hesham.engys.filters.Filter;

import java.util.List;
import java.util.Map;

public class OrFilter implements Filter {

    private final List<Filter> filters;

    public OrFilter(Filter... filters) {
        this.filters = List.of(filters);
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return filters.stream()
                .map(filter -> filter.matches(resource))
                .reduce(false, Boolean::logicalOr);
    }

    @Override
    public String toString() {
        return filters.stream()
                .map(Filter::toString)
                .reduce((a, b) -> String.format("or(%s, %s)", a, b))
                .orElse("true");
    }
}
