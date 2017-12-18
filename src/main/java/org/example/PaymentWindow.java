package org.example;

import com.vaadin.ui.Window;
import org.example.backend.Schedule;
import org.example.backend.service.EntryFacade;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class PaymentWindow extends Window{
    private Schedule entity;

    @Inject
    EntryFacade facade;

    @PostConstruct
    public void init(){
        setModal(true);
        setResponsive(true);
        setResizable(true);
        center();
    }

    void setSchedule(Schedule entity) {
        this.entity = entity;
        MVerticalLayout layout = new MVerticalLayout();
        setContent(layout);
        layout.add(new Header("Sign up for excursion at: " + entity.getBeginning()));
        Long left_counter = entity.getMaxEntries() - facade.countBySchedule(entity.getId());
    }
}
