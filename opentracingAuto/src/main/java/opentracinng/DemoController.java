package opentracinng;

import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import model.user.User;


@RestController
public class DemoController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/subscribeAllServices/{amount}/{flag}")
    public String subscribeAll(@PathVariable int amount,@PathVariable boolean flag) {
        User user= new User();
        System.out.println("Initial User Balance:"+user.getBalance());
        int newBalance= addBalance(user,amount);
        user.setBalance(newBalance);
        System.out.println("After Racharge User Balance: "+user.getBalance());

        user = subscribeMoviePackage(user);
        System.out.println("After Movie Subscription: "+user.getpack()+" Balance: "+user.getBalance());

        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("Uemail", user.getEmail());
        fields.put("Ubalance", user.getBalance());

        user = subscribeSpecialpackage(user);
        System.out.println("Responce received from Specialsubs: "+user.getEmail()+" "+user.getBalance());

        user.setEmail("Useremail@somexample.com");
        user.setBalance(500);
        user.setisSpecialSubscribed(true);
        user.setpack("Gold Pack");

        String response = "User Email:"+user.getEmail()+" User Balance: "+user.getBalance()+" User Movie Pack Service: "+user.getpack()+" User Special Service: "+user.isSpecialSubscribed();
        return response;
    }

    private int addBalance(User user,int amt) {
        int newamt= user.getBalance()+amt;
        return newamt;
    }

    private User subscribeMoviePackage(User user) {
        String url = "http://localhost:8091/subscribeMovie";

        ResponseEntity<User> response = restTemplate.postForEntity(url,user,User.class);
        System.out.println("Response from Subscribe Service "+response.getBody());
        return response.getBody();
    }

    private User subscribeSpecialpackage(User user) {
        URI uri = UriComponentsBuilder //
            .fromHttpUrl("http://localhost:8092/subscribeSpecial") //
            .build(Collections.emptyMap());
        ResponseEntity<User> response = restTemplate.postForEntity(uri,user,User.class);
        return response.getBody();
    }
}
