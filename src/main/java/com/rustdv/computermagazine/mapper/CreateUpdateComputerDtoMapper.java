package com.rustdv.computermagazine.mapper;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateComputerDto;
import com.rustdv.computermagazine.entity.Computer;
import com.rustdv.computermagazine.entity.embeddable.FormFactor;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdateComputerDtoMapper implements Mapper<CreateUpdateComputerDto, Computer> {

    @Override
    public Computer map(CreateUpdateComputerDto from) {

        return Computer.builder()
                .amount(from.getAmount())
                .producer(from.getProducer())
                .price(from.getPrice())
                .formFactor(FormFactor.getFormFactor(from.getFormFactor()))
                .series(from.getSeries())
                .build();

    }
}
