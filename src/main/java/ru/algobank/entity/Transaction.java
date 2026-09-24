package ru.algobank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long amountMinor;

    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
