package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.Filter;

import java.util.Map;

public class PresenceFilter implements Filter {

    private final String key;

    public PresenceFilter(String property) {
        this.key = property;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return resource.containsKey(key);
    }


    public String getKey() {
        return key;
    }
}
