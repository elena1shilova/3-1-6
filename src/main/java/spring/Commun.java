package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.models.User;

import java.util.List;

@Component
public class Commun {

    private final RestTemplate restTemplate;
    private final String URL = "http://94.198.50.185:7081/api/users";

    public Commun(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getAllUser() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        List<User> allUser = responseEntity.getBody();
        return allUser;
    }
}
