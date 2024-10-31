package app.soft_tenders.sims.repository;

import app.soft_tenders.sims.entity.School;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SchoolRepo extends MongoRepository<School, ObjectId> {
    List<School> findBySchoolId(String schoolId);
}
