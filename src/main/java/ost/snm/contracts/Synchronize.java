package ost.snm.contracts;

import lombok.Synchronized;

public interface Synchronize<T> {
    /**
     * Adds an object to a collection in a synchronized way.
     * @param object Object to add.
     */
    void addObject(T object);

    /**
     * Removes an object from a collection.
     * @param object Object to remove
     */
    void removeObject(T object);
}
