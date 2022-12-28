package com.sevensevengsi.laundry.repository;

import com.sevensevengsi.laundry.model.MachineStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<MachineStatus, Integer> {
}
