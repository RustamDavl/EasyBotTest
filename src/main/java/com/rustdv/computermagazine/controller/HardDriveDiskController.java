package com.rustdv.computermagazine.controller;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateHardDiskDriveDto;
import com.rustdv.computermagazine.dto.read.ReadHardDiskDriveDto;
import com.rustdv.computermagazine.facade.GoodsServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hdd")
@RequiredArgsConstructor
public class HardDriveDiskController {
    private final GoodsServiceFacade<ReadHardDiskDriveDto, CreateUpdateHardDiskDriveDto> hardDiskDriveServiceFacade;

    @PostMapping
    public ResponseEntity<ReadHardDiskDriveDto> create(@RequestBody CreateUpdateHardDiskDriveDto createUpdateHardDiskDriveDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(hardDiskDriveServiceFacade.create(createUpdateHardDiskDriveDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReadHardDiskDriveDto> edit(@PathVariable("id") Long id,
                                                     @RequestBody CreateUpdateHardDiskDriveDto createUpdateHardDiskDriveDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(hardDiskDriveServiceFacade.edit(id, createUpdateHardDiskDriveDto));
    }

    @GetMapping
    public ResponseEntity<List<ReadHardDiskDriveDto>> findAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(hardDiskDriveServiceFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadHardDiskDriveDto> findById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(hardDiskDriveServiceFacade.findById(id));
    }
}
