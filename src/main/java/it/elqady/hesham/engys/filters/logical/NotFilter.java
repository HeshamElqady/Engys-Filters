package it.elqady.hesham.engys.filters.logical;

import it.elqady.hesham.engys.filters.Filter;

import java.util.Map;

public class NotFilter implements Filter {

    private final Filter filter;

    public NotFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return !filter.matches(resource);
    }

    @Override
    public String toString() {
        return String.format("not(%s)", filter.toString());
    }

}
