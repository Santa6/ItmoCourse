package com.backend.service;

import com.ExcursionRepository;
import com.backend.data.entity.ExcursionEntity;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class ExcursionService{

    @Inject
    private ExcursionRepository excursionRepository;

    public ExcursionService(){

    }

    public void save(ExcursionEntity entry){
        excursionRepository.save(entry);
    }

    public List<ExcursionEntity> findByName(String filter){
        return excursionRepository.findByNameLikeIgnoreCase(filter);
    }

//    @Override
//    public void delete(Integer excursionId){
//        super.delete(excursionId);
//    }
//
//    @Override
//    protected EntityRepository<ExcursionEntity, Integer> getRepository() {
//        return null;
//    }
//
//    @Override
//    public long countAnyMatching(Optional<String> filter) {
//        return 0;
//    }
//
//    @Override
//    public Stream<ExcursionEntity> findAnyMatching(Optional<String> filter, int offset, int limit, List<QuerySortOrder> sortOrders) {
//        return null;
//    }

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
