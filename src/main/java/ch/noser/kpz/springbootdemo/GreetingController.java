package ch.noser.kpz.springbootdemo;


import java.util.concurrent.atomic.AtomicLong;

//@RestController()
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


//    @RequestMapping(value = "/greeting/{path}", method = {RequestMethod.GET, RequestMethod.HEAD}, produces = "application/json")
//    public Greeting getGreeting(@RequestParam(value="name", defaultValue="World") String name, @PathVariable(value="path") String path, String test) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name + " " + path));
//    }
//
//    @RequestMapping(value = "/greeting/{path}", method = {RequestMethod.POST}, produces = "application/json")
//    public Greeting postGreeting(@RequestParam(value="name", defaultValue="World") String name,
//                                 @PathVariable(value="path") String path,
//                                 @RequestBody String test) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name + " " + path));
//    }
}