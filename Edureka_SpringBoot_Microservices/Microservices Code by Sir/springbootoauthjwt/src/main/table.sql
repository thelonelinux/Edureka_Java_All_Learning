CREATE TABLE oauth2_registered_client
(
    id                            varchar(100)                        NOT NULL,
    client_id                     varchar(100)                        NOT NULL,
    client_id_issued_at           timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_secret                 varchar(200)                        NULL,
    client_secret_expires_at      timestamp                           NULL,
    client_name                   varchar(200)                        NOT NULL,
    client_authentication_methods varchar(1000)                       NOT NULL,
    authorization_grant_types     varchar(1000)                       NOT NULL,
    redirect_uris                 varchar(1000)                       NULL,
    scopes                        varchar(1000)                       NOT NULL,
    client_settings               varchar(2000)                       NOT NULL,
    token_settings                varchar(2000)                       NOT NULL,
    PRIMARY KEY (id)
);

insert into oauth2_registered_client values('1','oauth-client','2023-05-14 00:00:01','{noop}oauth-secret','2025-05-14 00:00:01','test','client_secret_basic','refresh_token,client_credentials,authorization_code','http://127.0.0.1:8080/foo/bar,http://127.0.0.1:8080/authorized,http://127.0.0.1:8080/login/oauth2/code/felord-oidc','openid,message.read,message.write','{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.client.require-proof-key\":false,\"settings.client.require-authorization-consent\":true}','{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.token.reuse-refresh-tokens\":true,\"settings.token.id-token-signature-algorithm\":[\"org.springframework.security.oauth2.jose.jws.SignatureAlgorithm\",\"RS256\"],\"settings.token.access-token-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.refresh-token-time-to-live\":[\"java.time.Duration\",3600.000000000]}')