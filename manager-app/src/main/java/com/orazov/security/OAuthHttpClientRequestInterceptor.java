package com.orazov.security;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

import java.io.IOException;

@RequiredArgsConstructor
public class OAuthHttpClientRequestInterceptor implements ClientHttpRequestInterceptor {

    private final OAuth2AuthorizedClientManager auth2AuthorizedClientManager;
    private final String registrationId;
    @Setter
    private SecurityContextHolderStrategy securityContextHolderStrategy =
            SecurityContextHolder.getContextHolderStrategy();


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            OAuth2AuthorizedClient auth2AuthorizedClient = this.auth2AuthorizedClientManager
                    .authorize(OAuth2AuthorizeRequest
                    .withClientRegistrationId(this.registrationId)
                    .principal(this.securityContextHolderStrategy.getContext().getAuthentication())
                    .build());
            request.getHeaders().setBearerAuth(auth2AuthorizedClient.getAccessToken().getTokenValue());
        }
        return execution.execute(request, body);
    }
}
