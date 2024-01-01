package com.apirest.truevision.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Encode_Image {
    @JsonProperty(value = "encode_string")
    private String encode_string;

    public Encode_Image() {
    }

    public Encode_Image(String encode_string) {
        this.encode_string = encode_string;
    }

    public String getEncode_string() {
        return encode_string;
    }

    public void setEncode_string(String encode_string) {
        this.encode_string = encode_string;
    }
}