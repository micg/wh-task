package dao;

import com.google.gson.annotations.SerializedName;

public class User {

    private String id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Balance")
    private String balance;

    @SerializedName("Currency")
    private String activeCurrency;

    @SerializedName("Likes")
    private String preferences;

    @SerializedName("High-Roller")
    private String highRoller;

    private User() {

    }

    public User(String id, String name, String balance, String activeCurrency, String preferences, String isHighRoller) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.activeCurrency = activeCurrency;
        this.preferences = preferences;
        this.highRoller = isHighRoller;
    }

    /**
     * Auto-generated methods
     **/
    public User(String json) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getActiveCurrency() {
        return activeCurrency;
    }

    public void setActiveCurrency(String activeCurrency) {
        this.activeCurrency = activeCurrency;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getHighRoller() {
        return highRoller;
    }

    public void setHighRoller(String highRoller) {
        this.highRoller = highRoller;
    }
}