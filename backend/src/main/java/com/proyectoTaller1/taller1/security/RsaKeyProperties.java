package com.proyectoTaller1.taller1.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@AllArgsConstructor
@Getter
@ConfigurationProperties(prefix = "rsa")
public class RsaKeyProperties {
    private final RSAPublicKey publicKey;
    private final RSAPrivateKey privateKey;
}
