package io.realm;


public interface DataItemRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$itemName();
    public void realmSet$itemName(String value);
    public String realmGet$category();
    public void realmSet$category(String value);
    public String realmGet$description();
    public void realmSet$description(String value);
    public int realmGet$sort();
    public void realmSet$sort(int value);
    public double realmGet$price();
    public void realmSet$price(double value);
    public String realmGet$image();
    public void realmSet$image(String value);
    public Integer realmGet$starStatus();
    public void realmSet$starStatus(Integer value);
}
