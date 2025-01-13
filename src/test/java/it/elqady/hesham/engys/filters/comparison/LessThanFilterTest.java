package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LessThanFilterTest {

    @Test
    public void TestMatchesDoesMatchWhenLessThan() {
        Map<String, String> resource = new HashMap<>();
        resource.put("age", "15");
        Filter filter = new LessThanFilter("age", "25");
        assertTrue(filter.matches(resource));
    }

    @Test
    public void testMatchesDoesNotMatchWhenGreaterThan() {
        Map<String, String> resource = new HashMap<>();
        resource.put("age", "40");
        Filter filter = new LessThanFilter("age", "35");
        assertFalse(filter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsAbsent() {
        Map<String, String> resource = new HashMap<>();
        Filter filter = new LessThanFilter("age", "20");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsNotNumeric() {
        Map<String, String> resource = new HashMap<>();
        resource.put("Role", "Admin");
        Filter filter = new LessThanFilter("Role", "20");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }
}