package com.rustdv.computermagazine.service;

import com.rustdv.computermagazine.entity.HardDiskDrive;
import com.rustdv.computermagazine.exception.NoSuchElementException;
import com.rustdv.computermagazine.repository.HardDiskDriveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HardDiskDriveService implements GoodsService<HardDiskDrive> {

    private final HardDiskDriveRepository hardDiskDriveRepository;

    @Override
    @Transactional
    public HardDiskDrive create(HardDiskDrive goods) {

        return hardDiskDriveRepository.save(goods);
    }

    @Override
    @Transactional
    public HardDiskDrive edit(Long id, HardDiskDrive goods) {

        var maybeHardDiskDrive = hardDiskDriveRepository.findById(id);

        return maybeHardDiskDrive.map(
                        hardDiskDrive -> hardDiskDriveRepository.saveAndFlush(update(hardDiskDrive, goods))
                )
                .orElseThrow(() -> {
                            throw new NoSuchElementException("there is no goods with such id");
                        }
                );
    }

    @Override
    public HardDiskDrive findById(Long id) {

        return hardDiskDriveRepository.findById(id).orElseThrow(
                () -> {
                    throw new NoSuchElementException("there is no goods with such id");
                }
        );
    }

    @Override
    public List<HardDiskDrive> findAll() {
        return hardDiskDriveRepository.findAll();
    }

    private HardDiskDrive update(HardDiskDrive current, HardDiskDrive updated) {

        if (updated.getAmount() != null) {
            current.setAmount(updated.getAmount());
        }
        if (updated.getPrice() != null) {
            current.setPrice(updated.getPrice());
        }
        if (updated.getHardDiskVolume() != null) {
            current.setHardDiskVolume(updated.getHardDiskVolume());
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
