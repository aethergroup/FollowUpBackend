package com.x86.followup.module.gym.infrastructure.controller;

import com.x86.followup.module.gym.application.service.GymService;
import com.x86.followup.module.gym.domain.exception.GymNotFoundException;
import com.x86.followup.module.gym.domain.model.*;
import com.x86.followup.module.gym.infrastructure.controller.dto.GymRequest;
import com.x86.followup.module.gym.infrastructure.controller.dto.GymResponse;
import com.x86.followup.module.gym.infrastructure.controller.dto.GymUpdateRequest;
import com.x86.followup.module.user.infrastructure.controller.dto.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/gym")
@RequiredArgsConstructor
public class GymController {

    private final GymService gymService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody GymRequest request){
        LocalDateTime now = LocalDateTime.now();

        Gym newGym = new Gym(
                null,
                new GymName(request.name()),
                new GymEmail(request.email()),
                new GymPhone(request.phone()),
                new GymAddress(request.address()),
                new GymPasswordHash(request.password()),
                new GymCreatedAt(Timestamp.valueOf(now))
        );

        gymService.save(newGym);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody GymUpdateRequest request) {
        Gym existingGym = gymService.findById(id)
                .orElseThrow(() -> new GymNotFoundException("No se encontro el Gym para actualizar"));

        Gym updateGym = new Gym(
                existingGym.getId(),
                request.name() != null ? new GymName(request.name()) : existingGym.getName(),
                request.email() != null ? new GymEmail(request.email()) : existingGym.getEmail(),
                request.phone() != null ? new GymPhone(request.phone()) : existingGym.getPhone(),
                request.address() != null ? new GymAddress(request.address()) : existingGym.getAddress(),
                request.password() != null ? new GymPasswordHash(request.password()) : existingGym.getPasswordHash(),
                existingGym.getCreatedAt()
        );
        gymService.update(updateGym);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        gymService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymResponse> findById(@PathVariable Integer id){
        GymId gymId = new GymId(id);
        Gym gym = gymService.findById(gymId.getValue())
                .orElseThrow(() -> new GymNotFoundException("El gym con el ID" + id + "no fue encontrado"));

        return ResponseEntity.ok(mapToResponse(gym));
    }

    @GetMapping
    public ResponseEntity<List<GymResponse>> findAll(){
        List<GymResponse> responses = gymService.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    private GymResponse mapToResponse(Gym gym){
        return new GymResponse(
                gym.getId().getValue(),
                gym.getName().getValue(),
                gym.getEmail().getValue(),
                gym.getPhone().getValue(),
                gym.getAddress().getValue()
        );
    }
}
