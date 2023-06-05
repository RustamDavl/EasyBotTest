package com.rustdv.computermagazine.controller;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateComputerDto;
import com.rustdv.computermagazine.dto.createupdate.CreateUpdateLaptopDto;
import com.rustdv.computermagazine.dto.read.ReadComputerDto;
import com.rustdv.computermagazine.dto.read.ReadLaptopDto;
import com.rustdv.computermagazine.facade.ComputerServiceFacade;
import com.rustdv.computermagazine.facade.GoodsServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final GoodsServiceFacade<ReadComputerDto, CreateUpdateComputerDto> computerServiceFacade;

    @PostMapping
    public ResponseEntity<ReadComputerDto> create(@RequestBody CreateUpdateComputerDto createUpdateComputerDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(computerServiceFacade.create(createUpdateComputerDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReadComputerDto> edit(@PathVariable("id") Long id,
                                                @RequestBody CreateUpdateComputerDto createUpdateComputerDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(computerServiceFacade.edit(id, createUpdateComputerDto));
    }

    @GetMapping
    public ResponseEntity<List<ReadComputerDto>> findAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(computerServiceFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadComputerDto> findById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(computerServiceFacade.findById(id));
    }


}
