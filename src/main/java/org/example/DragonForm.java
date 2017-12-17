package org.example;

import com.vaadin.cdi.ViewScoped;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Window;
import org.example.backend.Dragon;
import org.vaadin.viritin.fields.MTextArea;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.layouts.MVerticalLayout;

@ViewScoped
public class DragonForm extends AbstractForm<Dragon>{

    MTextField name = new MTextField("Name");

    MTextArea description = new MTextArea("Description");

    Image photo = new Image();


    @Override
    protected Component createContent() {
        return new MVerticalLayout(
                new MVerticalLayout(getToolbar()).add(new Header("Dragon editor").setHeaderLevel(3),
                        Alignment.MIDDLE_RIGHT)
                        .withFullWidth(),
                new MVerticalLayout(
                        photo,
                        name,
                        description
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
