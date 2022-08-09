package com.grego.msweatherservice.domain;

public class InfoServer {
    private String name;
    private String description;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public InfoServer() {
    }

    public InfoServer(String name, String description, String version) {
        this.name = name;
        this.description = description;
        this.version = version;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
