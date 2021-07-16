package org.cyrol.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OauthClient {
    clientUI("user-ui"),
    customerUI("customer-ui");

    private String value;
}
