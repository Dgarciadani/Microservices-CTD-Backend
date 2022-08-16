package com.grego.mssubscripcionservice.controller;

import com.grego.mssubscripcionservice.domain.Subscription;
import com.grego.mssubscripcionservice.service.SubscriptionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/subscription")
@AllArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    private final Environment environment;

    @GetMapping("/find")
    public ResponseEntity<Subscription> findByUserId(@RequestParam Long userId, HttpServletResponse response) {
       response.addHeader("port", environment.getProperty("server.port"));
        return ResponseEntity.ok(subscriptionService.findByUserId(userId));
    }

}
