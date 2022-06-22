package com.spotify.oauth2.tests;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class Base {

    @BeforeMethod
    public void beforeMethod(Method method){
        System.out.println("Name of method: " + method.getName());
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }
}
