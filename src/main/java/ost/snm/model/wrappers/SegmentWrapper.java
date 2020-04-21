package ost.snm.model.wrappers;

import ost.snm.model.Segment;

public class SegmentWrapper extends PingWrapper {
    private Segment segment;

    public SegmentWrapper(Segment segment) {
        this.segment = segment;
    }

    @Override
    public void generateJson(String path) {

    }

    @Override
    public String getHash() {
        return segment.getHash();
    }
}
