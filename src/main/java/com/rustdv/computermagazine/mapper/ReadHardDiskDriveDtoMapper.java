package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.read.ReadHardDiskDriveDto;
import com.rustdv.computermagazine.entity.HardDiskDrive;
import org.springframework.stereotype.Component;

@Component
public class ReadHardDiskDriveDtoMapper implements Mapper<HardDiskDrive, ReadHardDiskDriveDto> {
    @Override
    public ReadHardDiskDriveDto map(HardDiskDrive from) {

        return ReadHardDiskDriveDto.builder()
                .id(String.valueOf(from.getId()))
                .amount(String.valueOf(from.getAmount()))
                .price(from.getPrice().toString())
                .producer(from.getProducer())
                .series(from.getSeries())
                .volume(from.getHardDiskVolume().toString())
                .build();
    }
}
