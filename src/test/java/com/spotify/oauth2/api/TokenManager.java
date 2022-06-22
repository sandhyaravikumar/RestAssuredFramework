package com.spotify.oauth2.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

import static com.spotify.oauth2.Utils.ConfigLoader.getConfigLoader;
import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String  getToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.printf("Renewing Token..");
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiryDurationInseconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInseconds-300);
            }
            else {
                System.out.println("Reusing existing token");
            }

        }
        catch (Exception e){
            throw new RuntimeException(" unable to get token!!");

        }

        return access_token;
    }



    private static Response renewToken(){
        HashMap<String, String> formdata = new HashMap<String, String>();
        formdata.put("grant_type",getConfigLoader().getGrantType());
        formdata.put("refresh_token",getConfigLoader().getRefreshToken());
        formdata.put("client_id",getConfigLoader().getClientId());
        formdata.put("client_secret",getConfigLoader().getClientSecrete());

        Response response = RestResource.postAccount(formdata);
        if (response.statusCode() != 200){
            throw new RuntimeException("Abort !! Renewal of token Failes");
        }
        return response;

    }
}
