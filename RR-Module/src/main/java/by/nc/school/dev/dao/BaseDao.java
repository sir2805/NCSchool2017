package by.nc.school.dev.dao;

import by.nc.school.dev.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

abstract class BaseDao<T extends BaseEntity> implements IDao<T> {

    protected List<T> entities;

    public BaseDao() {
        entities = new ArrayList<>();
    }

    @Override
    public T get(int id) {
        for (T entity : entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }
}