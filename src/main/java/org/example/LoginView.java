package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Notification;
import org.example.backend.UserSession;
import org.example.backend.service.EmployeeRepository;
import org.vaadin.cdiviewmenu.ViewMenuItem;
import org.vaadin.cdiviewmenu.ViewMenuUI;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MPasswordField;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@CDIView("Login")
@ViewMenuItem(icon = FontAwesome.KEY)
public class LoginView extends MVerticalLayout implements View {
    @Inject
    UserSession session;

    @Inject
    EmployeeRepository repository;

    private MTextField id = new MTextField("id").withRequired(true);
    private MPasswordField password = new MPasswordField("password").withRequired(true);
    private MButton loginButton = new MButton("Login");
    private MButton logoutButton = new MButton("Logout");

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @PostConstruct
    void initComponent(){
        if (session.isLoggedIn()){
            add(logoutButton);
            logoutButton.addClickListener(e -> {
                session.logout();
                ViewMenuUI.getMenu().navigateTo(AboutView.class);
            });
        }
        else{
            add(
                    id,
                    password,
                    loginButton
            );
            loginButton.addClickListener(e -> {
                Long longId;
                boolean logged;
                try{
                    longId = Long.parseLong(id.getValue());
                    logged = session.login(longId, password.getValue());
                }catch (NumberFormatException exc){
                    Notification.show("ID can only have digits!");
                    logged = false;
                }

                if (logged) {
                    ViewMenuUI.getMenu().navigateTo(DragonsView.class);
                }
                else {
                    Notification.show("Wrong ID or password!");
                }
            });
        }
    }
}
