package example.Practice0918;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ApiController {

    private final ApiService apiService;

    @GetMapping(value = "/koo")
    public Map<String,Object> Koo() {
        return apiService.Koo();
    }

}
