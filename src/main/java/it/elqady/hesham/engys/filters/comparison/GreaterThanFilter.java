package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.Filter;
import it.elqady.hesham.engys.filters.exception.FiltersException;

import java.util.Map;

public class GreaterThanFilter implements Filter {

    private final String key;
    private final String value;

    public GreaterThanFilter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        if (!new PresenceFilter(key).matches(resource))
            throw new FiltersException("No such a property within the given resource");

        String resourceValue = resource.get(key);
        if (!isNumeric(resourceValue)) {
            throw new FiltersException("Resource value for key '" + key + "' must be numeric: " + resourceValue);
        }
        return Double.parseDouble(resourceValue) > Double.parseDouble(value);
    }

    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
