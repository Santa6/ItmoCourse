package org.example.backend;

import org.example.backend.service.EmployeeFacade;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Matti Tahvonen
 */
@SessionScoped
public class UserSession implements Serializable {

    @Inject
    private EmployeeFacade facade;

    private Employee user;

    @PostConstruct
    public void init() {
    }


    public String getUserName() {
        return user.getName();
    }

    private void setUser(Employee user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        setUser(null);
    }

    public boolean login(Long id, String password){
        try{
            user = facade.findById(id);
            if (!Objects.equals(user.getPassword(), password)){
                user = null;
            }
            return isLoggedIn();
        } catch (Exception e){
            return false;
        }
    }


}
