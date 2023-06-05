package com.rustdv.computermagazine.facade;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateComputerDto;
import com.rustdv.computermagazine.dto.read.ReadComputerDto;
import com.rustdv.computermagazine.entity.Computer;
import com.rustdv.computermagazine.mapper.CreateUpdateComputerDtoMapper;
import com.rustdv.computermagazine.mapper.ReadComputerDtoMapper;
import com.rustdv.computermagazine.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ComputerServiceFacade implements GoodsServiceFacade<ReadComputerDto, CreateUpdateComputerDto> {

    private final GoodsService<Computer> computerService;

    private final CreateUpdateComputerDtoMapper createUpdateComputerDtoMapper;

    private final ReadComputerDtoMapper readComputerDtoMapper;


    @Override
    public ReadComputerDto create(CreateUpdateComputerDto goods) {

        return readComputerDtoMapper.map(
                computerService.create(
                        createUpdateComputerDtoMapper.map(goods)
                )
        );
    }

    @Override
    public ReadComputerDto edit(Long id, CreateUpdateComputerDto goods) {
        return readComputerDtoMapper.map(
                computerService.edit(id, createUpdateComputerDtoMapper.map(goods))
        );
    }

    @Override
    public ReadComputerDto findById(Long id) {

        return readComputerDtoMapper.map(
                computerService.findById(id)
        );
    }

    @Override
    public List<ReadComputerDto> findAll() {
        return computerService.findAll()
                .stream()
                .map(readComputerDtoMapper::map)
                .toList();
    }
}
