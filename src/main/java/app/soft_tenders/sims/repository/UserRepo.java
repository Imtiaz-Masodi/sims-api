package app.soft_tenders.sims.repository;

import app.soft_tenders.sims.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    List<User> findByEmailId(String emailId);
}
