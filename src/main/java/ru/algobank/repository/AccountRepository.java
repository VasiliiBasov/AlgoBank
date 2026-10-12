package ru.algobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.algobank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("UPDATE Account a SET a.balanceMinor = a.balanceMinor - :amount " +
            "WHERE a.id = :id AND a.balanceMinor >= :amount")
    @Modifying
    int debit(@Param("id") Long fromId, @Param("amount") long amount);

    @Query("UPDATE Account a SET a.balanceMinor = a.balanceMinor + :amount " +
            "WHERE a.id = :id")
    @Modifying
    int credit(@Param("id") Long toId, @Param("amount") long amount);
}
