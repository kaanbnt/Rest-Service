package com.uniyaz.ui.view;

import com.uniyaz.service.dto.ArizaKayitDto;
import com.uniyaz.service.dto.EnumArizaDurum;
import com.uniyaz.service.service.RestClientArizaKayit;
import com.uniyaz.ui.components.MenuTextField;
import com.uniyaz.ui.components.SaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArizaKayitView extends VerticalLayout {

    @PropertyId("id")
    private MenuTextField idField;

    @PropertyId("ad")
    private TextField adField;

    @PropertyId("arizaTarih")
    private DateField tarihField;

    @PropertyId("ariza")
    private TextField arizaField;

    @PropertyId("arizaİcerik")
    private TextArea arizaIcerikField;

    @PropertyId("enumArizaDurum")
    private ComboBox enumAriza;

    private FormLayout mainLayout;

    private BeanItem<ArizaKayitDto> item;
    private FieldGroup binder;

    public ArizaKayitView() {
        buildMainLayout();
        fillViewByArizaKayit(new ArizaKayitDto());
    }

    public void fillViewByArizaKayit(ArizaKayitDto arizaKayitDto) {
        item = new BeanItem<ArizaKayitDto>(arizaKayitDto);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        idField = new MenuTextField("Id");
        idField.setEnabled(false);
        mainLayout.addComponent(idField);

        adField = new TextField("Ad");
        mainLayout.addComponent(adField);

        arizaField = new TextField("Arıza");
        mainLayout.addComponent(arizaField);

        arizaIcerikField = new TextArea("Arıza İçerik");
        mainLayout.addComponent(arizaIcerikField);

        EnumArizaDurum[] values = EnumArizaDurum.values();
        enumAriza = new ComboBox("Arıza Durumu", Arrays.asList(values));
        mainLayout.addComponent(enumAriza);

        tarihField = new DateField("Tarih");
        mainLayout.addComponent(tarihField);

        SaveButton saveButton = new SaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();
                    ArizaKayitDto arizaKayitDto = item.getBean();
                    idField.setValue(arizaKayitDto.getId().toString());
                    RestClientArizaKayit restClientArizaKayit = new RestClientArizaKayit();
                    ArizaKayitDto arizaKayit = restClientArizaKayit.arizaKayitSave(Long.parseLong(idField.getValue()), adField.getValue(), arizaField.getValue(), arizaIcerikField.getValue(), (EnumArizaDurum) enumAriza.getValue(), tarihField.getValue());
                    if (arizaKayit != null) {
                        Notification.show("Kayıt Başarılı");
                    } else {
                        Notification.show("Hata");
                    }
                } catch (FieldGroup.CommitException e) {
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    String sayi="1";
                    idField.setValue(sayi);
                    RestClientArizaKayit restClientArizaKayit = new RestClientArizaKayit();
                    ArizaKayitDto arizaKayit = restClientArizaKayit.arizaKayitSave(Long.parseLong(idField.getValue()), adField.getValue(), arizaField.getValue(), arizaIcerikField.getValue(), (EnumArizaDurum) enumAriza.getValue(), tarihField.getValue());
                    if (arizaKayit != null) {
                        Notification.show("Kayıt Başarılı");
                    } else {
                        Notification.show("Hata");
                    }
                }
            }
        });
        mainLayout.addComponent(saveButton);
    }
}
