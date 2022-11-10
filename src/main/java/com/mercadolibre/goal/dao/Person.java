package com.mercadolibre.goal.dao;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Address address;
    private UserType userType;

    public enum UserType {
        @SerializedName("admin")
        ADMIN,
        @SerializedName("normal")
        NORMAL
    }
}
