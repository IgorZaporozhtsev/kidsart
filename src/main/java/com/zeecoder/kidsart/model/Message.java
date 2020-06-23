package com.zeecoder.kidsart.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String email;
}
