package com.backend;

import com.backend.data.entity.ExcursionEntity;
import com.vaadin.ui.*;
import org.vaadin.viritin.fields.MCheckBox;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MVerticalLayout;

public class ExcursionForm extends AbstractForm<ExcursionEntity> {
//    TextField id = new MTextField("id");
    TextField name = new MTextField("name");
    TextField description = new MTextField("description");
//    TextField photo = new MTextField("photo");
    CheckBox isactive = new MCheckBox("Active excursion");

    public ExcursionForm(Class<ExcursionEntity> entityType) { //???
        super(entityType);
    }

    @Override
    protected Component createContent() {

        return new MVerticalLayout(
                getToolbar(),
                new FormLayout(
                        name,
                        description,
                        isactive
                )
        );
    }

    @Override
    public Window openInModalPopup() {
        final Window window = super.openInModalPopup();
        window.setHeight("80%");
        window.setWidth("50%");
        return window;
    }
}
