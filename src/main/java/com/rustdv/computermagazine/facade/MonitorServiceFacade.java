package com.rustdv.computermagazine.facade;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateMonitorDto;
import com.rustdv.computermagazine.dto.read.ReadMonitorDto;
import com.rustdv.computermagazine.entity.Monitor;
import com.rustdv.computermagazine.mapper.CreateUpdateMonitorDtoMapper;
import com.rustdv.computermagazine.mapper.ReadMonitorDtoMapper;
import com.rustdv.computermagazine.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MonitorServiceFacade implements GoodsServiceFacade<ReadMonitorDto, CreateUpdateMonitorDto> {

    private final GoodsService<Monitor> monitorService;
    private final CreateUpdateMonitorDtoMapper createUpdateMonitorDtoMapper;

    private final ReadMonitorDtoMapper readMonitorDtoMapper;

    @Override
    public ReadMonitorDto create(CreateUpdateMonitorDto goods) {
        return readMonitorDtoMapper.map(
                monitorService.create(
                        createUpdateMonitorDtoMapper.map(goods)
                )
        );
    }

    @Override
    public ReadMonitorDto edit(Long id, CreateUpdateMonitorDto goods) {
        return readMonitorDtoMapper.map(
                monitorService.edit(id,
                        createUpdateMonitorDtoMapper.map(goods))
        );
    }

    @Override
    public ReadMonitorDto findById(Long id) {
        return readMonitorDtoMapper.map(
                monitorService.findById(id)
        );
    }

    @Override
    public List<ReadMonitorDto> findAll() {
        return monitorService.findAll()
                .stream()
                .map(readMonitorDtoMapper::map)
                .toList();
    }
}
