package sample;

import javafx.beans.property.SimpleStringProperty;

public class Data {
    private SimpleStringProperty standard;
    private SimpleStringProperty size;
    private SimpleStringProperty kg;
    private SimpleStringProperty won;
    private SimpleStringProperty date;

    public Data(){
        this.standard = new SimpleStringProperty();
        this.size = new SimpleStringProperty();
        this.kg = new SimpleStringProperty();
        this.won = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
    }

    public Data(String standard, String size, String kg, String won, String date) {
        this.standard = new SimpleStringProperty(standard);
        this.size = new SimpleStringProperty(size);
        this.kg = new SimpleStringProperty(kg);
        this.won = new SimpleStringProperty(won);
        this.date = new SimpleStringProperty(date);
    }

    public Data(SimpleStringProperty standard, SimpleStringProperty size, SimpleStringProperty kg, SimpleStringProperty won, SimpleStringProperty date) {
        this.standard = standard;
        this.size = size;
        this.kg = kg;
        this.won = won;
        this.date = date;
    }

    public String getStandard() {
        return standard.get();
    }

    public SimpleStringProperty standardProperty() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard.set(standard);
    }

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getKg() {
        return kg.get();
    }

    public SimpleStringProperty kgProperty() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg.set(kg);
    }

    public String getWon() {
        return won.get();
    }

    public SimpleStringProperty wonProperty() {
        return won;
    }

    public void setWon(String won) {
        this.won.set(won);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
