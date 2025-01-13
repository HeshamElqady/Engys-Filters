package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RegexFilterTest {

    @Test
    public void TestMatchesDoesMatchWhenValueMatchesRegex() {
        Map<String, String> resource = new HashMap<>();
        resource.put("Name", "Marco");
        Filter filter = new RegexFilter("Name","^[a-zA-Z]+$");
        assertTrue(filter.matches(resource));
    }

    @Test
    public void TestMatchesDoesNotMatchWhenValueDoesNotMatchesRegex() {
        Map<String, String> resource = new HashMap<>();
        resource.put("Name", "Marco1");
        Filter filter = new RegexFilter("Name","^[a-zA-Z]+$");
        assertFalse(filter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsAbsent() {
        Map<String, String> resource = new HashMap<>();
        resource.put("Age", "20");
        Filter filter = new RegexFilter("Name","^[a-zA-Z]+$");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }
}