package com.rustdv.computermagazine.controller;

import com.rustdv.computermagazine.dto.createupdate.CreateUpdateMonitorDto;
import com.rustdv.computermagazine.dto.read.ReadMonitorDto;
import com.rustdv.computermagazine.facade.GoodsServiceFacade;
import com.rustdv.computermagazine.facade.MonitorServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitor")
@RequiredArgsConstructor
public class MonitorController {

    private final GoodsServiceFacade<ReadMonitorDto, CreateUpdateMonitorDto> monitorServiceFacade;

    @PostMapping
    public ResponseEntity<ReadMonitorDto> create(@RequestBody CreateUpdateMonitorDto createUpdateComputerDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(monitorServiceFacade.create(createUpdateComputerDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReadMonitorDto> edit(@PathVariable("id") Long id,
                                               @RequestBody CreateUpdateMonitorDto createUpdateComputerDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(monitorServiceFacade.edit(id, createUpdateComputerDto));
    }

    @GetMapping
    public ResponseEntity<List<ReadMonitorDto>> findAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(monitorServiceFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadMonitorDto> findById(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(monitorServiceFacade.findById(id));
    }
}
