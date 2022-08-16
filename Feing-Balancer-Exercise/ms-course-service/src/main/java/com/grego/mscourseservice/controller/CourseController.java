package com.grego.mscourseservice.controller;

import com.grego.mscourseservice.domain.Course;
import com.grego.mscourseservice.domain.Subscription;
import com.grego.mscourseservice.repository.feing.ISubscription;
import com.grego.mscourseservice.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CourseController.class);

    private ISubscription subscriptionService;
    private CourseService courseService;


    @GetMapping("/{courseId}")
    public ResponseEntity<Course> findCoursebyId(@PathVariable Long courseId, @RequestHeader Long userId, HttpServletResponse responsehttp) {
        LOGGER.info("findCoursebyId: {}", courseId);
        ResponseEntity<Course> response = ResponseEntity.badRequest().build();
        ResponseEntity<Subscription> subscription = subscriptionService.getSubscription(userId);
        LOGGER.info("subscription: {}", subscription.toString());
        LocalDate now = LocalDate.now();
        if (subscription.getBody() != null) {

            if (now.isBefore(subscription.getBody().getEndDate()) && now.isAfter(subscription.getBody().getStartDate())) {
                responsehttp.addHeader("port", Objects.requireNonNull(subscription.getHeaders().get("port")).toString());
                LOGGER.info("subscription is valid");
                LOGGER.debug(subscription.getBody().getStartDate().toString());
                LOGGER.debug(subscription.getBody().getEndDate().toString());
                LOGGER.info("findCoursebyId: {}", courseId);
                response = ResponseEntity.ok(courseService.findById(courseId));
            }
            else{
                throw new IllegalArgumentException("subscription is not valid");
            }
        }
        return response;

    }


}
