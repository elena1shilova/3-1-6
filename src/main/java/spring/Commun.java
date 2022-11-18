package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.models.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Commun {

    private final RestTemplate restTemplate;
    private final String URL = "http://94.198.50.185:7081/api/users";

    public Commun(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAllUser() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        List<User> allUser = responseEntity.getBody();
        String sessionId = responseEntity.getHeaders().get("Set-Cookie").get(0);
        System.out.println(responseEntity.getBody());
        System.out.println(sessionId);
        return sessionId;
    }


    public ResponseEntity<String> addUser(String sessionId, User user) {


        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionId);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 13);
        map.put("name", "Evgeniy");
        map.put("lastName", "Shilov");
        map.put("age", "36");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, entity, String.class);
        //System.out.println(responseEntity.getBody());
        String body = responseEntity.getBody();
        System.out.println(body);
        return responseEntity;
    }
public void updateUser(String sessionid) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Cookie", sessionid);
    Map<String, Object> map = new HashMap<>();
    map.put("id", 13);
    map.put("name", "Evgeniyrrr");
    map.put("lastName", "Shilovofff");
    map.put("age", "38");

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

    restTemplate.put(URL, entity, String.class);
    //System.out.println(map);
    String bo = entity.getBody().toString();
    System.out.println(bo);


//    ResponseEntity<List<User>> responseEntity =
//            restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
//            });
//    List<User> allUser = responseEntity.getBody();
//    String sessionId = responseEntity.getHeaders().get("Set-Cookie").get(0);
//    System.out.println(responseEntity.getBody());
//    System.out.println(sessionId);
//    return sessionId;
}

}
