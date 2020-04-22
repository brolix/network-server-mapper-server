package ost.snm.contracts;

import ost.snm.model.wrappers.PingWrapper;

import java.util.Collection;

public interface PingManager extends DataManager{
    /**
     * Add a listener to observable object.
     */
    void initListener();

    /**
     * A listener for removing object from an observable.
     */
    void listenerOnRemove(PingWrapper pingWrapper);

    /**
     * A listener for adding object into observable.
     */
    void listenerOnAdd(PingWrapper pingWrapper);
}
