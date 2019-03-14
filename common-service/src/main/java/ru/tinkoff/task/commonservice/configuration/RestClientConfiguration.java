package ru.tinkoff.task.commonservice.configuration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;

@Configuration
public class RestClientConfiguration {
    @Bean
    RestTemplate customerRestTemplate(RestTemplateBuilder restTemplateBuilder,
                                     HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory,
                                     @Value("${rest.api.customerservice.url}") String url,
                                     @Value("${rest.api.timeout:10}") Integer timeout) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(timeout))
                .setReadTimeout(Duration.ofSeconds(timeout))
                .requestFactory(() -> new BufferingClientHttpRequestFactory(httpComponentsClientHttpRequestFactory))
                .rootUri(url)
                .interceptors(Collections.singleton(new RestLoggingInterceptor()))
                .build();
    }

    @Bean
    RestTemplate accountRestTemplate(RestTemplateBuilder restTemplateBuilder,
                                     HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory,
                                     @Value("${rest.api.accountservice.url}") String url,
                                     @Value("${rest.api.timeout:10}") Integer timeout) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(timeout))
                .setReadTimeout(Duration.ofSeconds(timeout))
                .requestFactory(() -> new BufferingClientHttpRequestFactory(httpComponentsClientHttpRequestFactory))
                .rootUri(url)
                .interceptors(Collections.singleton(new RestLoggingInterceptor()))
                .build();
    }

    @Bean
    HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager =
                new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(200);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100);
        CloseableHttpClient httpClient = HttpClients.custom()
                .disableCookieManagement()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}