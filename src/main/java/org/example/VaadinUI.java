package org.example;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.Extension;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import org.vaadin.cdiviewmenu.ViewMenuUI;

@CDIUI("")
@Theme("valo")
@Title("Dragon Park")
public class VaadinUI extends ViewMenuUI {

    @Override
    protected void init(VaadinRequest request) {
        super.init(request);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
//        workaroundForFirefoxIssue(initial);
        super.beforeClientResponse(initial);
    }

    private void workaroundForFirefoxIssue(boolean initial) {
        if (initial && Page.getCurrent().getWebBrowser().getBrowserApplication().
                contains("Firefox")) {
            // Responsive, FF, cross site is currently broken :-(
            Extension r = null;
            for (Extension ext : getExtensions()) {
                if (ext instanceof Responsive) {
                    r = ext;
                }
            }
            if (r != null) {
                removeExtension(r);
            }
        }
    }

}
