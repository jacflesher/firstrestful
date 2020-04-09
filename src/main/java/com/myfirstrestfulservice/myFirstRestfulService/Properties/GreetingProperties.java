package com.myfirstrestfulservice.myFirstRestfulService.Properties;

public class GreetingProperties {
//    private final long id;
//    private final String greeting;
//
//    public GreetingProperties(long id, String greeting) {
//        this.id = id;
//        this.greeting = greeting;
//    }
//    public long getId() {
//        return id;
//    }
//    public String getGreeting() {
//        return greeting;
//    }

    private final String greeting;

    public GreetingProperties(String greeting) {

        this.greeting = greeting;
    }
    public String getGreeting() {
        return greeting;
    }
}
