package com.x86.followup.module.gym.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGymRepository extends JpaRepository<GymEntity, Integer> {
}
