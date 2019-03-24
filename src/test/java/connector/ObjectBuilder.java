package connector;

import com.google.gson.Gson;
import dao.Game;
import dao.User;

import java.util.ArrayList;
import java.util.List;

public class ObjectBuilder {

    public static User getUserById(int id) {
        Gson gson = new Gson();
        String json = RestConnector.getUserById(id);
        System.out.println(json);
        User user = gson.fromJson(json, User.class);
        return user;

    }

    public static Game getGameById(int id) {
        Gson gson = new Gson();
        String json = RestConnector.getGameById(id);
        Game game = gson.fromJson(json, Game.class);
        return game;
    }

    public static List<Game> getGamesList() {
        List<Game> result = new ArrayList<>();
        String json = RestConnector.getAllGames();
        System.out.println(json);
        return result;
    }

    public static List<User> getUsersList() {
        List<User> result = new ArrayList<>();
        String json = RestConnector.getAllUsers();
        System.out.println(json);
        return result;
    }
}
