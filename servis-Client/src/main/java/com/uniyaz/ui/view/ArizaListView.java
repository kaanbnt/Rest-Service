package com.uniyaz.ui.view;

import com.uniyaz.service.dto.ArizaKayitDto;
import com.uniyaz.service.dto.EnumArizaDurum;
import com.uniyaz.service.service.RestClientArizaKayit;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ArizaListView extends HorizontalLayout {

    TextField searchTextField;
    Button btnSearch;
    private Table table;
    private IndexedContainer indexedContainer;
    ArizaKayitView arizaKayitView;
    ArizaKayitDto arizaKayitDto;
    FormLayout formLayout;

    public ArizaListView() {
        setSpacing(true);

        buildTableContainer();
        buildTable();
//        buidSearchComponents();
        addComponent(table);

        arizaKayitView = new ArizaKayitView();
        addComponent(arizaKayitView);

        fillTable();
    }

    private void buidSearchComponents() {
        formLayout = new FormLayout();
        searchTextField = new TextField("Id");

        btnSearch = new Button();
        btnSearch.setCaption("Search");
        btnSearch.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
//                RestClientArizaKayit restClientArizaKayit=new RestClientArizaKayit();
//                List<ArizaKayitDto> arizaKayitDtoList = restClientArizaKayit.arizaKayitBul(Long.parseLong(searchTextField.getValue()));
//                System.out.println(arizaKayitDtoList);
            }
        });

        formLayout.addComponent(searchTextField);
        formLayout.addComponent(btnSearch);

        addComponent(formLayout);
    }

    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("ad", String.class, null);
        indexedContainer.addContainerProperty("ariza", String.class, null);
        indexedContainer.addContainerProperty("arizaİcerik", String.class, null);
        indexedContainer.addContainerProperty("enumArizaDurum", EnumArizaDurum.class, null);
        indexedContainer.addContainerProperty("arizaTarih", Date.class, null);
    }

    private void buildTable() {

        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("NO", "AD", "ARİZA", "ARİZA İÇERİK", "ARİZA DURUM", "TARİH");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                arizaKayitDto = (ArizaKayitDto) itemClickEvent.getItemId();
                arizaKayitView.fillViewByArizaKayit(arizaKayitDto);
            }
        });
        addComponent(table);
    }

    public void fillTable() {
        RestClientArizaKayit restClientArizaKayit = new RestClientArizaKayit();
        Collection<ArizaKayitDto> arizaKayitDtos = restClientArizaKayit.arizaKayitListele();

        for (ArizaKayitDto arizaKayitDto : arizaKayitDtos) {
            Item item = indexedContainer.addItem(arizaKayitDto);
            item.getItemProperty("id").setValue(arizaKayitDto.getId());
            item.getItemProperty("ad").setValue(arizaKayitDto.getAd());
            item.getItemProperty("ariza").setValue(arizaKayitDto.getAriza());
            item.getItemProperty("arizaİcerik").setValue(arizaKayitDto.getArizaİcerik());
            item.getItemProperty("enumArizaDurum").setValue(arizaKayitDto.getEnumArizaDurum());
            item.getItemProperty("arizaTarih").setValue(arizaKayitDto.getArizaTarih());
        }
    }
}
