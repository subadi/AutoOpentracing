package opentracinng.subscription;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {


    @GetMapping("/subscribeMovie/{balance}")
    public User subscribeMovie(@RequestParam int balance) {
        User user = new User();
       if(balance<=500)
        {
            //subscribe movie silver pack
            user.setpack("SILVER");
            user.setBalance(balance);
            user.setEmail("user.goldemail");
        }
        else if(balance>500)
        {
            //subscribe movie gold pack
            user.setpack("GOLD");
            user.setBalance(balance);
            user.setEmail("user.silveremail");

        }
        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("Uemail", user.getEmail());
        fields.put("Ubalance", user.getBalance());
        System.out.println("Map is: "+fields);

        return user;
    }

    @PostMapping(value="/subscribeMovie",consumes = "application/json", produces = "application/json")
    public User PostsubscribeMovie(@RequestBody User user) {
        System.out.println("Post Request Received at Subscribe Movie: "+user.getBalance());
        if(user.getBalance()<=500)
        {
            //subscribe movie silver pack
            user.setpack("SILVER");
            user.setBalance(user.getBalance());
            user.setEmail("silver@user.com");
            System.out.println("Silver Subscribed!");
        }
        else if(user.getBalance()>500)
        {
            //subscribe movie gold pack
            user.setpack("GOLD");
            user.setBalance(user.getBalance());
            user.setEmail("gold@user.com");
            System.out.println("Gold Subscribed!");

        }
        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("userEmailAddress", user.getEmail());
        fields.put("userBalance", user.getBalance());
        System.out.println("PostsubscribeMovie Map is: "+fields);

        return user;
    }
}
