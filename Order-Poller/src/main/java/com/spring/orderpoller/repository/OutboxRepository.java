package com.spring.orderpoller.repository;

import com.spring.orderpoller.entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutboxRepository extends JpaRepository<Outbox,Long> {

    List<Outbox> findByProcessed(boolean processed);
}
