package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateLaptopDto;
import com.rustdv.computermagazine.entity.Laptop;
import com.rustdv.computermagazine.entity.embeddable.LaptopSize;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdateLaptopDtoMapper implements Mapper<CreateUpdateLaptopDto, Laptop> {
    @Override
    public Laptop map(CreateUpdateLaptopDto from) {
        return Laptop.builder()
                .series(from.getSeries())
                .producer(from.getProducer())
                .price(from.getPrice())
                .amount(from.getAmount())
                .laptopSize(LaptopSize.getLaptopSize(from.getSize()))
                .build();
    }
}
