package com.spotify.oauth2.api;

import com.spotify.oauth2.pojo.Playlist;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.oauth2.api.Route.*;
import static com.spotify.oauth2.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {


    public static Response post(String token, String path, Object requestPlaylist){
        return given(getRequestSpecs()).
                auth().oauth2(token).
                body(requestPlaylist).
        when().
                post(path).
        then().spec(getResponseSpecs()).
                extract().
                response();
    }

    public static Response postAccount(HashMap<String, String> formdata){
        return given(getAccRequestSpecs()).
                formParams(formdata).
        when().
                post(API+TOKEN).
        then().
                extract().
                response();
    }



    public static Response get(String token, String  path){
        return given(getRequestSpecs()).
                auth().oauth2(token).
        when().
                get(path).
        then().spec(getResponseSpecs()).
                extract().
                response();
    }

    public static Response update(String token,String path, Object requestPlaylist){
        return given(getRequestSpecs()).
                auth().oauth2(token).
                body(requestPlaylist).
        when().
                put(path).
        then().spec(getResponseSpecs()).
                extract().
                response();
    }


}
