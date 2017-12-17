package org.example.backend.service;

import org.example.backend.Excursion;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class ExcursionFacade{

    @Inject
    private ExcursionRepository repository;

    public void save(Excursion entry){
        repository.save(entry);
    }

    public List<Excursion> findByName(String filter){
        return repository.findByNameLikeIgnoreCase(filter);
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
//        return repository;
//    }
}
