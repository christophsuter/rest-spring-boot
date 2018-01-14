package ch.noser.kpz.springbootdemo.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class HalList extends ResourceSupport {

    private final List<String> numbers;

    @JsonCreator
    public HalList(List<String> numbers) {
        this.numbers = numbers;
    }

    HalList(int offset, int length) {
        numbers = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            numbers.add("" + (offset + i));
        }
    }


    public List<String> getNumbers() {
        return numbers;
    }
}