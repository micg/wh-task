package dao;

import com.google.gson.annotations.SerializedName;

public class Game {
    private int id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Type")
    private String gameType;

    @SerializedName("Currency")
    private String currency;

    @SerializedName("Stake")
    private float[] stakes;

    @SerializedName("StakesThisWeek")
    private long stakesThisWeek;

    public Game(int id, String name, String gameType, String currency, float[] stakes, long stakesThisWeek) {
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

    public float[] getStakes() {
        return stakes;
    }

    public void setStakes(float[] stakes) {
        this.stakes = stakes;
    }

    public long getStakesThisWeek() {
        return stakesThisWeek;
    }

    public void setStakesThisWeek(long stakesThisWeek) {
        this.stakesThisWeek = stakesThisWeek;
    }
}
