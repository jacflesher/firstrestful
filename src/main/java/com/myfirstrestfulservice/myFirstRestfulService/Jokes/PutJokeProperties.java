package com.myfirstrestfulservice.myFirstRestfulService.Jokes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PutJokeProperties {
    private Integer formatVersion;
    private String category;
    private String type;
    @JsonProperty(value = "flags")
    private FlagsProperties flagsProperties;
    private String setup;
    private String delivery;

    public Integer getFormatVersion() {
        return formatVersion;
    }

    public void setFormatVersion(Integer formatVersion) {
        this.formatVersion = formatVersion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FlagsProperties getFlagsProperties() {
        return flagsProperties;
    }

    public void setFlagsProperties(FlagsProperties flagsProperties) {
        this.flagsProperties = flagsProperties;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }


}