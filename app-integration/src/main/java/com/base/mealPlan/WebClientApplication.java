package com.base.mealPlan;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientApplication {

    private String URLModule;

    private final WebClient webClient;

    public WebClientApplication() {
        this.webClient = WebClient.builder().baseUrl("http://127.0.0.1:5000").build();
    }

    protected <T> T post(String uri, Object requestPayload, Class<T> responseType) {
        try {
            return (T) webClient.post()
                    .uri(uri)
                    .bodyValue(requestPayload)
                    .retrieve()
                    .bodyToMono(responseType)
                    .block();
        }catch(Exception e){
                System.out.println(e);
                return null;
        }
    }
}
