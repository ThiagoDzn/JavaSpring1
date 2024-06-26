package ThiagoSpring.CatracasBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class CatracasBackEndApplication {

    private static final Map<String, String> raToNameMap = new HashMap<>();

    static {
        
        raToNameMap.put("24304", "Thiago");
        raToNameMap.put("6521", "Juliana");
        
    }

    public static void main(String[] args) {
        SpringApplication.run(CatracasBackEndApplication.class, args);
    }

    @GetMapping("/ra")
    public String getNameRa(@RequestParam(value = "ra", required = false) String ra) {
        if (raToNameMap.containsKey(ra)) {
            return raToNameMap.get(ra);
        } else {
            return "RA não encontrado";
        }
    }
}
