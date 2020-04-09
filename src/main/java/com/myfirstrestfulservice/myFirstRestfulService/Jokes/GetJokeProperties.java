package com.myfirstrestfulservice.myFirstRestfulService.Jokes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetJokeProperties {

    @JsonProperty("setup")
    private String setup;

    @JsonProperty("delivery")
    private String delivery;

    public String getSetup() {
        return setup;
    }

    public String setSetup(String setup) {
        this.setup = setup;
        return setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public String setDelivery(String delivery) {
        this.delivery = delivery;
        return delivery;
    }

}
