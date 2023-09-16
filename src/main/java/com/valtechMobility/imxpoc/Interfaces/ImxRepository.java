package com.valtechMobility.imxpoc.Interfaces;

import com.valtechMobility.imxpoc.Entities.ImxEntityClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImxRepository extends JpaRepository<ImxEntityClass, Long> {

}