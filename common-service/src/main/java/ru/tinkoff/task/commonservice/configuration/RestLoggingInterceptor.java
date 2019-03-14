package ru.tinkoff.task.commonservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RestLoggingInterceptor implements ClientHttpRequestInterceptor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logResponse(ClientHttpResponse response) {
        StringBuilder body = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(response.getBody(), StandardCharsets.UTF_8)
            );
            String line;
            while ((line = br.readLine()) != null)
                body.append(line);
            log.debug("============================response begin==========================================\n" +
                            "Status code: {}\n" +
                            "Status text: {}\n" +
                            "Headers    : {}\n" +
                            "Body       : {}\n" +
                            "=======================response end=================================================",
                    response.getStatusCode(), response.getStatusText(), response.getHeaders(), body.toString());
        } catch (IOException e) {

        }
    }

    private void logRequest(HttpRequest request) {
        log.debug("{}: {}", request.getMethod(), request.getURI());
    }
}