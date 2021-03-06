package org.example;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import org.example.backend.Excursion;
import org.example.backend.Schedule;
import org.example.backend.service.EntryFacade;
import org.example.backend.service.ScheduleFacade;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.label.MLabel;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

public class EnrollmentWindow extends Window{

    @Inject
    private EntryFacade entryFacade;

    @Inject
    private ScheduleFacade facade;

    @Inject
    private PaymentWindow window;

    private Excursion entity;

    private MTable<Schedule> table = new MTable<>(Schedule.class)
            .withFullWidth()
            .withHeight("20%")
            .withProperties("beginning", "ending")
            .withColumnHeaders("Beginning", "Ending")
            .withCaption("What time would you like to sign up to?");

    @PostConstruct
    public void init(){
        setModal(true);
        setResponsive(true);
        setResizable(false);
        center();
        setHeight("60%");
    }

    void setExcursion(Excursion entity){
        this.entity = entity;
        setContent(new MVerticalLayout(new Header(entity.getName()), new MLabel(entity.getDescription()),table));

        table.addMValueChangeListener(e -> {
            if (e.getValue() != null){
                window.setCaption("Sign up for an excursion");
                window.close();
                UI.getCurrent().addWindow(window);
                window.setSchedule(e.getValue());
                this.close();
            }
        });

        listEntities();
    }

    private void listEntities(){
        List<Schedule> list = facade.findByExcursionId(entity.getId());
        list.removeIf(schedulePredicate -> {
            Long count = entryFacade.countBySchedule(schedulePredicate.getId());
            return schedulePredicate.getMaxEntries() <= (count == null? 0: count);
        });
        table.setBeans(list);
    }
}
