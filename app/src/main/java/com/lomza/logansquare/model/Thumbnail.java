package com.lomza.logansquare.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class Thumbnail {

    @JsonField(name = "default")
    private String defaultUrl;

    @JsonField(name = "hqDefault")
    private String hqDefaultUrl;

    public Thumbnail() {

    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    public String getHqDefaultUrl() {
        return hqDefaultUrl;
    }

    public void setHqDefaultUrl(String hqDefaultUrl) {
        this.hqDefaultUrl = hqDefaultUrl;
    }

    @Override
    public String toString() {
        return "{\n" +
                "        \"default\":\"" + defaultUrl + "\",\n" +
                "        \"hqDefault\":\"" + hqDefaultUrl + "\",\n" +
                "}";
    }
}