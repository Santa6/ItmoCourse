package org.example.backend;

import org.example.backend.service.EmployeeFacade;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Matti Tahvonen
 */
@SessionScoped
public class UserSession implements Serializable {
    @Inject
    EmployeeFacade facade;

    private Employee user;

    @PostConstruct
    public void init() {
//        final String propertyValue = ConfigResolver.getPropertyValue(
//                "jpa-invoicer.gpluskey");
//        // If no Google OAuth API key available, use fake login
//        if (StringUtils.isEmpty(propertyValue)) {
//            demoLogin();
//        }
    }

//    protected void demoLogin() {
//        final String email = "matti.meikalainen@gmail.com";
//        user = new Employee();
//        this.user = userFacade.findByEmail(email);
//        if (user == null) {
//            this.user = userFacade.save(new User(email));
//
//            Invoicer invoicer = new Invoicer();
//            invoicer.setName("Matin pummpu ja imu");
//            invoicer.setAddress("Ruukinkatu 4, 20100 Turku");
//            invoicer.setBankAccount("FI1234567890");
//            invoicer.setEmail("matti@pumppu.fi");
//            invoicer.setPhone("+34567890");
//            invoicer.getAdministrators().add(this.user);
//            this.user.getAdministrates().add(invoicer);
//            invoicer = invoicerFacade.save(invoicer);
//            Product product = new Product();
//            product.setName("Pumppu");
//            product.setPrice(30.0);
//            product.setInvoicer(invoicer);
//            productFacade.save(product);
//            product = new Product();
//            product.setName("Imuri");
//            product.setPrice(60.0);
//            product.setInvoicer(invoicer);
//            productFacade.save(product);
//
//        }
//    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        setUser(null);
    }

    public boolean login(Long id, Integer passwordHash){
        try{
            user = facade.findById(id);
            if (!Objects.equals(user.getPasswordHash(), passwordHash)){
                user = null;
            }
            return isLoggedIn();
        } catch (Exception e){
            return false;
        }
    }

//    public void login(String email, String displayName) {
//        try {
//            user = userFacade.findByEmail(email);
//        } catch (Exception e) {
//        }
//        if (user == null) {
//            userFacade.save(new User(email));
//            user = userFacade.findByEmail(email);
//        }
//    }

}
