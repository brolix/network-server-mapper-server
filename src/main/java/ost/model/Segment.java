package ost.model;

import ost.contracts.Configurable;
import ost.contracts.Hashable;

import java.util.List;

public class Segment implements Configurable, Hashable {

    private String subnetAddr;
    private String desc;
    private List<Server> servers;
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
