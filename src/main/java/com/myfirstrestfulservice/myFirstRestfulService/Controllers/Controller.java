package com.myfirstrestfulservice.myFirstRestfulService.Controllers;
import java.util.concurrent.atomic.AtomicLong;

import com.myfirstrestfulservice.myFirstRestfulService.Methods.Greeting;
import com.myfirstrestfulservice.myFirstRestfulService.Methods.Sum;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final String xVarStr = "0";
    private static final String yVarStr = "0";

    @GetMapping("/greeting")
        public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/sum")
    public Sum sum(
            @RequestParam(value = "xVar", defaultValue = "0") Integer xVar,
            @RequestParam(value = "yVar", defaultValue = "0") Integer yVar
    )
    {
        String xVarStr = xVar.toString();
        String yVarStr = yVar.toString();
        String finalSum = String.valueOf(xVar + yVar);
        String sumFin = String.format(xVarStr + " + " + yVarStr + " = " + finalSum);
        if (xVar + yVar != 0) {
            return new Sum(sumFin);
        } else {
            return new Sum(String.format("/sum?xVar=0&yVar=0"));
        }
    }
}
