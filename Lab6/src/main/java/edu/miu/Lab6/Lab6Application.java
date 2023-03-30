package edu.miu.Lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableScheduling
public class Lab6Application {

	ReactiveMongoTemplate reactiveMongoTemplate;

	@Autowired
	public Lab6Application(ReactiveMongoTemplate reactiveMongoTemplate){
		this.reactiveMongoTemplate=reactiveMongoTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab6Application.class, args);
	}

	@PostConstruct
	public void init() {
		reactiveMongoTemplate.dropCollection("person").then(reactiveMongoTemplate.createCollection("person",
				CollectionOptions.empty().capped().size(2048).maxDocuments(10000))).block();
	}
}
