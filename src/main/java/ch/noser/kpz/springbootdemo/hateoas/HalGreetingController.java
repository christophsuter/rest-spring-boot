package ch.noser.kpz.springbootdemo.hateoas;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HalGreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/hal-greeting")
    public HttpEntity<HalGreeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        HalGreeting greeting = new HalGreeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(HalGreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}