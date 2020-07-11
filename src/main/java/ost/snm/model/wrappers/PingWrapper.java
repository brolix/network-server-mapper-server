package ost.snm.model.wrappers;

import lombok.Getter;

public abstract class PingWrapper implements Runnable {
    @Getter
    private long timestamp;

    public PingWrapper() {
        this.timestamp = System.currentTimeMillis();
    }

    public abstract void generateJson();
    public abstract String getHash();

    @Override
    public void run() {
        generateJson();
    }
}
