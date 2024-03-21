package com.ever.suinocutura.controller.dto;

import com.ever.suinocutura.model.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
