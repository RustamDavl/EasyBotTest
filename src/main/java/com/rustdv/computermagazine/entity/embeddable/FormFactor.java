package com.rustdv.computermagazine.entity.embeddable;

import com.rustdv.computermagazine.exception.NoSuchEnumElementException;

import java.util.Arrays;

public enum FormFactor {

    DESKTOP("настольный пк"),
    NETTOP("нет-топ"),
    MONOBLOCK("моноблок");

    private String form;

    FormFactor(String form) {
        this.form = form;
    }

    public static FormFactor getFormFactor(String form) {
        var formFactors = Arrays.stream(FormFactor.values())
                .filter(formFactor -> formFactor.form.equals(form))
                .toList();

        if (formFactors.isEmpty()) {
            throw new NoSuchEnumElementException("there is no such element in enum");
        }
        return formFactors.get(0);
    }

    @Override
    public String toString() {
        return form;
    }
}
