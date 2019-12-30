package com.uniyaz.ui.view;

import com.uniyaz.service.dto.KullaniciDto;
import com.uniyaz.service.service.RestClientKullanici;
import com.uniyaz.ui.components.General;
import com.vaadin.ui.*;

public class LoginView extends VerticalLayout {
    private TextField idTextField;
    private Button girisYapButon;
    private TextField passwordField;
    private FormLayout formLayout;

    public LoginView() {
        formLayout = new FormLayout();
        addComponent(formLayout);

        idTextField = new TextField();
        idTextField.setCaption("ID");
        formLayout.addComponents(idTextField);

        passwordField = new TextField();
        passwordField.setCaption("Sifre");
        formLayout.addComponents(passwordField);

        girisYapButon = new Button();
        girisYapButon.setCaption("Giris Yap");
        girisYapButon.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                RestClientKullanici clientKullanici = new RestClientKullanici();

                KullaniciDto gelenKullanici = clientKullanici.kullaniciGetir(Long.parseLong(idTextField.getValue().toString()), passwordField.getValue());

                if (gelenKullanici != null) {
                    Notification.show("Giriş Yapıldı");
                    removeAllComponents();
                    General general = new General();
                    addComponent(general);
                } else {
                    Notification.show("Kullanıcı adı veya şifre hatalı.");
                }
            }
        });
        formLayout.addComponents(girisYapButon);

    }
}
