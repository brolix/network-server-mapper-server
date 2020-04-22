package ost.snm.managers;

import javafx.collections.ObservableMap;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ost.snm.contracts.ModelManager;
import ost.snm.dal.DalHandlerImpl;
import ost.snm.exceptions.SegmentDataException;
import ost.snm.model.JsonSettings;
import ost.snm.model.Segment;
import ost.snm.model.Server;

import java.util.Collection;

@Component
public class ModelManagerImpl implements ModelManager {
    private ObservableMap<String,Segment> segments;
    private JsonSettings globalSettings;
    private final DalHandlerImpl dbHandler;

    @Autowired
    public ModelManagerImpl(DalHandlerImpl dbHandler) {
        this.dbHandler = dbHandler;
    }

    @Override
    public Collection<Server> getServersBySegment(String segment) throws SegmentDataException {
        return null;
    }

    @Override
    public Segment getSegment(String segment) throws SegmentDataException {
        return null;
    }

    @Override
    public Collection<Segment> getSegments(String... segments) throws SegmentDataException {
        return null;
    }

    @Override
    public void add(@NonNull Segment segment) {

    }

    @Override
    public void add(@NonNull Server server, String segment) throws SegmentDataException {

    }

    @Override
    public void update(@NonNull Segment segment) {

    }

    @Override
    public void update(@NonNull Server server, String segment) throws SegmentDataException {

    }

    @Override
    public void delete(@NonNull Segment segment) {

    }

    @Override
    public void delete(@NonNull Server server, String segment) throws SegmentDataException {

    }

    @Override
    public void init() {

    }
}
