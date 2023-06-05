package com.rustdv.computermagazine.entity.embeddable;

import com.rustdv.computermagazine.exception.NoSuchEnumElementException;

import java.util.Arrays;

public enum HardDiskVolume {

    MB256("256 МБ"),
    MB512("512 МБ"),
    TB1("1 ТБ"),
    TB2("2 ТБ");
    private String volume;
    HardDiskVolume(String volume) {
        this.volume = volume;
    }

    public static HardDiskVolume getVolume(String volume) {
        var volumes = Arrays.stream(HardDiskVolume.values())
                .filter(volume1 -> volume1.volume.equals(volume))
                .toList();

        if (volumes.isEmpty()) {
            throw new NoSuchEnumElementException("there is no such element in enum");
        }
        return volumes.get(0);
    }

    @Override
    public String toString() {
        return volume;
    }
}
