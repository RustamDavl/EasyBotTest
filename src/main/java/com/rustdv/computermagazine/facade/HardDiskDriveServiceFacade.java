package com.rustdv.computermagazine.facade;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateHardDiskDriveDto;
import com.rustdv.computermagazine.dto.read.ReadHardDiskDriveDto;
import com.rustdv.computermagazine.entity.HardDiskDrive;
import com.rustdv.computermagazine.mapper.CreateUpdateHardDiskDriveDtoMapper;
import com.rustdv.computermagazine.mapper.ReadHardDiskDriveDtoMapper;
import com.rustdv.computermagazine.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HardDiskDriveServiceFacade implements GoodsServiceFacade<ReadHardDiskDriveDto, CreateUpdateHardDiskDriveDto> {

    private final ReadHardDiskDriveDtoMapper readHardDiskDriveDtoMapper;

    private final CreateUpdateHardDiskDriveDtoMapper createUpdateHardDiskDriveDtoMapper;

    private final GoodsService<HardDiskDrive> hardDiskDriveService;

    @Override
    public ReadHardDiskDriveDto create(CreateUpdateHardDiskDriveDto goods) {
        return readHardDiskDriveDtoMapper.map(
                hardDiskDriveService.create(
                        createUpdateHardDiskDriveDtoMapper.map(goods)
                )
        );
    }

    @Override
    public ReadHardDiskDriveDto edit(Long id, CreateUpdateHardDiskDriveDto goods) {
        return readHardDiskDriveDtoMapper.map(
                hardDiskDriveService.edit(id,
                        createUpdateHardDiskDriveDtoMapper.map(goods))
        );
    }

    @Override
    public ReadHardDiskDriveDto findById(Long id) {
        return readHardDiskDriveDtoMapper.map(
                hardDiskDriveService.findById(id)
        );
    }

    @Override
    public List<ReadHardDiskDriveDto> findAll() {
        return hardDiskDriveService.findAll()
                .stream()
                .map(readHardDiskDriveDtoMapper::map)
                .toList();
    }
}
