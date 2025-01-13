package it.elqady.hesham.engys.filters;

import java.util.Map;

public interface Filter {
    boolean matches(Map<String, String> resource);
    String toString();
}