package opentracinng.subscription;


import java.util.LinkedHashMap;
import java.util.Map;
import model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {


    @GetMapping("/subscribeMovie/{balance}")
    public User subscribeMovie(@PathVariable int balance) {
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
}
