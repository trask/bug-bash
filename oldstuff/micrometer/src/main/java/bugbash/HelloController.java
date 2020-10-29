package bugbash;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@RestController
public class HelloController {

    private final Counter counter = Metrics.counter("bug_bash_counter");
    
    @RequestMapping("/hello")
    public String index() {
        counter.increment();
        return "Hello!";
    }
}
