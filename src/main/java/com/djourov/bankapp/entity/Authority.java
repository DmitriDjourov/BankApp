package com.djourov.bankapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "authorities")
@NoArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "au_id")
    private UUID au_id;

    @Column(name = "authority")
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;
}
