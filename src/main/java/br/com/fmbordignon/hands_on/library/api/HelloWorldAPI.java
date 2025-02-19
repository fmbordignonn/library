package br.com.fmbordignon.hands_on.library.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class HelloWorldAPI {

    @GetMapping("/hello")
    public Mono<String> hello() {
        System.out.println("chamou meu endpoint");
        return Mono.just("Hello World!");
    }
}
