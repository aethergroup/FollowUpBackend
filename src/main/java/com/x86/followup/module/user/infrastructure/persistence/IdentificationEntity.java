package com.x86.followup.module.user.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "nuip")
@Setter
@Getter
public class IdentificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "cedula")
    private String identification;

    @Column(name = "tipo_documento")
    private String identificationType;
}
