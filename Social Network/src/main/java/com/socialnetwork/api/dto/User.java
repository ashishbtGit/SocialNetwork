package com.socialnetwork.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("website")
    private String website;

    @JsonProperty("company")
    private Company company;

    @Override
    public String toString(){
        return "Users{"+
                "id:"+ id +
                ", name:"+ name+
                ", username:"+ username +
                ", email:"+ email +
                ", address:"+ address +
                ", phone:"+ phone +
                ", website:"+ website +
                ", company:"+ company +
                "}";
    }

}
