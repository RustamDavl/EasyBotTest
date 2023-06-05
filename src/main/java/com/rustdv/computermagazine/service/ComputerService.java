package com.rustdv.computermagazine.service;

import com.rustdv.computermagazine.entity.Computer;
import com.rustdv.computermagazine.exception.NoSuchElementException;
import com.rustdv.computermagazine.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputerService implements GoodsService<Computer> {

    private final ComputerRepository computerRepository;

    @Override
    @Transactional
    public Computer create(Computer goods) {

        return computerRepository.save(goods);
    }

    @Override
    @Transactional
    public Computer edit(Long id, Computer goods) {

        var maybeComputer = computerRepository.findById(id);

        return maybeComputer.map(
                        computer -> computerRepository.saveAndFlush(update(computer, goods))
                )
                .orElseThrow(() -> {
                            throw new NoSuchElementException("there is no goods with such id");
                        }
                );
    }

    @Override
    public Computer findById(Long id) {

        return computerRepository.findById(id).orElseThrow(
                () -> {
                    throw new NoSuchElementException("there is no goods with such id");
                }
        );
    }

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    private Computer update(Computer current, Computer updated) {

        if (updated.getAmount() != null) {
            current.setAmount(updated.getAmount());
        }
        if (updated.getPrice() != null) {
            current.setPrice(updated.getPrice());
        }
        if (updated.getFormFactor() != null) {
            current.setFormFactor(updated.getFormFactor());
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
