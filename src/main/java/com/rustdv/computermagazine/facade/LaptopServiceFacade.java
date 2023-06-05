package com.rustdv.computermagazine.facade;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateLaptopDto;
import com.rustdv.computermagazine.dto.read.ReadLaptopDto;
import com.rustdv.computermagazine.entity.Laptop;
import com.rustdv.computermagazine.mapper.CreateUpdateLaptopDtoMapper;
import com.rustdv.computermagazine.mapper.ReadLaptopDtoMapper;
import com.rustdv.computermagazine.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LaptopServiceFacade implements GoodsServiceFacade<ReadLaptopDto, CreateUpdateLaptopDto> {

    private final CreateUpdateLaptopDtoMapper createUpdateLaptopDtoMapper;

    private final ReadLaptopDtoMapper readLaptopDtoMapper;

    private final GoodsService<Laptop> laptopService;

    @Override
    public ReadLaptopDto create(CreateUpdateLaptopDto goods) {
        return readLaptopDtoMapper.map(
                laptopService.create(
                        createUpdateLaptopDtoMapper.map(goods)
                )
        );
    }

    @Override
    public ReadLaptopDto edit(Long id, CreateUpdateLaptopDto goods) {
        return readLaptopDtoMapper.map(
                laptopService.edit(id,
                        createUpdateLaptopDtoMapper.map(goods))
        );
    }

    @Override
    public ReadLaptopDto findById(Long id) {
        return readLaptopDtoMapper.map(
                laptopService.findById(id)
        );
    }

    @Override
    public List<ReadLaptopDto> findAll() {
        return laptopService.findAll()
                .stream()
                .map(readLaptopDtoMapper::map)
                .toList();
    }
}
