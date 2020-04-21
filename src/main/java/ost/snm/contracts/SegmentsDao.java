package ost.snm.contracts;

import org.springframework.data.mongodb.repository.MongoRepository;
import ost.snm.model.Segment;

import java.util.Optional;

public interface SegmentsDao extends MongoRepository<Segment,String> {

    Optional<Segment> findSegmentBySubnetAddr(String subnetAddr);
}
