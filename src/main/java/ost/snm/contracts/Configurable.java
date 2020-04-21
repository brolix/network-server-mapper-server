package ost.snm.contracts;

import ost.snm.model.JsonSettings;

public interface Configurable {
    /**
     * get the configuration of the object
     * @return a json settings object with the configurable data
     */
    JsonSettings getSettings();
}
