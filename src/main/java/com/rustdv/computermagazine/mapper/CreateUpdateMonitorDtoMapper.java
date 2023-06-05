package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateMonitorDto;
import com.rustdv.computermagazine.entity.Monitor;
import com.rustdv.computermagazine.entity.embeddable.Diagonal;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdateMonitorDtoMapper implements Mapper<CreateUpdateMonitorDto, Monitor> {

    @Override
    public Monitor map(CreateUpdateMonitorDto from) {
        return Monitor.builder()
                .series(from.getSeries())
                .producer(from.getProducer())
                .price(from.getPrice())
                .amount(from.getAmount())
                .diagonal(Diagonal.getDiagonal(from.getDiagonal()))
                .build();

    }
}
