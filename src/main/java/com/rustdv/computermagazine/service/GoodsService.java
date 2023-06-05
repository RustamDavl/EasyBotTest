package com.rustdv.computermagazine.service;

import java.util.List;

public interface GoodsService <T> {

    T create(T goods);

    T edit(Long id, T goods);

    T findById(Long id);

    List<T> findAll();
}
