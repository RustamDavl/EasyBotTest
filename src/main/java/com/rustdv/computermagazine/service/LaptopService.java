package com.rustdv.computermagazine.service;

import com.rustdv.computermagazine.entity.Laptop;
import com.rustdv.computermagazine.exception.NoSuchElementException;
import com.rustdv.computermagazine.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LaptopService implements GoodsService<Laptop> {

    private final LaptopRepository laptopRepository;


    @Override
    @Transactional
    public Laptop create(Laptop goods) {

        return laptopRepository.save(goods);
    }

    @Override
    @Transactional
    public Laptop edit(Long id, Laptop goods) {

        var maybeLaptop = laptopRepository.findById(id);

        return maybeLaptop.map(
                        laptop -> laptopRepository.saveAndFlush(update(laptop, goods))
                )
                .orElseThrow(() -> {
                            throw new NoSuchElementException("there is no goods with such id");
                        }
                );
    }

    @Override
    public Laptop findById(Long id) {

        return laptopRepository.findById(id).orElseThrow(
                () -> {
                    throw new NoSuchElementException("there is no goods with such id");
                }
        );
    }

    @Override
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    private Laptop update(Laptop current, Laptop updated) {

        if (updated.getAmount() != null) {
            current.setAmount(updated.getAmount());
        }
        if (updated.getPrice() != null) {
            current.setPrice(updated.getPrice());
        }
        if (updated.getLaptopSize() != null) {
            current.setLaptopSize(updated.getLaptopSize());
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
