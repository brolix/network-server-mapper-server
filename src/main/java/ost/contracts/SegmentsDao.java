package ost.contracts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ost.model.Segment;

@Repository
public interface SegmentsDao extends MongoRepository<Segment,String> {
}
