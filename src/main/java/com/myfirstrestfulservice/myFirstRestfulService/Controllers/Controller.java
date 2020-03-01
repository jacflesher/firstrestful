package com.myfirstrestfulservice.myFirstRestfulService.Controllers;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

import com.myfirstrestfulservice.myFirstRestfulService.Methods.DefaultLanding;
import com.myfirstrestfulservice.myFirstRestfulService.Methods.Greeting;
import com.myfirstrestfulservice.myFirstRestfulService.Methods.Sum;
import com.myfirstrestfulservice.myFirstRestfulService.Methods.Product;
import com.myfirstrestfulservice.myFirstRestfulService.Methods.Divide;
import com.myfirstrestfulservice.myFirstRestfulService.Methods.Diff;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final String xStr = "0";
    private static final String yStr = "0";

    @GetMapping("/")
    public DefaultLanding defaultlanding() {
        return new DefaultLanding(String.format("/greeting, /sum, /diff, /product, /divide"));
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/sum")
    public Sum sum(
            @RequestParam(value = "x", defaultValue = "0") Double x,
            @RequestParam(value = "y", defaultValue = "0") Double y
    )
    {
        String xStr = x.toString();
        String yStr = y.toString();
        String finalSum = String.valueOf(x + y);
        String sumFin = String.format("The sum of " + xStr + " and " + yStr + " is " + finalSum);
        if (x + y != 0) {
            return new Sum(sumFin);
        } else {
            return new Sum(String.format("/sum?x=0&y=0"));
        }
    }
    @GetMapping("/diff")
    public Diff diff(
            @RequestParam(value = "x", defaultValue = "0") Double x,
            @RequestParam(value = "y", defaultValue = "0") Double y
    )
    {
        String xStr = x.toString();
        String yStr = y.toString();
        String finalDiff;
        if (x > y) {
            finalDiff = String.valueOf(x - y);
        } else {
            finalDiff = String.valueOf(y - x);
        }
        String DiffFin = String.format("The difference of " + xStr + " and " + yStr + " is " + finalDiff);
        if (x + y != 0) {
            return new Diff(DiffFin);
        } else {
            return new Diff(String.format("/diff?x=0&y=0"));
        }
    }
    @GetMapping("/product")
    public Product product(
            @RequestParam(value = "x", defaultValue = "0") Double x,
            @RequestParam(value = "y", defaultValue = "0") Double y
    )
    {
        String xStr = x.toString();
        String yStr = y.toString();
        String finalProduct;
        finalProduct = String.valueOf(x * y);
        String ProductFin = String.format("The product of " + xStr + " and " + yStr + " is " + finalProduct);
        if (x + y != 0) {
            return new Product(ProductFin);
        } else {
            return new Product(String.format("/product?x=0&y=0"));
        }
    }
    @GetMapping("/divide")
    public Divide divide(
            @RequestParam(value = "x", defaultValue = "0") Double x,
            @RequestParam(value = "y", defaultValue = "0") Double y
    )
    {
        String xStr = x.toString();
        String yStr = y.toString();
        String finalDivide;
        Double dblDivide = (x / y);
        finalDivide = String.valueOf(dblDivide);
        String ProductFin = String.format("The dividend of " + xStr + " divided by " + yStr + " is " + finalDivide);
        if (x + y != 0) {
            return new Divide(ProductFin);
        } else {
            return new Divide(String.format("/divide?x=0&y=0"));
        }
    }
}
