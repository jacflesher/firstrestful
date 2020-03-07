package com.myfirstrestfulservice.myFirstRestfulService.Controllers;
import java.util.concurrent.atomic.AtomicLong;

import com.myfirstrestfulservice.myFirstRestfulService.Methods.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final String xStr = "0";
    private static final String yStr = "0";

    @GetMapping("/")
    public DefaultLanding defaultlanding() {
        String hint = Hint("default");
        return new DefaultLanding(hint);
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if (name.equals("")) {
            String hint = Hint("greeting");
            return new Greeting(String.format(hint));
        } else {
            return new Greeting(String.format(template, name));
        }
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
        String sumFin = String.format(finalSum);
        if (x + y != 0) {
            return new Sum(sumFin);
        } else {
            String hint = Hint("sum");
            return new Sum(String.format(hint));
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
        String DiffFin = String.format(finalDiff);
        if (x + y != 0) {
            return new Diff(DiffFin);
        } else {
            String hint = Hint("diff");
            return new Diff(String.format(hint));
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
        String ProductFin = String.format(finalProduct);
        if (x + y != 0) {
            return new Product(ProductFin);
        } else {
            String hint = Hint("product");
            return new Product(String.format(hint));
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
        String ProductFin = String.format(finalDivide);
        if (x + y != 0) {
            return new Divide(ProductFin);
        } else {
            String hint = Hint("divide");
            return new Divide(String.format(hint));
        }
    }

    @PostMapping("/request")
    public ResponseEntity postController(
            @RequestBody LoginForm loginForm) {

       // exampleService.fakeAuthenticate(loginForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private static String Hint(String type) {
        if (type == "default") {
            return "(Hint) /greeting, /sum, /diff, /product, /divide";
        } else if (type == "greeting") {
            return "(Hint) /greeting?name=john";
        } else if (type == "sum") {
            return "(Hint) /sum?x=0&y=0";
        } else if (type == "diff") {
            return "(Hint) /diff?x=0&y=0";
        } else if (type == "product") {
            return "(Hint) /product?x=0&y=0";
        } else if (type == "divide") {
            return "(Hint) /divide?x=0&y=0";
        }
        return "";
    }
}
