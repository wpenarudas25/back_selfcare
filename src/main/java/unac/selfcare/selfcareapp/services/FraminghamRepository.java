package unac.selfcare.selfcareapp.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.Framingham;

@Repository
public interface FraminghamRepository extends MongoRepository<Framingham, String> {
    Framingham findByUserId(String userId);
}
