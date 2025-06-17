package com.ez.crm.module.client.repository;

import com.ez.crm.module.auth.core.view.ClientAuthView;
import com.ez.crm.module.client.core.entity.ClientEntity;
import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.PageRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByEmail(String email);


    Optional<ClientAuthView> findAuthByEmail(String email);

    boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM client c WHERE c.id = :id")
    int deleteIfExists(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE client c SET c.lastAccessUtc = :time WHERE c.id = :id")
    void updateLastAccess(@Param("id") Long id, @Param("time") LocalDateTime time);

    @Query("SELECT c FROM client c WHERE (:email IS NULL OR c.email LIKE %:email%)")
    Page<ClientEntity> findAllByEmail(@Param("email") String email, Pageable pageable);



}
