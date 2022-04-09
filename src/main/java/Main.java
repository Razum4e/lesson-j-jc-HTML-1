import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(URL);
        get.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        CloseableHttpResponse httpResponse = httpClient.execute(get);
        String body = new String(httpResponse.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
        Type itemsListType = new TypeToken<List<FactCat>>() {
        }.getType();
        List<FactCat> factsCats = new Gson().fromJson(body, itemsListType);
        List<FactCat> filterFactsCats = factsCats.stream()
                .filter(value -> value.getUpvotes() != null && value.getUpvotes() > 0)
                .collect(Collectors.toList());
        filterFactsCats.forEach(System.out::println);

    }
}
