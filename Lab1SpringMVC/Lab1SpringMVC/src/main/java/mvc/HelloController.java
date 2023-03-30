package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello( @RequestParam(value="firstname") String firstName,
                        @RequestParam(value="lastname") String lastName) {

        String message=firstName+" "+lastName;

        Map<String, Object> params = new HashMap<>();
        params.put("message", message);

        return new ModelAndView("hello",params);
    }
    @RequestMapping("/calc")
    public ModelAndView calculate(@RequestParam(value="num1") Integer num1,
                                  @RequestParam(value="num2") Integer num2, @RequestParam String op) {

        Integer output = 0;

        switch (op){
            case "/":
                output= num1 / num2;
                break;
            case "+":
                output= num1 + num2;
                break;
            case "-":
                output= num1 - num2;
                break;
            case "*":
                output= num1 * num2;
                break;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("num1", num1);
        params.put("op", op);
        params.put("num2", num2);
        params.put("result", output);

        return new ModelAndView("hello",params);
    }
}

