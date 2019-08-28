package bugbash;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@RestController
public class HelloController {

    Counter counter = Metrics.counter("mycounter", "tag1", "tag2");
    
    @RequestMapping("/hello")
    public String index() {
        counter.increment();
        return "Hello!";
    }

    @RequestMapping("/exception")
    public String exception() {
        throw new RuntimeException();
    }
}
