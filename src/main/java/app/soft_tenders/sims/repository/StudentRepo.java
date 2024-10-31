package app.soft_tenders.sims.repository;

import app.soft_tenders.sims.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, ObjectId> { }
