package ch.noser.kpz.springbootdemo.hateoas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HalPageinationController {

    private static final int MAX_NUMBER = 1000;


    @RequestMapping("/hal-list")
    public HalList list(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int  offset,
            @RequestParam(value = "length", required = false, defaultValue = "10") int  length) {

        if(offset + length >= MAX_NUMBER) {
            offset = MAX_NUMBER - length;
        }


        HalList list = new HalList(offset, length);


        // Add Links
        list.add(linkTo(methodOn(HalPageinationController.class).list(offset, length)).withSelfRel());

        if(offset+length < MAX_NUMBER) {
            list.add(linkTo(methodOn(HalPageinationController.class).list(offset + length, length)).withRel("next"));
        }

        if(offset-length >= 0) {
            list.add(linkTo(methodOn(HalPageinationController.class).list(offset - length, length)).withRel("prev"));
        }
        list.add(linkTo(methodOn(HalPageinationController.class).list(0, length)).withRel("first"));
        list.add(linkTo(methodOn(HalPageinationController.class).list(MAX_NUMBER-length, length)).withRel("last"));

        return list;
    }


}