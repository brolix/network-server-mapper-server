package ost.snm.model.wrappers;

import ost.snm.model.Server;

public class ServerWrapper extends PingWrapper {
    private Server server;
    private String segmentSubnet;

    public ServerWrapper(Server server, String segmentSubnet) {
        this.server = server;
        this.segmentSubnet = segmentSubnet;
    }

    @Override
    public void generateJson() {
        System.out.println("Creating server ping request on: "+segmentSubnet+String.valueOf(server.getIp()));
    }

    @Override
    public String getHash() {
        return this.server.getHash();
    }
}
