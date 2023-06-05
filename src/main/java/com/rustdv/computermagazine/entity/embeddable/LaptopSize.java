package com.rustdv.computermagazine.entity.embeddable;

import com.rustdv.computermagazine.exception.NoSuchEnumElementException;

import java.util.Arrays;

public enum LaptopSize {

    INCH13("13 дюймов"),

    INCH14("14 дюймов"),

    INCH15("15 дюймов"),

    INCH17("17 дюймов");

    private String inch;

    LaptopSize(String inch) {
        this.inch = inch;
    }

    public static LaptopSize getLaptopSize(String inch) {
        var inches = Arrays.stream(LaptopSize.values())
                .filter(laptopSize -> laptopSize.inch.equals(inch))
                .toList();

        if (inches.isEmpty()) {
            throw new NoSuchEnumElementException("there is no such element in enum");
        }
        return inches.get(0);
    }

    @Override
    public String toString() {
        return inch;
    }
}
