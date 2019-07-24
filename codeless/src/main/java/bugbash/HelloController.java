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

    @RequestMapping("/http-dependency/success")
    public String httpDependency() throws IOException {
        return get("https://httpstat.us/200");
    }

    @RequestMapping("/http-dependency/failure")
    public String httpDependencyFailure() throws IOException {
        return get("https://httpstat.us/500");
    }

    private static String get(String url) throws IOException {
        return getWithApacheHttpClient4(url);
    }

    private static String getWithApacheHttpClient4(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        String body = EntityUtils.toString(response.getEntity());
        httpClient.close();
        return "Response from " + url + " was: " + body;
    }
}
