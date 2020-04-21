package ost.snm.contracts;

import lombok.NonNull;
import ost.snm.exceptions.NoSegmentFoundException;
import ost.snm.exceptions.NoServerFoundInSegmentException;
import ost.snm.exceptions.SegmentDataException;
import ost.snm.model.Segment;
import ost.snm.model.Server;

public interface DataManager extends Manager{
    /**
     * add a segment to the local data and update the database
     *
     * @param segment the segment to add
     */
    void add(@NonNull Segment segment);

    /**
     * add a server to the given local segment and update the database
     *
     * @param server  the server to add
     * @param segment the key of a segment
     * @throws NoSegmentFoundException is thrown when there is no corresponding segment in the data
     * @throws NoServerFoundInSegmentException is thrown when there is no corresponding server in the given segment
     */
    void add(@NonNull Server server, String segment)
            throws SegmentDataException;

    /***
     * update the given segment in local segments and database
     * @param segment the segment to add
     */
    void update(@NonNull Segment segment);

    /***
     * update the server in the given local segment and
     * @param server the server to add
     * @param segment the segment of the server
     * @throws NoSegmentFoundException is thrown when there is no corresponding segment in the data
     * @throws NoServerFoundInSegmentException is thrown when there is no corresponding server in the given segment
     */
    void update(@NonNull Server server, String segment)
            throws SegmentDataException;

    /***
     * deletes the given segments with <b>all of it's server and settings</b> from the database
     * @param segment the segment to delete
     */
    void delete(@NonNull Segment segment);

    /**
     * deletes a server from a given segment (both db and locally)
     *
     * @param server  the server to delete
     * @param segment the segment of the given server
     * @throws NoSegmentFoundException         is thrown when there is no corresponding segment in the data
     * @throws NoServerFoundInSegmentException is thrown when there is no corresponding server in the given segment
     */
    void delete(@NonNull Server server, String segment)
            throws SegmentDataException;

}
