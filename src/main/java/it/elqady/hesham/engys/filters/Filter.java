package it.elqady.hesham.engys.filters;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
public interface Filter {
    boolean matches(Map<String, String> resource);

    default String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}