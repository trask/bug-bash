package bugbash;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello!";
    }

    @RequestMapping("/service-a")
    public String serviceA() throws IOException {
        return get("http://localhost:8081/hello");
    }

    @RequestMapping("/service-ab")
    public String serviceAB() throws IOException {
        return get("http://localhost:8081/service-b");
    }

    private static String get(String url) throws IOException {
        return getWithApacheHttpClient4(url);
    }

    private static String getWithApacheHttpClient4(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        String body = EntityUtils.toString(response.getEntity());
        httpClient.close();
        return body;
    }
}
