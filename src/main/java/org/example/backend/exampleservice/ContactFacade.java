package org.example.backend.exampleservice;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.example.backend.Contact;
import org.example.backend.Invoicer;

/**
 *
 * @author Matti Tahvonen
 */
@Stateless
public class ContactFacade {

    @Inject
    ContactRepository repo;

    public List<Contact> findAll(Invoicer invoicer) {
        return repo.findByInvoicer(invoicer);
    }

    public List<Contact> findPaged(Invoicer invoicer, String filter,
            int firstResult,
            int maxResults) {
        return repo.findByInvoicerAndNameLikeIgnoreCase(invoicer, filter + "%").
                firstResult(firstResult).maxResults(maxResults).getResultList();
    }

    public Integer countContacts(Invoicer invoicer, String filter) {
        return (int) repo.findByInvoicerAndNameLikeIgnoreCase(invoicer, filter + "%").
                count();
    }

    public Contact save(Contact entity) {
        return repo.save(entity);
    }
    
    public Contact refresh(Contact entity) {
        return repo.findBy(entity.getId());
    }
    
}
