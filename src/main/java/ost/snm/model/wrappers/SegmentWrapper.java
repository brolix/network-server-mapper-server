package ost.snm.model.wrappers;

import ost.snm.model.Segment;

public class SegmentWrapper extends PingWrapper {
    private Segment segment;

    public SegmentWrapper(Segment segment) {
        this.segment = segment;
    }

    @Override
    public void generateJson() {
        System.out.println("Running on segment: "+segment.getSubnetAddr()+ " With hash: "+segment.getId());
    }

    @Override
    public String getHash() {
        return segment.getHash();
    }
}
