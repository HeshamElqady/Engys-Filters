package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class EqualFilterTest {

    @Test
    public void TestMatchesDoesMatchWhenEquals() {
        Map<String, String> resource = new HashMap<>();
        resource.put("role", "administrator");
        Filter filter = new EqualFilter("role", "administrator");
        assertTrue(filter.matches(resource));
    }

    @Test
    public void testMatchesDoesNotMatchWhenNotEquals() {
        Map<String, String> resource = new HashMap<>();
        resource.put("role", "administrator");
        Filter filter = new EqualFilter("role", "user");
        assertFalse(filter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsAbsent() {
        Map<String, String> resource = new HashMap<>();
        Filter filter = new EqualFilter("role", "user");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }
}