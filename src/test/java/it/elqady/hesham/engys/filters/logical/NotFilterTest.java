package it.elqady.hesham.engys.filters.logical;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import it.elqady.hesham.engys.filters.comparison.GreaterThanFilter;
import it.elqady.hesham.engys.filters.comparison.LessThanFilter;
import it.elqady.hesham.engys.filters.literal.FalseFilter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NotFilterTest {

    @Test
    public void testMatchesDoesMatchWhenMainFilterDoesNotMatch() {
        Map<String,String> resource= new HashMap<>();
        resource.put("Age","20");
        Filter notFilter = new NotFilter(new GreaterThanFilter("Age","30"));
        assertTrue(notFilter.matches(resource));
    }

    @Test
    public void testMatchesDoesNotMatchWhenMainFilterMatches() {
        Map<String,String> resource= new HashMap<>();
        resource.put("Age","20");
        Filter notFilter = new NotFilter(new LessThanFilter("Age","30"));
        assertFalse(notFilter.matches(resource));
    }

    @Test
    public void testMatchesThrowExceptionWhenPropertyIsAbsent() {
        Map<String, String> resource = new HashMap<>();
        Filter filter = new FalseFilter("isAdmin");
        assertThrows(FiltersException.class, () -> filter.matches(resource));
    }

}