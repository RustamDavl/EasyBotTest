package com.rustdv.computermagazine.repository;

import com.rustdv.computermagazine.entity.HardDiskDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDiskDriveRepository extends JpaRepository<HardDiskDrive, Long> {
}
