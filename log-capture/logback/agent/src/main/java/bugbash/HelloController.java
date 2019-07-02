package bugbash;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String index() {
        return "Hello!";
    }

    @RequestMapping("/log/error")
    public String logError() throws IOException {
        logger.error("this is an error message");
        return "error message was logged";
    }

    @RequestMapping("/log/warn")
    public String logWarn() throws IOException {
        logger.warn("this is a warn message");
        return "warn message was logged";
    }

    @RequestMapping("/log/info")
    public String logInfo() throws IOException {
        logger.info("this is an info message");
        return "info message was logged";
    }

    @RequestMapping("/log/debug")
    public String logDebug() throws IOException {
        logger.debug("this is a debug message");
        return "debug message was logged";
    }

    @RequestMapping("/log/trace")
    public String logTrace() throws IOException {
        logger.trace("this is a trace message");
        return "trace message was logged";
    }
}
