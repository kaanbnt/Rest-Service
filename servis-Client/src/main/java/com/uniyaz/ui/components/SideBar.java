package com.uniyaz.ui.components;

import com.uniyaz.ui.view.ArizaKayitView;
import com.uniyaz.ui.view.ArizaListView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class SideBar extends VerticalLayout {

    private Content content;

    private MenuButton btnMenuButton;

    public SideBar(Content content) {
        this.content = content;

        setSpacing(true);//elementler arası boşuk
        setMargin(true);//her tarafında boşluk

        btnMenuButton = new MenuButton(FontAwesome.PLUS);
        btnMenuButton.setCaption("Kayıt olustur");
        btnMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ArizaKayitView arizaKayitView = new ArizaKayitView();
                content.setContent(arizaKayitView);
            }
        });
        addComponent(btnMenuButton);

        btnMenuButton = new MenuButton(FontAwesome.PENCIL_SQUARE);
        btnMenuButton.setCaption("Arıza Listele");
        btnMenuButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ArizaListView arizaListView=new ArizaListView();
                content.setContent(arizaListView);
            }
        });
        addComponent(btnMenuButton);

    }
}
