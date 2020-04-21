package ost.snm.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ost.snm.contracts.DalHandler;
import ost.snm.contracts.SegmentsDao;
import ost.snm.model.Segment;

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
    public void createSegments(Collection<Segment> segments) {
        dao.saveAll(segments);
    }

    @Override
    public Segment createSegment(Segment segment) {
        Segment returnValue = dao.save(segment);

        return returnValue;
    }

    @Override
    public Collection<Segment> getAllSegments() {
        return dao.findAll();
    }

    @Override
    public Optional<Segment> findSegmentByAddr(String subnetAddress) {
        Optional<Segment> returnValue = dao.findSegmentBySubnetAddr(subnetAddress);
        return returnValue;
    }

    @Override
    public void updateSegment(Segment newSegment, String oldSegment) {

    }

    @Override
    public void deleteSegment(Segment segment) {
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
