package ost.snm.contracts;

import ost.snm.model.Segment;

import java.util.Collection;
import java.util.Optional;

public interface DalHandler {
    /**
     * adds all segments to the database
     * @param segments the segments to be added
     */
    void createSegments(Collection<Segment> segments);

    /**
     * create a single segment.
     * @param segment the segment to add
     * @return the id of that segment given by the database
     */
    Segment createSegment(Segment segment);

    /**
     * get all of the segments in the database
     * @return collection with all the segments objects
     */
    Collection<Segment> getAllSegments();

    /**
     * get a segment by its address
     * @param subnetAddress the subnetAddress of the needed segment
     * @return an optional segment
     */
    Optional<Segment> findSegmentByAddr(String subnetAddress);

    /**
     * updates a segment object and replace it with a new one
     * @param newSegment the new segment object to be updated
     * @param oldSegment the segment old subnet in case the subnet was the change
     */
    void updateSegment(Segment newSegment,String oldSegment);

    /**
     * deletes the given segment from the database
     * @param segment the segment that will be deleted
     */
    void deleteSegment(Segment segment);

    /**
     * clears all records from the database<br/>
     * <b style="font-size:15px">Use with caution!!</b>
     */
    void deleteAll();

}
