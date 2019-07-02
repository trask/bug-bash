package bugbash;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    private static final Logger logger = LogManager.getLogger();

    @RequestMapping("/hello")
    public String index() {
        return "Hello!";
    }

    @RequestMapping("/log/fatal")
    public String logFatal() throws IOException {
        logger.error("this is a fatal message");
        return "fatal message was logged";
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
