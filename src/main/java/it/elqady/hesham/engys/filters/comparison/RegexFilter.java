package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;

import java.util.Map;

public class RegexFilter implements Filter {
    private final String key;
    private final String regex;

    public RegexFilter(String key, String regex) {
        this.key = key;
        this.regex = regex;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        if (!new PresenceFilter(key).matches(resource))
            throw new FiltersException("No such a property within the given resource");
        return resource.get(key).matches(regex);
    }

    @Override
    public String toString() {
        return String.format("regex(%s, \"%s\")", key, regex);
    }
}