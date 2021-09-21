package me.vegura.transactionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.vegura.transactionario.domain.dbmodel.Snapshot;

public interface SnapshotRepository extends JpaRepository<Snapshot, Long>{

}
