package dao;

import com.google.gson.annotations.SerializedName;

public class User {
    private int id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Balance")
    private float balance;

    @SerializedName("Currency")
    private String activeCurrency;

    @SerializedName("Likes")
    private String preferences;

    @SerializedName("High-Roller")
    private boolean highRoller;

    private User() {

    }

    public User(int id, String name, float balance, String activeCurrency, String preferences, boolean isHighRoller) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
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

    public boolean getHighRoller() {
        return highRoller;
    }

    public void setHighRoller(boolean highRoller) {
        this.highRoller = highRoller;
    }
}