package com.app.security;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.access.AccessControl;
import com.vaadin.navigator.View;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import java.io.Serializable;

@SessionScoped
public class ViewAccessControl implements Serializable{
    @Inject
    private AccessControl accessControl;

    public ViewAccessControl() {
    }

    public boolean isAccessGranted(Class<? extends View> viewClass) {

        if (viewClass.isAnnotationPresent(CDIView.class)) {
            if (viewClass.isAnnotationPresent(DenyAll.class)) {
                // DenyAll defined, everyone is denied access
                return false;
            }

            if (!viewClass.isAnnotationPresent(RolesAllowed.class)) {
                // No roles defined, everyone is allowed
                return true;
            } else {
                RolesAllowed rolesAnnotation = viewClass.getAnnotation(RolesAllowed.class);
                return accessControl.isUserInSomeRole(rolesAnnotation.value());
            }
        }

        // No annotation (or PermitAll) defined, everyone is allowed
        return true;
    }
}
}