package org.example.backend.exampleservice;


import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.example.backend.User;

@Repository(forEntity = User.class)
public interface UserRepository extends EntityRepository<User, Long> {

    public User findByEmail(String email);
   
}