package com;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.cdi.CDIUI;
import com.vaadin.ui.UI;
import com.app.HasLogger;


@CDIUI("")
@Title("Dragon Park")
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
public class AppUI extends UI implements HasLogger{

}
