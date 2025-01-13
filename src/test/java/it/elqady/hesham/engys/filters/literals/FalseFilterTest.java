package it.elqady.hesham.engys.filters.literals;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import it.elqady.hesham.engys.filters.literal.TrueFilter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FalseFilterTest {

    @Test
    public void TestMatchesDoesMatchWhenPropertyIsFalse() {
        Map<String,String> resources = new HashMap<>();
        resources.put("isAdmin","true");
        Filter filter = new TrueFilter("isAdmin");
        assertTrue(filter.matches(resources));
    }

    @Test
    public void TestMatchesDoesNotMatchWhenPropertyIsTrue() {
        Map<String,String> resources = new HashMap<>();
        resources.put("isAdmin","false");
        Filter filter = new TrueFilter("isAdmin");
        assertFalse(filter.matches(resources));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsAbsent() {
        Map<String, String> resource = new HashMap<>();
        Filter filter = new TrueFilter("isAdmin");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsNotBoolean() {
        Map<String, String> resource = new HashMap<>();
        resource.put("age","20");
        Filter filter = new TrueFilter("age");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }
}