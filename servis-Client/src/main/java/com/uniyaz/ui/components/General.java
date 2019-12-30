package com.uniyaz.ui.components;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class General extends VerticalLayout {
    public General() {
        Header header = new Header();
        addComponent(header);

        Container container = new Container();
        addComponent(container);
    }

    public void setGeneralContent(Component component){
        removeAllComponents();
        addComponent(component);
    }
}
