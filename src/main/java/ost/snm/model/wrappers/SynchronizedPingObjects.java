package ost.snm.model.wrappers;

import lombok.Synchronized;
import ost.snm.contracts.Synchronize;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * This class is responsible for syncing
 */
public class SynchronizedPingObjects implements Synchronize<PingWrapper> {
    private ConcurrentMap<String, PingWrapper> availablePingObjects;
    private ConcurrentMap<String, PingWrapper> inProcessPingObject;

    public SynchronizedPingObjects() {
        this.availablePingObjects = new ConcurrentHashMap<>();
        this.inProcessPingObject = new ConcurrentHashMap<>();
    }

    @Override
    public void addObject(PingWrapper object) {
        availablePingObjects.put(object.getHash(), object);
    }


    @Override
    public void removeObject(PingWrapper object) {
        availablePingObjects.remove(object.getHash());
        inProcessPingObject.remove(object.getHash());
    }

    @Override
    public boolean contains(PingWrapper object) {
        return availablePingObjects.containsKey(object.getHash()) || inProcessPingObject.containsKey(object.getHash());
    }

    @Synchronized
    public void markInProcess(String hash, PingWrapper pingWrapper) {
        availablePingObjects.remove(hash);
        inProcessPingObject.put(hash, pingWrapper);
    }

    public Set<Map.Entry<String, PingWrapper>> getAvailablePingSnapshot() {
        return this.availablePingObjects.entrySet();
    }

}
