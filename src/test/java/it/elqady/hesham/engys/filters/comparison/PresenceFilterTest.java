package it.elqady.hesham.engys.filters.comparison;

import it.elqady.hesham.engys.filters.Filter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PresenceFilterTest {

    @Test
    public void TestMatchesDoesMatchWhenPropertyIsPresent() {
        Map<String, String> resource = new HashMap<>();
        resource.put("Name", "Marco");
        Filter filter = new PresenceFilter("Name");
        assertTrue(filter.matches(resource));
    }

    @Test
    public void testMatchesDoesNotMatchWhenPropertyIsNotPresent() {
        Map<String, String> resource = new HashMap<>();
        Filter filter = new PresenceFilter("Name");
        assertFalse(filter.matches(resource));
    }
}