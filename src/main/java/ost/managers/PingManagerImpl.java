package ost.managers;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ost.contracts.PingManager;
import ost.exceptions.SegmentDataException;
import ost.model.Segment;
import ost.model.Server;
import ost.model.wrappers.PingWrapper;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

@Component
public class PingManagerImpl implements PingManager {
    private ConcurrentMap<String,PingWrapper> availablePingObjects;
    private ConcurrentMap<String,PingWrapper> inProcessPingObject;
    private BlockingQueue<PingWrapper> pingJobsRequest;
    private ExecutorService pingExec;
    private Timer scanTimer;
    private ScanTask scanTask;

    @Override
    public Collection<PingWrapper> getInProgressObjects() {
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

    private static class ScanTask extends TimerTask{

        @Override
        public void run() {

        }
    }
}
