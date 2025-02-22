package br.com.fmbordignon.hands_on.library.api;

import br.com.fmbordignon.hands_on.library.model.entity.BookEntity;
import br.com.fmbordignon.hands_on.library.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/v1")
public class HelloWorldAPI {

    private final BookRepository bookRepository;

    public HelloWorldAPI(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/hello")
    public Mono<String> hello() {
        System.out.println("chamou meu endpoint");
        return Mono.just("Hello World!");
    }

    @PostMapping("/book")
    public Mono<BookEntity> book(@RequestBody BookEntity book) {
        log.info("Saving book...");

        return bookRepository.save(book);
    }

    @GetMapping("/book/{name}")
    public Flux<BookEntity> findByName(@PathVariable String name) {
        log.info("Finding books by name...");

        return bookRepository.findByName(name);
    }
}
