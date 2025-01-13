package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GreaterThanFilterTest {

    @Test
    public void TestMatchesDoesMatchWhenGreaterThan() {
        Map<String, String> resource = new HashMap<>();
        resource.put("age", "30");
        Filter filter = new GreaterThanFilter("age", "25");
        assertTrue(filter.matches(resource));
    }
    @Test
    public void testMatchesDoesNotMatchWhenLessThan() {
        Map<String, String> resource = new HashMap<>();
        resource.put("age", "30");
        Filter filter = new GreaterThanFilter("age", "35");
        assertFalse(filter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsAbsent() {
        Map<String, String> resource = new HashMap<>();
        Filter filter = new GreaterThanFilter("age", "20");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsNotNumeric() {
        Map<String, String> resource = new HashMap<>();
        resource.put("Role","Admin");
        Filter filter = new GreaterThanFilter("Role","20");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }

}