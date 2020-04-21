package ost.snm.contracts;

import ost.snm.exceptions.SegmentDataException;
import ost.snm.model.Segment;
import ost.snm.model.Server;

import java.util.Collection;

public interface ModelManager extends DataManager {
    /**
     * get all of the server of a given segment
     * @param segment the segment needed
     * @return collection of all the server that relate to the given segment
     * @throws SegmentDataException is thrown when there is no corresponding segment in the data
     */
    Collection<Server> getServersBySegment(String segment)
            throws SegmentDataException;

    /**
     * get the segment object corresponding to the given segment
     * @param segment the segment needed
     * @return the segment needed
     * @throws SegmentDataException is thrown when there is no corresponding segment in the data
     */
    Segment getSegment(String segment)
            throws SegmentDataException;

    /**
     * get the segments corresponding to the args
     * @param segments the needed segments
     * @return collection containing all of the needed segments
     */
    Collection<Segment> getSegments(String... segments)
            throws SegmentDataException;
}
