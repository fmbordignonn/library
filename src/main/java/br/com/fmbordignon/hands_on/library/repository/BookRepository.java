package br.com.fmbordignon.hands_on.library.repository;

import br.com.fmbordignon.hands_on.library.model.entity.BookEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveMongoRepository<BookEntity, ObjectId> {
    Flux<BookEntity> findByName(String name);
}
