package com.x86.followup.module.subscription.infrastructure.controller;

import com.x86.followup.module.subscription.application.service.SubscriptionService;
import com.x86.followup.module.subscription.domain.model.*;
import com.x86.followup.module.subscription.infrastructure.controller.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SubscriptionCreateRequest request) {
        Subscription subscription = new Subscription(
                new SubscriptionUserId(request.userId()),
                new SubscriptionPlanId(request.planId()),
                new SubscriptionStart(request.startDate()),
                new SubscriptionEnd(request.endDate()),
                SubscriptionStatus.valueOf(request.status())
        );
        subscriptionService.save(subscription);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody SubscriptionUpdateRequest request) {
        SubscriptionId subscriptionId = new SubscriptionId(id);

        Optional<Subscription> existingOpt = subscriptionService.findById(id);
        if (existingOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Subscription existing = existingOpt.get();

        Subscription updatedSubscription = new Subscription(
                existing.getId(),
                request.userId() != null ? new SubscriptionUserId(request.userId()) : existing.getUserId(),
                request.planId() != null ? new SubscriptionPlanId(request.planId()) : existing.getPlanId(),
                request.startDate() != null ? new SubscriptionStart(request.startDate()) : existing.getStart(),
                request.endDate() != null ? new SubscriptionEnd(request.endDate()) : existing.getEnd(),
                request.status() != null ? SubscriptionStatus.valueOf(request.status()) : existing.getStatus()
        );

        subscriptionService.update(updatedSubscription);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        subscriptionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionResponse>> findAll() {
        List<SubscriptionResponse> response = subscriptionService.findAll().stream()
                .map(sub -> new SubscriptionResponse(
                        sub.getId().getValue(),
                        sub.getUserId().getValue(),
                        sub.getPlanId().getValue(),
                        sub.getStart().getValue(),
                        sub.getEnd().getValue(),
                        sub.getStatus().getValue()
                ))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> findById(@PathVariable Integer id) {
        return subscriptionService.findById(id)
                .map(sub -> new SubscriptionResponse(
                        sub.getId().getValue(),
                        sub.getUserId().getValue(),
                        sub.getPlanId().getValue(),
                        sub.getStart().getValue(),
                        sub.getEnd().getValue(),
                        sub.getStatus().getValue()
                ))
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<SubscriptionResponse> findByUserId(@PathVariable Integer userId) {
        return subscriptionService.findByUserId(userId)
                .map(sub -> new SubscriptionResponse(
                        sub.getId().getValue(),
                        sub.getUserId().getValue(),
                        sub.getPlanId().getValue(),
                        sub.getStart().getValue(),
                        sub.getEnd().getValue(),
                        sub.getStatus().getValue()
                ))
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
