package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.read.ReadComputerDto;
import com.rustdv.computermagazine.entity.Computer;
import org.springframework.stereotype.Component;

@Component
public class ReadComputerDtoMapper implements Mapper<Computer, ReadComputerDto> {
    @Override
    public ReadComputerDto map(Computer from) {

        return ReadComputerDto.builder()
                .id(String.valueOf(from.getId()))
                .amount(String.valueOf(from.getAmount()))
                .series(from.getSeries())
                .formFactor(from.getFormFactor().toString())
                .producer(from.getProducer())
                .price(from.getPrice().toString())
                .build();
    }
}
