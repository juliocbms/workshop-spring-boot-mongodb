package com.julio.MongoDB.repository;

import com.julio.MongoDB.domain.Post;
import com.julio.MongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
