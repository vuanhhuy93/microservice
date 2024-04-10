package com.huyva.customer.database.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "status")
    private Integer status;

    @Column(name = "password")
    private String password;

    @Column(name = "total_login_fail")
    private Integer totalLoginFail;

    @Column(name = "block_to_time")
    private LocalDateTime blockTotime;
}
