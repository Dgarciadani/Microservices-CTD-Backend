package com.grego.mscourseservice.repository.feing;

import com.grego.mscourseservice.domain.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "subscription-service")
public interface ISubscription {

    @GetMapping("/subscription/find")
    public ResponseEntity<Subscription> getSubscription(@RequestParam Long userId);
}
