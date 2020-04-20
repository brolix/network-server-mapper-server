package ost.contracts;

import ost.model.JsonSettings;

public interface Configurable {
    /**
     * get the configuration of the object
     * @return a json settings object with the configurable data
     */
    JsonSettings getSettings();
}
