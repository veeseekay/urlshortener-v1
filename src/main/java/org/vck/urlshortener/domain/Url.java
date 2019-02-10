package org.vck.urlshortener.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author viswanath.ck
 */
public class Url {

    private String url;

    @JsonCreator
    public Url() { }

    @JsonCreator
    public Url(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

