
package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import org.example.backend.Excursion;
import org.example.backend.service.ExcursionFacade;
import org.vaadin.cdiviewmenu.ViewMenuItem;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MCssLayout;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView("")
@ViewMenuItem(icon = FontAwesome.HOME, order = ViewMenuItem.BEGINNING)
public class AboutView extends MVerticalLayout implements View {

    @Inject
    private ExcursionFacade excursionFacade;

    @Inject
    private EnrollmentWindow window;

    private RichText aboutInfo = new RichText().withMarkDownResource("/about.md");

    private MTable<Excursion> table = new MTable<>(Excursion.class)
            .withFullHeight()
            .withFullWidth()
            .withProperties("name")
            .withColumnHeaders("")
            .withCaption("Our excursions");

    private MVerticalLayout tableLayout = new MVerticalLayout(table).withMargin(false);

    @PostConstruct
    void init() {
        MCssLayout layout = new MCssLayout(tableLayout, aboutInfo);
        aboutInfo.setWidth("300px");
        tableLayout.setWidth(15, Unit.EM);
        tableLayout.setHeight(40, Unit.EM);
        add(
                layout
        );

        table.addMValueChangeListener(e -> {
            if (e.getValue() != null) {
                UI.getCurrent().addWindow(window);
                window.setExcursion(e.getValue());
            }
        });

        listEntities();
    }

    private void listEntities() {
        table.setBeans(excursionFacade.findAll());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
