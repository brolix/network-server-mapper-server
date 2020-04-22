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
        return dao.save(segment);
    }

    @Override
    public Collection<Segment> getAllSegments() {
        return dao.findAll();
    }

    @Override
    public Optional<Segment> findSegmentByAddr(String subnetAddress) {
        return dao.findSegmentBySubnetAddr(subnetAddress);
    }

    @Override
    public void updateSegment(Segment newSegment) {
        dao.save(newSegment);
    }

    @Override
    public void deleteSegment(Segment segment) {
        dao.delete(segment);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
