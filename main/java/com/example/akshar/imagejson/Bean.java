package com.example.akshar.imagejson;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Akshar on 8/25/2017.
 */

public class Bean implements Serializable {
    public String rank,country,population,name,email,phone;
    public JSONArray contact;

    @Override
    public String toString() {
        return "Bean{" +
                "rank='" + rank + '\'' +
                ", country='" + country + '\'' +
                ", population='" + population + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", contact=" + contact +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public JSONArray getContact() {
        return contact;
    }

    public void setContact(JSONArray contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


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

    String imageUrl;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
