package ch.noser.kpz.springbootdemo.hateoas;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HalGreeting extends ResourceSupport {

    private final String content;

    @JsonCreator
    HalGreeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}