package com;

import com.beans.DBInterface;
import com.entity.ExcursionEntity;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

import javax.ejb.EJB;


public class DragonPark extends UI{

    private Grid<ExcursionEntity> excursionGrid = new Grid<>(ExcursionEntity.class);


    @EJB//(lookup = "java:global/course_war/DBInterfaceBean!com.beans.DBInterface")
    private static DBInterface dbInterface;

    @Override
    public void init(VaadinRequest request) {
        getPage().setTitle("Dragon Park");
        setContent(new Button("Hey!", event -> Call()));
    }

    private void Call(){
        dbInterface.getAllExcursions();
    }


}
