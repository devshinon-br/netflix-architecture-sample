package iftm.newsletter.repositories;

import iftm.newsletter.models.News;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, ObjectId> {
}
