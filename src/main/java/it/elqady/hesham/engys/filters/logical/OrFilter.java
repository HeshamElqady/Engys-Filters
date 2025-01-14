package it.elqady.hesham.engys.filters.logical;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public List<Filter> getFilters() {
        return filters;
    }
}
