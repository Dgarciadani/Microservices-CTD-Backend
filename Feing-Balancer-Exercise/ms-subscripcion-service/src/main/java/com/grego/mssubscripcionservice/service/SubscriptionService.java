package com.grego.mssubscripcionservice.service;

import com.grego.mssubscripcionservice.domain.Subscription;
import com.grego.mssubscripcionservice.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {
     private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SubscriptionService.class);

    private SubscriptionRepository subscriptionRepository;

    public Subscription findByUserId(Long userId) {
        LOGGER.info("findByUserId: {}", userId);
        return subscriptionRepository.findByUserId(userId);
    }
}
