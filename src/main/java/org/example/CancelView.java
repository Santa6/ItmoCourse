package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Notification;
import org.example.backend.Entries;
import org.example.backend.service.EntryFacade;
import org.vaadin.cdiviewmenu.ViewMenuItem;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@CDIView
@ViewMenuItem(icon = FontAwesome.TRASH, order = ViewMenuItem.END)
public class CancelView extends MVerticalLayout implements View{

    @Inject
    private EntryFacade facade;

    private MTextField generatedField = new MTextField("Your secret key").withRequired(true);
    private MButton button = new MButton()
            .withIcon(FontAwesome.TRASH)
            .withListener(e -> cancelEntry());

    private void cancelEntry() {
        try {
            Long id = Long.valueOf(generatedField.getValue());
            List<Entries> myEntries = facade.findByGenerated(id);
            if (myEntries.size() > 0){
                facade.removeByGenerated(id);
                Notification.show("Successfully canceled!");
            }
            else {
                Notification.show("No entries found for this id!");
            }
        }catch (NumberFormatException e){
            Notification.show("The key can only have numbers!");
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @PostConstruct
    public void initComponent(){
        add(generatedField, button);

    }
}
