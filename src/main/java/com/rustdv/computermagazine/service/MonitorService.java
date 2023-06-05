package com.rustdv.computermagazine.service;

import com.rustdv.computermagazine.entity.Monitor;
import com.rustdv.computermagazine.exception.NoSuchElementException;
import com.rustdv.computermagazine.repository.MonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MonitorService implements GoodsService<Monitor> {

    private final MonitorRepository monitorRepository;

    @Override
    @Transactional
    public Monitor create(Monitor goods) {
        return monitorRepository.save(goods);
    }

    @Override
    @Transactional
    public Monitor edit(Long id, Monitor goods) {

        var maybeMonitor = monitorRepository.findById(id);

        return maybeMonitor.map(
                        monitor -> monitorRepository.saveAndFlush(update(monitor, goods))
                )
                .orElseThrow(() -> {
                            throw new NoSuchElementException("there is no goods with such id");
                        }
                );
    }

    @Override
    public Monitor findById(Long id) {
        return monitorRepository.findById(id).orElseThrow(
                () -> {
                    throw new NoSuchElementException("there is no goods with such id");
                }
        );
    }

    @Override
    public List<Monitor> findAll() {
        return monitorRepository.findAll();
    }

    private Monitor update(Monitor current, Monitor updated) {

        if (updated.getAmount() != null) {
            current.setAmount(updated.getAmount());
        }
        if (updated.getPrice() != null) {
            current.setPrice(updated.getPrice());
        }
        if (updated.getDiagonal() != null) {
            current.setDiagonal(updated.getDiagonal());
        }
        if (updated.getProducer() != null) {
            current.setProducer(updated.getProducer());
        }
        if (updated.getSeries() != null) {
            current.setSeries(updated.getSeries());
        }

        return current;
    }
}
