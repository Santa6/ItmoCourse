package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.ValoTheme;
import org.example.backend.Dragon;
import org.example.backend.UserSession;
import org.example.backend.service.DragonFacade;
import org.vaadin.cdiviewmenu.ViewMenuItem;
import org.vaadin.cdiviewmenu.ViewMenuUI;
import org.vaadin.viritin.button.ConfirmButton;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@CDIView("dragons")
@ViewMenuItem(icon = FontAwesome.ARCHIVE)
public class DragonsView extends MVerticalLayout implements View{

    @Inject
    private DragonFacade facade;

    @Inject
    private DragonForm form;

    @Inject
    private UserSession session;


    private MTable<Dragon> table = new MTable<>(Dragon.class)
            .withFullWidth()
            .withProperties("name", "description")
            .withColumnHeaders("Name", "Description")
            .withGeneratedColumn("Actions", this::getDragonActions);

    @PostConstruct
    public void initComponent() {
        table.setColumnCollapsingAllowed(true);
//        table.setColumnWidth("Description", 100);
        if (!session.isLoggedIn()) {
            Notification.show("Login first!");
            ViewMenuUI.getMenu().navigateTo(AboutView.class);
            return;
        }
//        sender.addMValueChangeListener(e -> listEntities());

        form.setResetHandler(this::reset);
        form.setSavedHandler(this::save);

        table.addMValueChangeListener(e -> {
            if (e.getValue() != null) {
                form.setEntity(e.getValue());
                form.openInModalPopup();
            }
        });

        listEntities();

        Button addButton = new Button("Add", e -> {
            form.setEntity(new Dragon());
            form.openInModalPopup();
        });

        add(
                new MHorizontalLayout(addButton).alignAll(Alignment.MIDDLE_LEFT)
        );
        expand(table);
    }

    private MHorizontalLayout getDragonActions(Dragon dragon){
        final MHorizontalLayout actions = new MHorizontalLayout();
        final MButton deleteButton = new ConfirmButton(
                FontAwesome.TRASH_O,
                "Are you sure you want to delete this dragon?",
                e -> {
                    facade.remove(dragon);
                    listEntities();
                }
        ).withStyleName(ValoTheme.BUTTON_ICON_ONLY);
        actions.add(deleteButton);
        return actions;
    }

    private void listEntities() {
        table.setBeans(facade.findAll());
    }

    private void save(Dragon entity) {
        facade.save(entity);
        Notification.show("Saved!");
        form.getPopup().close();
        listEntities();
    }

    private void reset(Dragon entity){
        //just hide he form
        form.getPopup().close();
        listEntities();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
    }
}
