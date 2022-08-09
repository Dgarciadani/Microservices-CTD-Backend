package com.grego.msweatherservice.service;

import com.grego.msweatherservice.domain.InfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class InfoServerService {
    private final Environment environment;


    public InfoServerService(Environment environment) {
        this.environment = environment;
    }

    public InfoServer getInfoServer() {
        InfoServer infoServer = new InfoServer();
        infoServer.setName(environment.getProperty("info.app.name"));
        infoServer.setDescription(environment.getProperty("info.app.description"));
        infoServer.setVersion(environment.getProperty("info.app.version"));
        return infoServer;
    }

}
