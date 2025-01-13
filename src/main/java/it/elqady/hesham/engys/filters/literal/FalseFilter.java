package it.elqady.hesham.engys.filters.literal;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import it.elqady.hesham.engys.filters.comparison.PresenceFilter;

import java.util.Map;

public class FalseFilter implements Filter {
    private final String key;

    public FalseFilter(String key) {
        this.key = key;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        if (!new PresenceFilter(key).matches(resource)) {
            throw new FiltersException("No such a property within the given resource");
        }
        String value = resource.get(key);
        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
            throw new FiltersException("Invalid boolean value for key '" + key + "': " + value);
        }
        return Boolean.parseBoolean(value) == Boolean.FALSE;
    }

    @Override
    public String toString() {
        return String.format("false(%s)", key);
    }
}
