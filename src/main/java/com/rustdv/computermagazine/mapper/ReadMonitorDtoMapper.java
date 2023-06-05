package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.read.ReadMonitorDto;
import com.rustdv.computermagazine.entity.Monitor;
import org.springframework.stereotype.Component;

@Component
public class ReadMonitorDtoMapper implements Mapper<Monitor, ReadMonitorDto> {

    @Override
    public ReadMonitorDto map(Monitor from) {
        return ReadMonitorDto.builder()
                .id(String.valueOf(from.getId()))
                .amount(String.valueOf(from.getAmount()))
                .price(from.getPrice().toString())
                .series(from.getSeries())
                .diagonal(from.getDiagonal().toString())
                .producer(from.getProducer())
                .build();
    }
}
