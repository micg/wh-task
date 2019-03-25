package connector;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
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
import java.util.Map;

class RestConnector {

    private static final String HOST = "localhost";
    private static final int port = 3000;

    /**
     * Sends GET request
     * @param path path servers path that is accessed
     * @param parameters parameters to be included
     * @return JSON with response
     */
    static String sendGetRequest(String path, Map<String, String> parameters){
        try {
            return createAndSendGET(buildUri(path, parameters));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * Sends GET request
     * @param path path servers path that is accessed
     * @return JSON with response
     */
    static String sendGetRequest(String path){
        try {
            return createAndSendGET(buildUri(path));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * Sends POST request
     * @param path servers path that is accessed
     * @param inputJson JSON of object to create
     * @return HTTP response of the action
     */
    static HttpResponse sendPostRequest(String path, String inputJson) {
        URI uri;
        HttpResponse response = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            uri = buildUri(path);
            StringEntity stringEntity = new StringEntity(inputJson, ContentType.create("application/json", "UTF-8"));
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(stringEntity);
            response = client.execute(httpPost);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Sends PUT request
     * @param path servers path that is accessed
     * @param inputJson JSON of object update create
     * @return HTTP response of the action
     */
    static HttpResponse sendPutRequest(String path, String inputJson) {
        URI uri;
        HttpResponse response = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            uri = buildUri(path);
            StringEntity stringEntity = new StringEntity(inputJson, ContentType.create("application/json", "UTF-8"));
            HttpPut httpPut = new HttpPut(uri);
            httpPut.setEntity(stringEntity);
            response = client.execute(httpPut);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static String createAndSendGET(URI uri) {
        StringBuilder result = new StringBuilder();
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse response = client.execute(httpGet);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static URI buildUri(String path, Map<String,String> parameters) throws URISyntaxException {
        URIBuilder uri = new URIBuilder(buildUri(path));
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            uri.addParameter(parameter.getKey(), parameter.getValue());
        }
        return uri.build();
    }

    private static URI buildUri(String path) throws URISyntaxException {
        URIBuilder uri = new URIBuilder();
        uri.setScheme("http")
                .setHost(HOST + ":" + port)
                .setPath(path);
        return uri.build();
    }
}
