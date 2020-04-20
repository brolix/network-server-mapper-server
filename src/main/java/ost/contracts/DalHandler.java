package ost.contracts;

import ost.model.Segment;

import java.util.Collection;
import java.util.Optional;

public interface DalHandler {
    void createSegment(Collection<Segment> segments);
    Collection<Segment> getAllSegments();
    Optional<Segment> findSegmentByAddr(String subnetAddress);
    void updateSegment(Segment newSegment,String oldSegment);
    void deleteSegment(Segment segment);

}
