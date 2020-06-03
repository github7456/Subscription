package com.newsletter.subscription.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription {

    @Id
    private String email;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
