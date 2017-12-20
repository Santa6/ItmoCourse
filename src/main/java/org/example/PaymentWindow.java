package org.example;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;
import org.example.backend.Entries;
import org.example.backend.Mail;
import org.example.backend.Schedule;
import org.example.backend.service.EntryFacade;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.label.Header;
import org.vaadin.viritin.label.MLabel;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.concurrent.ThreadLocalRandom;

public class PaymentWindow extends Window{
    private Schedule entity;

    @Inject
    private
    EntryFacade facade;

    private Long counter = 1L;

    private Long generatedId;

    private MTextField email = new MTextField("e-mail");
    private MLabel counterLabel = new MLabel(counter.toString());
    private MButton minus = new MButton();
    private MButton plus = new MButton();

    private Label label = new Label("How many tickets?");

    private MButton buyButton = new MButton();

    private MHorizontalLayout buyLayout = new MHorizontalLayout();

    @PostConstruct
    public void init(){
        email.setRequired(true);
        minus.setIcon(FontAwesome.MINUS);
        plus.setIcon(FontAwesome.PLUS);
        plus.addClickListener(e -> changeCounter(1));
        minus.addClickListener(e -> changeCounter(-1));
        buyButton.setIcon(FontAwesome.MONEY);
        buyButton.addClickListener(e -> {
            buy();
            Mail myMail = new Mail(email.getValue(), generatedId);
            Thread mailThread = new Thread(myMail);
            mailThread.start();
            close();
        });
        setModal(true);
        setResponsive(true);
        setResizable(true);
        center();
    }

    private void buy() {
        Entries order = new Entries();
        order.seteMail(email.getValue());
        order.setGenerated(generatedId);
        order.setCount(counter);
        order.setSchedule(entity.getId());
        facade.save(order);
    }

    private void changeCounter(int i) {
        if (i == 1) {
            Long count = facade.countBySchedule(entity.getId());
            if (counter < (entity.getMaxEntries() - (count == null? 0: count))){
                counter += 1;
            }
            else Notification.show("No more places available!");
        }
        if (i == -1){
            if (counter > 1){
                counter -= 1;
            }
        }
        updateCounterLabel();
    }

    private void updateCounterLabel() {
        counterLabel.setValue(counter.toString());
    }

    void setSchedule(Schedule entity) {
        this.entity = entity;
        generatedId = Math.abs(ThreadLocalRandom.current().nextLong(10000));

        MVerticalLayout layout = new MVerticalLayout();
        setContent(layout);

        buyLayout.add(
                label,
                minus,
                counterLabel,
                plus
        );
        layout.add(new Header("Sign up for excursion at: " + entity.getBeginning()),
                email,
                buyLayout,
                buyButton
        );
    }
}
