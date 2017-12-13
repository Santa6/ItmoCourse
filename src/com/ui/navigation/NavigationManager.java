package com.ui.navigation;

import javax.inject.Inject;

import com.backend.data.Role;
import com.ui.view.DragonView;
import com.ui.view.InformationView;
import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.UIScoped;
import com.vaadin.cdi.access.AccessControl;
import com.vaadin.cdi.internal.Conventions;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.ui.UI;

/**
 * Governs view navigation of the app.
 */
@UIScoped
public class NavigationManager extends Navigator {

    private final AccessControl accessControl;

    @Inject
    public NavigationManager(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public void init(UI ui, ViewDisplay display, ViewProvider viewProvider) {
        init(ui, new UriFragmentManager(ui.getPage()), display);
        addProvider(viewProvider);
    }

    /**
     * Find the view id (URI fragment) used for a given view class.
     *
     * @param viewClass
     *            the view class to find the id for
     * @return the URI fragment for the view
     */
    public String getViewId(Class<? extends View> viewClass) {
        return Conventions.deriveMappingForView(viewClass);
    }

    /**
     * Navigate to the given view class.
     *
     * @param targetView
     *            the class of the target view, must be annotated using
     *            {@link CDIView @CDIView}
     */
    public void navigateTo(Class<? extends View> targetView) {
        String viewId = getViewId(targetView);
        navigateTo(viewId);
    }

    public void navigateTo(Class<? extends View> targetView, Object parameter) {
        String viewId = getViewId(targetView);
        navigateTo(viewId + "/" + parameter.toString());
    }

    public void navigateToDefaultView() {
        // If the user wants a specific view, it's in the URL.
        // Otherwise admin goes to DashboardView and everybody else to
        // OrderListView
        if (!getState().isEmpty()) {
            return;
        }

        navigateTo(accessControl.isUserInRole(Role.ADMIN) ? DragonView.class : InformationView.class);
    }

    /**
     * Update the parameter of the the current view without firing any
     * navigation events.
     *
     * @param parameter
     *            the new parameter to set, never <code>null</code>,
     *            <code>""</code> to not use any parameter
     */
    public void updateViewParameter(String parameter) {
        String viewName = getViewId(getCurrentView().getClass());
        String parameters;
        if (parameter == null) {
            parameters = "";
        } else {
            parameters = parameter;
        }

        updateNavigationState(new ViewChangeEvent(this, getCurrentView(), getCurrentView(), viewName, parameters));
    }

}
