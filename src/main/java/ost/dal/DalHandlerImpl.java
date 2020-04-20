package ost.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ost.contracts.DalHandler;
import ost.contracts.SegmentsDao;
import ost.model.Segment;

import java.util.Collection;
import java.util.Optional;

@Service
public class DalHandlerImpl implements DalHandler {

    final SegmentsDao dao;

    @Autowired
    public DalHandlerImpl(SegmentsDao dao) {
        this.dao = dao;
    }

    @Override
    public void createSegment(Collection<Segment> segments) {

    }

    @Override
    public Collection<Segment> getAllSegments() {
        return null;
    }

    @Override
    public Optional<Segment> findSegmentByAddr(String subnetAddress) {
        return Optional.empty();
    }

    @Override
    public void updateSegment(Segment newSegment, String oldSegment) {

    }

    @Override
    public void deleteSegment(Segment segment) {

    }
}
