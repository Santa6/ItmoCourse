package org.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Notification;
import org.example.backend.UserSession;
import org.vaadin.cdiviewmenu.ViewMenuItem;
import org.vaadin.cdiviewmenu.ViewMenuUI;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MPasswordField;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.label.MLabel;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@CDIView("Login")
@ViewMenuItem(icon = FontAwesome.KEY)
public class LoginView extends MVerticalLayout implements View {

    @Inject
    private UserSession session;

    private MTextField id = new MTextField("id").withRequired(true);
    private MPasswordField password = new MPasswordField("password").withRequired(true);
    private MButton loginButton = new MButton("Login");
    private MButton logoutButton = new MButton("Logout");
    private MLabel loggedInInfo = new MLabel();


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    @PostConstruct
    void initComponent(){
        if (session.isLoggedIn()){
            add(loggedInInfo, logoutButton);
            loggedInInfo.setValue(String.format("You are already logged in, %s. You can logout:", session.getUserName()));
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
                    Notification.show(String.format("Welcome, %s!", session.getUserName()));
                    ViewMenuUI.getMenu().navigateTo(DragonsView.class);
                }
                else {
                    Notification.show("Wrong ID or password!");
                }
            });
        }
    }
}
