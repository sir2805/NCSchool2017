package by.nc.school.dev.dao;

import by.nc.school.dev.enitities.BaseEntity;

interface IDao<T extends BaseEntity> {

    T get(int id);
    T create(T entity);
    void update(T entity);
    void delete(T entity);
}
