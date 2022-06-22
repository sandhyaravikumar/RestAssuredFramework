package com.spotify.oauth2.Utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    public static String generateName(){
        Faker faker = new Faker();
        return faker.regexify("[A-Za-Z0-9 ]{10}");
    }

    public static String generateDescription(){
        Faker faker = new Faker();
        return faker.regexify("[A-Za-Z0-9 ,/;#!]{50}");
    }
}
