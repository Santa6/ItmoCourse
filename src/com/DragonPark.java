package com;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;


public class DragonPark extends UI {
    @Override
    public void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.addComponent(new Label("Hello, world!"));
    }

    @WebServlet(value = "/")
    @VaadinServletConfiguration(productionMode = false, ui = DragonPark.class)
    public static class Servlet extends VaadinServlet{

    }
}
