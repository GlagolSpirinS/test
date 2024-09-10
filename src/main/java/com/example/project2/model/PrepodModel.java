package com.example.project2.model;

import java.util.UUID;

public class PrepodModel {
    private final UUID id;
    private final String name;
    private final String email;
    private final String password;

    public PrepodModel(String name, String email, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

