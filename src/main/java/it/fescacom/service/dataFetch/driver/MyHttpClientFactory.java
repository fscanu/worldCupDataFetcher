package it.fescacom.service.dataFetch.driver;

import java.net.URL;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.internal.ApacheHttpClient;

public class MyHttpClientFactory implements org.openqa.selenium.remote.http.HttpClient.Factory {

    final HttpClientBuilder builder;

    public MyHttpClientFactory(HttpClientBuilder builder) {
        this.builder = builder;
    }

    public HttpClient createClient(URL url) {
        return new ApacheHttpClient(builder.build(), url);
    }
}