package com.x86.followup.module.plan.infrastructure.controller;
import com.x86.followup.module.plan.application.service.PlanService;
import com.x86.followup.module.plan.domain.exception.PlanNotFound;
import com.x86.followup.module.plan.domain.model.*;
import com.x86.followup.module.plan.infrastructure.controller.dto.PlanCreateRequest;
import com.x86.followup.module.plan.infrastructure.controller.dto.PlanResponse;
import com.x86.followup.module.plan.infrastructure.controller.dto.PlanUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PlanCreateRequest request){
        Plan newPlan = new Plan(
                null,
                new PlanGymId(request.gymId()),
                new PlanName(request.name()),
                new PlanPrice(request.price()),
                new PlanDurationDay(request.duration()),
                new PlanDescription(request.description()),
                PlanIsActive.ACTIVE
        );
        planService.save(newPlan);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody PlanUpdateRequest request){

        PlanId planId = new PlanId(id);

        Plan existingPlan = planService.findById(planId)
                .orElseThrow(() -> new PlanNotFound("Este plan no existe en nuestro sistema"));

        Plan updatedPlan = new Plan(
                existingPlan.getId(),
                request.gymId() != null ? new PlanGymId(request.gymId()) : existingPlan.getGymId(),
                request.name() != null ? new PlanName(request.name()) : existingPlan.getName(),
                request.price() != null ? new PlanPrice(request.price()) : existingPlan.getPrice(),
                request.duration() != null ? new PlanDurationDay(request.duration()) : existingPlan.getDurationDay(),
                request.description() != null ? new PlanDescription(request.description()) : existingPlan.getDescription(),
                PlanIsActive.ACTIVE
        );
        planService.update(updatedPlan);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        planService.delete(new PlanId(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<PlanResponse>> findAll() {
        List<PlanResponse> response = planService.findAll().stream()
                .map(plan -> new PlanResponse(
                        plan.getName().getValue(),
                        plan.getPrice().getValue(),
                        plan.getDurationDay().getValue(),
                        plan.getDescription().getValue()
                ))
                .toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResponse> findById(@PathVariable Integer id) {
        return planService.findById(new PlanId(id))
                .map(plan -> new PlanResponse(
                        plan.getName().getValue(),
                        plan.getPrice().getValue(),
                        plan.getDurationDay().getValue(),
                        plan.getDescription().getValue()
                ))
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}