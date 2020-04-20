package ost.managers;

import javafx.collections.ObservableMap;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import ost.contracts.ModelManager;
import ost.dal.DalHandlerImpl;
import ost.exceptions.SegmentDataException;
import ost.model.JsonSettings;
import ost.model.Segment;
import ost.model.Server;

import java.util.Collection;

@Component
public class ModelManagerImpl implements ModelManager {
    private ObservableMap<String,Segment> segments;
    private JsonSettings globalSettings;
    private DalHandlerImpl dbHandler;

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
}
