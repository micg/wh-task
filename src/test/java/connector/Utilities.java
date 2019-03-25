package connector;

import com.google.gson.Gson;
import dao.Game;
import dao.User;

import java.util.HashMap;
import java.util.Map;

import static connector.RestConnector.*;

public class Utilities {

    private Gson gson = new Gson();
    private static final String USERS_PATH = "users";
    private static final String GAMES_PATH = "games";

    /**
     * Returns Game by ID
     * @param id id
     * @return Game
     */
    public Game getGameById(int id) {
        String pathForUserById = GAMES_PATH + "/" + id;
        String json = sendGetRequest(pathForUserById);
        return gson.fromJson(json, Game.class);
    }

    /**
     * Returns User by ID
     * @param id id
     * @return User
     */
    public User getUserById(int id) {
        String pathForUserById = USERS_PATH + "/" + id;
        String json = sendGetRequest(pathForUserById);
        return gson.fromJson(json, User.class);
    }

    /**
     * Returns User by name
     * @param name Name
     * @return User
     */
    public User[] getUserByName(String name) {
        Map<String, String> paramenters = new HashMap<>();
        paramenters.put("Name", name);
        String json = sendGetRequest(USERS_PATH, paramenters);
        return gson.fromJson(json, User[].class);
    }

    /**
     * Returns array of all games
     * @return Game[]
     */
    public Game[] getAllGames() {
        String json = RestConnector.sendGetRequest(GAMES_PATH);
        Game[] games = gson.fromJson(json, Game[].class);
        return games;

    }

    /**
     * Returns array of all users
     * @return User[]
     */
    public User[] getAllUsers() {
        String json = sendGetRequest(USERS_PATH);
        User[] users = gson.fromJson(json, User[].class);
        return users;
    }

    /**
     * Creates new user
     * @param user User
     * @return HTTP result
     */
    public String createNewUser(User user) {
        String json = gson.toJson(user);
        return sendPostRequest(USERS_PATH, json).getEntity().toString();
    }

    /**
     * Creates new game
     * @param game Game
     * @return HTTP result
     */
    public String createNewGame(Game game) {
        String json = gson.toJson(game);
        return sendPostRequest(GAMES_PATH, json).getEntity().toString();
    }

    /**
     * Update user data
     * @param id ID
     * @param updatedUser User
     * @return HTTP result
     */
    public String updateUser(int id, User updatedUser) {
        String json = gson.toJson(updatedUser);
        return sendPutRequest(USERS_PATH + "/" + id, json).getEntity().toString();
    }

    /**
     * Update game data
     * @param id ID
     * @param updatedGame User
     * @return HTTP result
     */
    public String updateGame(int id, Game updatedGame) {
        String json = gson.toJson(updatedGame);
        return sendPutRequest(GAMES_PATH + "/" + id, json).getEntity().toString();
    }
}
