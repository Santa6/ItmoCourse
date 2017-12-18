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
import java.util.List;

public class EnrollmentWindow extends Window{

    @Inject
    EntryFacade entryFacade;

    @Inject
    ScheduleFacade facade;

    @Inject
    PaymentWindow window;

    private Excursion entity;

    MTable<Schedule> table= new MTable<>(Schedule.class)
            .withFullWidth()
            .withHeight("20%")
            .withProperties("beginning", "ending")
            .withColumnHeaders("Beginning", "Ending")
            .withCaption("What time would you like to sign up to?");

    @PostConstruct
    public void init(){
        setModal(true);
        setResponsive(true);
        setResizable(true);
        center();
        setHeight("60%");
    }

    void setExcursion(Excursion entity){
        this.entity = entity;
        setContent(new MVerticalLayout(new Header(entity.getName()), new MLabel(entity.getDescription()),table));

        table.addMValueChangeListener(e -> {
            if (e.getValue() != null){
                window.setCaption("Sign up for an excursion");
                UI.getCurrent().addWindow(window);
                window.setSchedule(e.getValue());
                this.close();
            }
        });

        listEntities();
    }

    private void listEntities(){
        List<Schedule> list = facade.findByExcursionId(entity.getId());
        for (Schedule schedule: list) {
            if (schedule.getMaxEntries() <= entryFacade.countBySchedule(schedule.getId())){
                list.remove(schedule);
            }
        }
        table.setBeans(list);
    }
}
