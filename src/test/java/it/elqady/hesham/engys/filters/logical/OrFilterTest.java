package it.elqady.hesham.engys.filters.logical;

import it.elqady.hesham.engys.filters.exception.FiltersException;
import it.elqady.hesham.engys.filters.Filter;
import it.elqady.hesham.engys.filters.comparison.*;
import it.elqady.hesham.engys.filters.literal.FalseFilter;
import it.elqady.hesham.engys.filters.literal.TrueFilter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OrFilterTest {

    @Test
    public void TestMatchesDoesMatchWhenAllFiltersMatch() {
        Map<String,String> resource = new HashMap<>();
        resource.put("Name","Marco");
        resource.put("Age","25");
        resource.put("Gender","Male");
        resource.put("Role","Administrator");
        resource.put("Company","Engys");
        resource.put("Enabled","True");
        resource.put("UnEmployed","False");
        Filter companyFilter= new EqualFilter("Company","Engys");
        Filter enabledFilter = new TrueFilter("Enabled");
        Filter genderPresenceFilter = new PresenceFilter("Gender");
        Filter rolePresenceFilter = new PresenceFilter("Role");
        Filter nameCheckFilter = new RegexFilter("Name","^[a-zA-Z]+$");
        Filter unEmployedFilter = new FalseFilter("UnEmployed");
        Filter minAgeFilter = new GreaterThanFilter("Age","20");
        Filter maxAgeFilter = new LessThanFilter("Age","60");
        Filter roleFilter = new EqualFilter("Role","Administrator");
        Filter orFilter = new OrFilter(companyFilter,enabledFilter,genderPresenceFilter,roleFilter,rolePresenceFilter,nameCheckFilter,unEmployedFilter,minAgeFilter,maxAgeFilter);
        assertTrue(orFilter.matches(resource));
    }

    @Test
    public void TestMatchesDoesMatchWhenOneFilterDoesNotMatch() {
        Map<String,String> resource = new HashMap<>();
        resource.put("Name","Marco");
        resource.put("Age","25");
        resource.put("Gender","Male");
        resource.put("Role","Administrator");
        resource.put("Company","Engys");
        resource.put("Enabled","false");
        resource.put("UnEmployed","False");
        Filter companyFilter= new EqualFilter("Company","Engys");
        Filter enabledFilter = new TrueFilter("Enabled");
        Filter genderPresenceFilter = new PresenceFilter("Gender");
        Filter rolePresenceFilter = new PresenceFilter("Role");
        Filter nameCheckFilter = new RegexFilter("Name","^[a-zA-Z]+$");
        Filter unEmployedFilter = new FalseFilter("UnEmployed");
        Filter minAgeFilter = new GreaterThanFilter("Age","20");
        Filter maxAgeFilter = new LessThanFilter("Age","60");
        Filter roleFilter = new EqualFilter("Role","Administrator");
        Filter orFilter = new OrFilter(companyFilter,enabledFilter,genderPresenceFilter,roleFilter,rolePresenceFilter,nameCheckFilter,unEmployedFilter,minAgeFilter,maxAgeFilter);
        assertTrue(orFilter.matches(resource));
    }

    @Test
    public void TestMatchesDoesMatchWhenMoreFiltersNotMatching() {
        Map<String,String> resource = new HashMap<>();
        resource.put("Name","Marco11");
        resource.put("Age","20");
        resource.put("Gender","Male");
        resource.put("Role","Administrator");
        resource.put("Company","Engys");
        resource.put("Enabled","false");
        resource.put("UnEmployed","False");
        Filter companyFilter= new EqualFilter("Company","Engys");
        Filter enabledFilter = new TrueFilter("Enabled");
        Filter genderPresenceFilter = new PresenceFilter("Gender");
        Filter rolePresenceFilter = new PresenceFilter("Role");
        Filter nameCheckFilter = new RegexFilter("Name","^[a-zA-Z]+$");
        Filter unEmployedFilter = new FalseFilter("UnEmployed");
        Filter minAgeFilter = new GreaterThanFilter("Age","20");
        Filter maxAgeFilter = new LessThanFilter("Age","60");
        Filter roleFilter = new EqualFilter("Role","Administrator");
        Filter orFilter = new OrFilter(companyFilter,enabledFilter,genderPresenceFilter,roleFilter,rolePresenceFilter,nameCheckFilter,unEmployedFilter,minAgeFilter,maxAgeFilter);
        assertTrue(orFilter.matches(resource));
    }
    
    @Test
    public void TestMatchesDoesNotMatchWhenNoFiltersMatching() {
        Map<String,String> resource = new HashMap<>();
        resource.put("Name","Marco11");
        resource.put("Age","70");
        resource.put("Role","User");
        resource.put("Company","Engys");
        resource.put("Enabled","false");
        resource.put("UnEmployed","true");
        Filter companyFilter= new EqualFilter("Company","Facebook");
        Filter enabledFilter = new TrueFilter("Enabled");
        Filter genderPresenceFilter = new PresenceFilter("Gender");
        Filter nameCheckFilter = new RegexFilter("Name","^[a-zA-Z]+$");
        Filter unEmployedFilter = new FalseFilter("UnEmployed");
        Filter maxAgeFilter = new LessThanFilter("Age","60");
        Filter roleFilter = new EqualFilter("Role","Administrator");
        Filter orFilter = new OrFilter(companyFilter,enabledFilter,genderPresenceFilter,roleFilter,nameCheckFilter,unEmployedFilter,maxAgeFilter);
        assertFalse(orFilter.matches(resource));
    }

    @Test
    public void TestMatchesThrowExceptionWhenFiltersHaveProblems() {
        Map<String,String> resource = new HashMap<>();
        resource.put("Name","Marco11");
        resource.put("Age","25");
        resource.put("Gender","Male");
        resource.put("Role","Administrator");
        resource.put("Company","Engys");
        resource.put("Enabled","1");
        resource.put("UnEmployed","False");
        Filter companyFilter= new EqualFilter("Company","Engys");
        Filter enabledFilter = new TrueFilter("Enabled");
        Filter genderPresenceFilter = new PresenceFilter("Gender");
        Filter rolePresenceFilter = new PresenceFilter("Role");
        Filter nameCheckFilter = new RegexFilter("Name","^[a-zA-Z]+$");
        Filter unEmployedFilter = new FalseFilter("UnEmployed");
        Filter minAgeFilter = new GreaterThanFilter("Age","20");
        Filter maxAgeFilter = new LessThanFilter("Age","60");
        Filter roleFilter = new EqualFilter("Role","Administrator");
        Filter orFilter = new OrFilter(companyFilter,enabledFilter,genderPresenceFilter,roleFilter,rolePresenceFilter,nameCheckFilter,unEmployedFilter,minAgeFilter,maxAgeFilter);
        assertThrows(FiltersException.class,()->orFilter.matches(resource));
    }
}