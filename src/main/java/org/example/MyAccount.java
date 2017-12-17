package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.example.backend.Invoicer;
import org.example.backend.UserSession;
import org.example.backend.exampleservice.InvoicerFacade;
import org.vaadin.cdiviewmenu.ViewMenuItem;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView
@ViewMenuItem(icon = FontAwesome.LIFE_BOUY, order = ViewMenuItem.END)
public class MyAccount extends MVerticalLayout implements View {

    @Inject
    InvoicerFacade cf;

    @Inject
    UserSession session;

    @Inject
    InvoicerForm form;

    MTable<Invoicer> table = new MTable<>(Invoicer.class)
            .withProperties("id", "name", "email");

    @PostConstruct
    void init() {

        add(new RichText().withMarkDown("# Your account: " + session.getUser().
                getEmail()));
        
        form.setResetHandler(this::reset);
        form.setSavedHandler(this::save);

        table.addMValueChangeListener(e -> editEntity(e.getValue()));

        Button addButton = new Button("Add");
        addButton.addClickListener(e -> {
            Invoicer invoicer = new Invoicer();
            invoicer.getAdministrators().add(session.getUser());
            editEntity(invoicer);
        });

        add(
                new Header("Invoicers you administrate").setHeaderLevel(3),
                addButton
        ).expand(table);
        listEntities();
    }

    private void listEntities() {
        table.setBeans(session.getUser().getAdministrates());
    }

    private void editEntity(Invoicer invoicer) {
        if (invoicer != null) {
            if (invoicer.getId() != null) {
                // ensure a fresh entity
                invoicer = cf.findJoined(invoicer.getId().longValue());
            }
            form.setEntity(invoicer);
            form.openInModalPopup();
        }
    }

    public void save(Invoicer entity) {
        try {
            if (entity.getId() == null) {
                cf.save(entity);
                session.getUser().getAdministrates().add(entity);
            } else {
                cf.save(entity);
            }
            Notification.show("Saved!");
        } catch (Exception e) {
            Notification.show("Saving failed!",
                    "Most probably concurrently edited",
                    Notification.Type.WARNING_MESSAGE);
        }
        listEntities();
        form.getPopup().close();
    }

    public void reset(Invoicer entity) {
        // just hide the form
        form.getPopup().close();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
