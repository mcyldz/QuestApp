package org.mcyldz.questapp.response;

import lombok.Data;

@Data
public class AuthResponse {

    String message;
    Integer userId;
    String accessToken;
    String refreshToken;
}