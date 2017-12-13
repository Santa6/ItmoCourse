package com.ui;

import com.ui.navigation.NavigationManager;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.app.HasLogger;


@CDIUI("")
@Title("Dragon Park")
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
public class AppUI extends UI implements HasLogger{
    private final CDIViewProvider viewProvider;
    private final NavigationManager navigationManager;
    private final MainView mainView;

    public AppUI(CDIViewProvider viewProvider, NavigationManager navigationManager, MainView mainView){
        this.viewProvider = viewProvider;
        this.navigationManager = navigationManager;
        this.mainView = mainView;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigationManager.init(this, mainView, viewProvider);

        setErrorHandler(event -> {
            Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
            getLogger().error("Error during request", t);
        });

        setContent(mainView);

        navigationManager.navigateToDefaultView();
    }
}
