package br.com.fmbordignon.hands_on.library.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("books")
public record BookEntity(@Id ObjectId _id,
                         String name) {
}
