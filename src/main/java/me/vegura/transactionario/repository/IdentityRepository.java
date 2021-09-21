package me.vegura.transactionario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import me.vegura.transactionario.domain.dbmodel.Identity;

public interface IdentityRepository extends JpaRepository<Identity, UUID> {

}
