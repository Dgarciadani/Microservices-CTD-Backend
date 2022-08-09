package com.grego.msweatherservice.controller;

import com.grego.msweatherservice.domain.InfoServer;
import com.grego.msweatherservice.service.InfoServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @Autowired
    private InfoServerService infoServerService;

    @GetMapping("/info")
    public ResponseEntity<InfoServer> getInfo() {
        return ResponseEntity.ok(infoServerService.getInfoServer());
    }
}
