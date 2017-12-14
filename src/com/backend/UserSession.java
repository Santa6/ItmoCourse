package com.backend;

import com.backend.data.entity.EmployeeEntity;
import com.backend.service.UserFacade;
import org.apache.commons.lang3.StringUtils;
import org.apache.deltaspike.core.api.config.ConfigResolver;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Objects;

@SessionScoped
public class UserSession implements Serializable{
    @Inject
    private
    UserFacade userFacade;

    private EmployeeEntity user;


    @PostConstruct
    public void init(){
        guestLogin();
    }

    private void guestLogin() {
        user = null;
    }

    public EmployeeEntity getUser() {
        return user;
    }

    public void setUser(EmployeeEntity user) {
        this.user = user;
    }

    public boolean isLogged(){
        return user != null;
    }

    public boolean login(Integer id, Integer passwordHash) {
        user = userFacade.findById(id);
        return Objects.equals(user.getPasswordHash(), passwordHash);
    }
}
