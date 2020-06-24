package opentracinng.specialservice;

import java.util.LinkedHashMap;
import java.util.Map;
import model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialSubController {


    @GetMapping("/subscribeSpecial")
    public User subscribeSpecialService(User user,@RequestParam boolean flag) {
        if(flag)
        {
            user.setisSpecialSubscribed(true);
        }
        else
        {
            user.setisSpecialSubscribed(false);
        }

        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("Uemail",user.getEmail());
        fields.put("Ubalance",user.getBalance());
        fields.put("SpecialService",user.isSpecialSubscribed());
        System.out.println("Map is: "+fields);

        return user;
    }
}
