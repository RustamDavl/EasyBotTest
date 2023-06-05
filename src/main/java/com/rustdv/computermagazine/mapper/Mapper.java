package com.rustdv.computermagazine.mapper;

public interface Mapper <F, T> {

    T map(F from);


}
