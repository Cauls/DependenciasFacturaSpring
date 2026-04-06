package com.example.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("itemsInvoiceOffice")
    private List<Item> itemsInvoice;

    public Invoice() {
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItemsInvoice() {
        return itemsInvoice;
    }
    public void setItemsInvoice(List<Item> items) {
        this.itemsInvoice = items;
    }
    public Integer getTotalPrice(){
        Integer totalPrice = 0;
        // for(Item i : items){
        //     totalPrice += i.getTotalPrice();
        // }
        totalPrice = itemsInvoice.stream().map(item -> item.getTotalPrice())
        .reduce(0, (sum, importe) -> sum + importe);
        return totalPrice;
    }
    

    
}
