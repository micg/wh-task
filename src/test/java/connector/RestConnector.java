package connector;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

class RestConnector {

    private static final String HOST = "localhost";
    private static final int port = 3000;

    private static final String USERS_PATH = "users";
    private static final String GAMES_PATH = "games";

    public static String getGameById(int id) {
        String pathForGameById = GAMES_PATH + "/" + id;
        return sendGetRequest(pathForGameById);
    }

    public static String getUserById(int id) {
        String pathForUserById = USERS_PATH + "/" + id;
        return sendGetRequest(pathForUserById);
    }

    public static String getAllGames() {
        return sendGetRequest(GAMES_PATH);
    }

    public static String getAllUsers() {
        return sendGetRequest(USERS_PATH);
    }

    private static String sendGetRequest(String path) {
        URI uri;
        StringBuilder result = new StringBuilder();
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            uri = new URIBuilder()
                    .setScheme("http")
                    .setHost(HOST + ":" + port)
                    .setPath(path)
                    .build();
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse response = client.execute(httpGet);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void sendPostRequest(String path, String inputJson) {
        URI uri;
        StringBuilder result = new StringBuilder();
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            uri = new URIBuilder()
                    .setScheme("http")
                    .setHost(HOST + ":" + port)
                    .setPath(path)
                    .build();
            StringEntity stringEntity = new StringEntity(inputJson, ContentType.create("text/plain", "UTF-8"));
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse response = client.execute(httpPost);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
