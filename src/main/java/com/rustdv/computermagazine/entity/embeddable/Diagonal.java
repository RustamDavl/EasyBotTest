package com.rustdv.computermagazine.entity.embeddable;

import com.rustdv.computermagazine.exception.NoSuchEnumElementException;

import java.util.Arrays;

public enum Diagonal {

    INCH21("21 дюйм"),

    INCH24("24 дюйма"),

    INCH27("27 дюймов"),

    INCH32("32 дюйма");

    private String inch;

    Diagonal(String inch) {
        this.inch = inch;
    }

    public static Diagonal getDiagonal(String inch) {

        var diagonalList = Arrays.stream(Diagonal.values())
                .filter(diagonal -> diagonal.inch.equals(inch))
                .toList();

        if (diagonalList.isEmpty()) {
            throw new NoSuchEnumElementException("there is no such element in enum");
        }
        return diagonalList.get(0);
    }

    @Override
    public String toString() {
        return this.inch;
    }

}
