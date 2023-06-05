package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.read.ReadLaptopDto;
import com.rustdv.computermagazine.entity.Laptop;
import org.springframework.stereotype.Component;

@Component
public class ReadLaptopDtoMapper implements Mapper<Laptop, ReadLaptopDto> {
    @Override
    public ReadLaptopDto map(Laptop from) {
        return ReadLaptopDto.builder()
                .id(String.valueOf(from.getId()))
                .amount(String.valueOf(from.getAmount()))
                .price(from.getPrice().toString())
                .series(from.getSeries())
                .size(from.getLaptopSize().toString())
                .producer(from.getProducer())
                .build();
    }
}
