package ost.contracts;

import ost.model.wrappers.PingWrapper;

import java.util.Collection;

public interface PingManager extends DataManager{
    /**
     * get a collection of in progress segments and servers
     * @return collection of ping wrappers
     */
    Collection<PingWrapper> getInProgressObjects();
}
