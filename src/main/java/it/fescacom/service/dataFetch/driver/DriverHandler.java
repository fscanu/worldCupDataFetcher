package it.fescacom.service.dataFetch.driver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.HttpClient;
import org.springframework.stereotype.Component;

@Component
public class DriverHandler {

    public RemoteWebDriver connectViaProxy(DesiredCapabilities caps) {
        String proxyHost = "158.169.9.13";
        int proxyPort = 8012;
        String proxyUserDomain = "";
        String proxyUser = "scanufe";
        String proxyPassword = "f1r3_FS5";

        URL url;

        try {
            url = new URL("http://www.skysports.com/world-cup-results");
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        HttpClientBuilder builder = HttpClientBuilder.create();

        HttpHost proxy = new HttpHost(proxyHost, proxyPort);

        CredentialsProvider credsProvider = new BasicCredentialsProvider();

        credsProvider.setCredentials(new AuthScope(proxyHost, proxyPort),
                                     new NTCredentials(proxyUser, proxyPassword, getWorkstation(), proxyUserDomain));

        if (url.getUserInfo() != null && !url.getUserInfo().isEmpty()) {
            credsProvider
                    .setCredentials(new AuthScope(url.getHost(), (url.getPort() > 0 ? url.getPort() : url.getDefaultPort())),
                                    new UsernamePasswordCredentials(url.getUserInfo()));
        }

        builder.setProxy(proxy);
        builder.setDefaultCredentialsProvider(credsProvider);

        HttpClient.Factory factory = new MyHttpClientFactory(builder);

        HttpCommandExecutor executor = new HttpCommandExecutor(new HashMap<String, CommandInfo>(), url, factory);

        return new RemoteWebDriver(executor, caps);
    }

    private String getWorkstation() {
        Map<String, String> env = System.getenv();

        if (env.containsKey("COMPUTERNAME")) {
            // Windows
            return env.get("COMPUTERNAME");
        }
        else if (env.containsKey("HOSTNAME")) {
            // Unix/Linux/MacOS
            return env.get("HOSTNAME");
        }
        else {
            // From DNS
            try {
                return InetAddress.getLocalHost().getHostName();
            }
            catch (UnknownHostException ex) {
                return "Unknown";
            }
        }
    }
}
