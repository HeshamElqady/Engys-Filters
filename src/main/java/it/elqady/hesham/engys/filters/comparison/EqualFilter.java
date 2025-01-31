package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.Filter;
import it.elqady.hesham.engys.filters.exception.FiltersException;

import java.util.Map;

public class EqualFilter implements Filter {

    private final String key;
    private final String value;

    public EqualFilter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        if (!new PresenceFilter(key).matches(resource))
            throw new FiltersException("No such a property within the given resource");
        return resource.get(key).compareTo(value) == 0;
    }


    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
