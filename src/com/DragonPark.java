package com;

import com.beans.DBInterface;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;


public class DragonPark extends UI {
    @Override
    public void init(VaadinRequest request) {
        HorizontalSplitPanel panel = new HorizontalSplitPanel(null, new Label("Hello, world!"));
        setContent(panel);

    }

    @WebServlet(value = "/test")
    @VaadinServletConfiguration(productionMode = false, ui = DragonPark.class)
    public static class MainPageServlet extends VaadinServlet{
        @EJB
        private DBInterface DBInterface;

        public com.beans.DBInterface getDBInterface() {
            return DBInterface;
        }
    }
}
