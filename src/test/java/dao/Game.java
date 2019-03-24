package dao;

import com.google.gson.annotations.SerializedName;

public class Game {
    private String id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Type")
    private String gameType;

    @SerializedName("Currency")
    private String currency;

    @SerializedName("Stake")
    private String stakes;

    @SerializedName("StakesThisWeek")
    private String stakesThisWeek;

    public Game(String id, String name, String gameType, String currency, String stakes, String stakesThisWeek) {
        this.id = id;
        this.name = name;
        this.gameType = gameType;
        this.currency = currency;
        this.stakes = stakes;
        this.stakesThisWeek = stakesThisWeek;
    }

    public Game(String json) {

    }

    /**
     * Auto-generated methods
     **/
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

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStakes() {
        return stakes;
    }

    public void setStakes(String stakes) {
        this.stakes = stakes;
    }

    public String getStakesThisWeek() {
        return stakesThisWeek;
    }

    public void setStakesThisWeek(String stakesThisWeek) {
        this.stakesThisWeek = stakesThisWeek;
    }
}
