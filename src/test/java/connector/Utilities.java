package connector;

import com.google.gson.Gson;
import dao.Game;
import dao.User;

import static connector.RestConnector.*;

public class Utilities {

    private Gson gson = new Gson();
    private static final String USERS_PATH = "users";
    private static final String GAMES_PATH = "games";

    public Game getGameById(int id) {
        String pathForUserById = GAMES_PATH + "/" + id;
        String json = sendGetRequest(pathForUserById);
        return gson.fromJson(json, Game.class);
    }

    public User getUserById(int id) {
        String pathForUserById = USERS_PATH + "/" + id;
        String json = sendGetRequest(pathForUserById);
        return gson.fromJson(json, User.class);
    }

    public User getUserByName(String name) {
        String pathForUserById = USERS_PATH + "?Name=" + name;
        String json = sendGetRequest(pathForUserById);
        return gson.fromJson(json, User.class);
    }

    public Game[] getAllGames() {
        String json = RestConnector.sendGetRequest(GAMES_PATH);
        Game[] games = gson.fromJson(json, Game[].class);
        return games;

    }

    public User[] getAllUsers() {
        String json = sendGetRequest(USERS_PATH);
        User[] users = gson.fromJson(json, User[].class);
        return users;
    }

    public String createNewUser(User user) {
        String json = gson.toJson(user);
        return sendPostRequest(USERS_PATH, json).getEntity().toString();
    }

    public String createNewGame(Game game) {
        String json = gson.toJson(game);
        return sendPostRequest(GAMES_PATH, json).getEntity().toString();
    }

    public String updateUser(int id, User updatedUser) {
        String json = gson.toJson(updatedUser);
        return sendPutRequest(USERS_PATH + "/" + id, json).getEntity().toString();
    }

    public String updateGame(int id, Game updatedGame) {
        String json = gson.toJson(updatedGame);
        return sendPutRequest(GAMES_PATH + "/" + id, json).getEntity().toString();
    }
}
