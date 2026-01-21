package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CustomerModel {
    private String firstNameValue;
    private String lastNameValue;
    private String postCodeValue;
    private String currencyValue;
    private String fullNameValue;

    //ar trebui sa incarc fisierul json
    //ar trebui sa citesc din fisier si sa extrag valorile
    //valorile pe care le-am extras trebuie sa le dau ca parametrii mai jos

    public CustomerModel(String filePath) {
        loadFromJson(filePath);
    }

    public void loadFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readerForUpdating(this)
                    .readValue(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getPostCodeValue() {
        return postCodeValue;
    }

    public void setPostCodeValue(String postCodeValue) {
        this.postCodeValue = postCodeValue;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getFullNameValue() {
        return fullNameValue;
    }

    public void setFullNameValue(String fullNameValue) {
        this.fullNameValue = fullNameValue;
    }
}