package com.ui;

import com.backend.UserSession;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import org.vaadin.cdiviewmenu.ViewMenuUI;

import javax.inject.Inject;


@CDIUI("")
@Title("Dragon Park")
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
public class AppUI extends ViewMenuUI{

    @Inject
    UserSession userSession;

    @Override
    protected void init(VaadinRequest request) {
        super.init(request);

    }
}
