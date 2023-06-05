package com.rustdv.computermagazine.controller;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateHardDiskDriveDto;
import com.rustdv.computermagazine.dto.createupdate.CreateUpdateLaptopDto;
import com.rustdv.computermagazine.dto.read.ReadGoodsDto;
import com.rustdv.computermagazine.dto.read.ReadHardDiskDriveDto;
import com.rustdv.computermagazine.dto.read.ReadLaptopDto;
import com.rustdv.computermagazine.facade.GoodsServiceFacade;
import com.rustdv.computermagazine.facade.HardDiskDriveServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptop")
@RequiredArgsConstructor
public class LaptopController {

    private final GoodsServiceFacade<ReadLaptopDto, CreateUpdateLaptopDto> laptopServiceFacade;

    @PostMapping
    public ResponseEntity<ReadLaptopDto> create(@RequestBody CreateUpdateLaptopDto createUpdateLaptopDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(laptopServiceFacade.create(createUpdateLaptopDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReadLaptopDto> edit(@PathVariable("id") Long id,
                                              @RequestBody CreateUpdateLaptopDto createUpdateLaptopDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(laptopServiceFacade.edit(id, createUpdateLaptopDto));
    }

    @GetMapping
    public ResponseEntity<List<ReadLaptopDto>> findAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(laptopServiceFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadLaptopDto> findById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(laptopServiceFacade.findById(id));
    }
}
