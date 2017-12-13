package com.backend.service;

import com.ExcursionRepository;
import com.backend.data.entity.ExcursionEntity;
import com.vaadin.data.provider.QuerySortOrder;
import org.apache.deltaspike.data.api.EntityRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Stateless
public class ExcursionService extends CrudService<ExcursionEntity>{
    private final ExcursionRepository excursionRepository;

    public ExcursionService(){
        excursionRepository= null;
    }

    @Inject
    public ExcursionService(ExcursionRepository excursionRepository){
        this.excursionRepository = excursionRepository;
    }

    @Override
    public void delete(Integer excursionId){
        super.delete(excursionId);
    }

    @Override
    protected EntityRepository<ExcursionEntity, Integer> getRepository() {
        return null;
    }

    @Override
    public long countAnyMatching(Optional<String> filter) {
        return 0;
    }

    @Override
    public Stream<ExcursionEntity> findAnyMatching(Optional<String> filter, int offset, int limit, List<QuerySortOrder> sortOrders) {
        return null;
    }

//    private void throwIfExcursionLocked(Integer excursionId){
//        if (excursionId == null){
//            return;
//        }
//        ExcursionEntity excursion = getRepository().findBy(excursionId);
//        if (excursion.isLocked(){
//            throw new UserFriendlDataException(MODIFY_LOCKED_EXCURSION_NO_PERMITTED);
//        }
//    }
//
//
//    @Override
//    protected ExcursionRepository getRepository(){
//        return excursionRepository;
//    }
}
