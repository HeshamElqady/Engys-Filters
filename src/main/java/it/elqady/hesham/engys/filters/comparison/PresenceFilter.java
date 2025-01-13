package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.Filter;

import java.util.Map;

public class PresenceFilter implements Filter {

    private final String property;

    public PresenceFilter(String property) {
        this.property = property;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return resource.containsKey(property);
    }

    @Override
    public String toString(){
        return String.format("present(%s)", property);
    }
}
