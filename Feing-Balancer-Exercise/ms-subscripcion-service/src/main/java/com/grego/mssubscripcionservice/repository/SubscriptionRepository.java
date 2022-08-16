package com.grego.mssubscripcionservice.repository;

import com.grego.mssubscripcionservice.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    public Subscription findByUserId(Long userId);


}
