package com.x86.followup.module.user.infrastructure.controller;

import com.x86.followup.module.user.application.service.UserService;
import com.x86.followup.module.user.domain.exception.UserNotFoundError;
import com.x86.followup.module.user.domain.model.*;
import com.x86.followup.module.user.infrastructure.controller.dto.UserCreateRequest;
import com.x86.followup.module.user.infrastructure.controller.dto.UserResponse;
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
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();

        User newUser = new User(
                null,
                new UserGymId(request.gymId()),
                new UserName(request.name()),
                new UserIdentification(request.identification()),
                UserIdentificationType.valueOf(request.identificationType()),
                new UserPassword(request.password()),
                new UserPhone(request.phone()),
                new UserMembershipStart(Timestamp.valueOf(now)),
                new UserMembershipEnd(Timestamp.valueOf(now.plusMonths(1))),
                UserPaymentMethod.valueOf(request.paymentMethod()),
                UserStatus.ACTIVE,
                new UserCreatedAt(Timestamp.valueOf(now))
        );

        userService.save(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserUpdateRequest request) {
        User existingUser = userService.findById(id)
                .orElseThrow(() -> new UserNotFoundError("Usuario con ID " + id + " no encontrado"));

        User updatedUser = new User(
                existingUser.getId(),
                request.gymId() != null ? new UserGymId(request.gymId()) : existingUser.getGymId(),
                request.name() != null ? new UserName(request.name()) : existingUser.getName(),
                request.identification() != null ? new UserIdentification(request.identification()) : existingUser.getIdentification(),
                request.identificationType() != null ? UserIdentificationType.valueOf(request.identificationType()) : existingUser.getIdentificationType(),
                request.password() != null ? new UserPassword(request.password()) : existingUser.getPassword(),
                request.phone() != null ? new UserPhone(request.phone()) : existingUser.getPhone(),
                existingUser.getMembershipStart(),
                request.membershipEnd() != null ? new UserMembershipEnd(Timestamp.valueOf(request.membershipEnd())) : existingUser.getMembershipEnd(),
                request.paymentMethod() != null ? UserPaymentMethod.valueOf(request.paymentMethod()) : existingUser.getPaymentMethod(),
                request.status() != null ? UserStatus.valueOf(request.status()) : existingUser.getStatus(),
                existingUser.getCreatedAt()
        );

        userService.update(updatedUser);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Integer id) {
        UserId userId = new UserId(id);
        User user = userService.findById(userId.getValue())
                .orElseThrow(() -> new UserNotFoundError("Usuario con ID " + id + " no encontrado"));

        return ResponseEntity.ok(mapToResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> responses = userService.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId().getValue(),
                user.getGymId().value(),
                user.getName().getValue(),
                user.getPhone().getValue(),
                user.getStatus().name(),
                user.getMembershipEnd().getValue().toString()
        );
    }
}