package org.example;

import com.vaadin.cdi.ViewScoped;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.example.backend.Contact;
import org.example.backend.exampleservice.ContactFacade;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.LazyComboBox;
import org.vaadin.viritin.layouts.MHorizontalLayout;

/**
 * An entity selector component that allows to dynamically add entities.
 *
 * @author Matti Tahvonen
 */
@ViewScoped
public class ContactSelector extends LazyComboBox<Contact> implements
        AbstractSelect.NewItemHandler {
    protected static final int PAGE_SIZE = 15;

    @Inject
    private ContactFacade contactFacade;

    @Inject
    InvoicerSelect invoicerSelect;

    ContactForm form = new ContactForm();

    MButton edit = new MButton(FontAwesome.EDIT, e -> {
        editSelected();
    });

    @PostConstruct
    void init() {
        initList(Contact.class,
                (int firstRow, String filter) -> contactFacade.findPaged(
                        invoicerSelect.getValue(), 
                        filter,
                        firstRow, 
                        PAGE_SIZE),
                (String filter) -> contactFacade.countContacts(
                        invoicerSelect.getValue(), 
                        filter),
                PAGE_SIZE);
        updatelist();
        edit.setEnabled(false);
        getSelect().addValueChangeListener(e -> edit.setEnabled(
                getValue() != null));

        invoicerSelect.addMValueChangeListener(e -> updatelist());

        setCaption("Customer");
        getSelect().setNewItemHandler(this);
        getSelect().setNewItemsAllowed(true);
        setWidth("300px");
        ((ComboBox) getSelect()).setInputPrompt("Type new or choose existing");

    }

    void updatelist() {
        refresh();
    }

    @Override
    public void addNewItem(String newItemCaption) {
        // make contact with detail
        Contact contact = new Contact();
        contact.setName(newItemCaption);
        contact.setInvoicer(invoicerSelect.getValue());
        form.setEntity(contact);
        form.setSavedHandler(entity -> {
            contactFacade.save(entity);
            form.getPopup().close();
            updatelist();
            setValue(entity);
        });
        form.setResetHandler(e -> {
            form.getPopup().close();
        });
        form.openInModalPopup().setCaption("Add new customer");
        form.getSaveButton().setEnabled(true); // new item
    }

    private void editSelected() {
        form.setEntity(contactFacade.refresh(getValue()));
        form.setSavedHandler(entity -> {
            contactFacade.save(entity);
            form.getPopup().close();
            updatelist();
            setValue(entity);
        });
        form.setResetHandler(e -> {
            form.getPopup().close();
        });
        form.openInModalPopup().setCaption("Edit customer");

    }

    @Override
    protected Component initContent() {
        final Component compositionRoot = super.initContent();
        return new MHorizontalLayout(compositionRoot, edit);
    }
    
}
