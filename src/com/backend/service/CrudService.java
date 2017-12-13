package com.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.deltaspike.data.api.EntityRepository;

import com.vaadin.data.provider.QuerySortOrder;
import com.backend.data.entity.AbstractEntity;

public abstract class CrudService<T extends AbstractEntity> {

    protected abstract EntityRepository<T, Integer> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void delete(Integer id) {
        getRepository().remove(load(id));
    }

    public T load(Integer id) {
        return getRepository().findBy(id);
    }

    public abstract long countAnyMatching(Optional<String> filter);

    public abstract Stream<T> findAnyMatching(Optional<String> filter, int offset, int limit,
                                              List<QuerySortOrder> sortOrders);

}
