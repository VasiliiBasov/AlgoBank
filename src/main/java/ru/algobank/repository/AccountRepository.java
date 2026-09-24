package ru.algobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.algobank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
