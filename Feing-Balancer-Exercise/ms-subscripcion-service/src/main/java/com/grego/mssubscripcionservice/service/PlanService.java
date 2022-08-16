package com.grego.mssubscripcionservice.service;

import com.grego.mssubscripcionservice.domain.Plan;
import com.grego.mssubscripcionservice.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;


}
