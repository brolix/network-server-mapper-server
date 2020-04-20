package ost.model;

import ost.contracts.Configurable;
import ost.contracts.Hashable;

public class Server implements Configurable, Hashable {
    private byte ip;
    private JsonSettings settings;

    @Override
    public JsonSettings getSettings() {
        return this.settings;
    }

    @Override
    public String getHash() {
        return null;
    }
}
