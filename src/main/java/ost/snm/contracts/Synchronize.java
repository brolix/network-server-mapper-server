package ost.snm.contracts;

import lombok.Synchronized;

public interface Synchronize<T> {
    /**
     * Adds an object to a collection in a synchronized way.
     * @param object Object to add.
     */
    @Synchronized
    void addObject(T object);

    /**
     * Removes an object from a collection.
     * @param object Object to remove
     */
    @Synchronized
    void removeObject(T object);

    /**
     * Checks if the given object is in a collection.
     * @param object Object to validate existence
     * @return True if a collection contains the object, false otherwise.
     */
    @Synchronized
    boolean contains(T object);
}
