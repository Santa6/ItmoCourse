package org.example;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Window;
import org.example.backend.Excursion;
import org.vaadin.viritin.fields.MCheckBox;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.layouts.MVerticalLayout;

public class ExcursionForm extends AbstractForm<Excursion> {

    private MTextField name = new MTextField("Name");
    private MTextField description = new MTextField("Description");
    private Image photo = new Image();
    private MCheckBox active = new MCheckBox("Active");

    @Override
    protected Component createContent() {
        return new MVerticalLayout(
                new MVerticalLayout(getToolbar()).add(new Header("Excursion editor").setHeaderLevel(3),
                        Alignment.MIDDLE_RIGHT)
                        .withFullWidth(),
                new MVerticalLayout(
                        photo,
                        name,
                        description,
                        active
                )
        );
    }

    @Override
    public Window openInModalPopup() {
        final Window p = super.openInModalPopup();
        p.setWidth("80%");
        p.setHeight("95%");
        return p;
    }
}
