package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateHardDiskDriveDto;
import com.rustdv.computermagazine.entity.HardDiskDrive;
import com.rustdv.computermagazine.entity.embeddable.HardDiskVolume;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdateHardDiskDriveDtoMapper implements Mapper<CreateUpdateHardDiskDriveDto, HardDiskDrive> {
    @Override
    public HardDiskDrive map(CreateUpdateHardDiskDriveDto from) {

        return HardDiskDrive.builder()
                .hardDiskVolume(HardDiskVolume.getVolume(from.getVolume()))
                .amount(from.getAmount())
                .producer(from.getProducer())
                .series(from.getSeries())
                .price(from.getPrice())
                .build();
    }
}
