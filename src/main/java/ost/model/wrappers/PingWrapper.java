package ost.model.wrappers;

import lombok.Getter;

public abstract class PingWrapper implements Runnable {
    private String hash;

    @Getter
    private long timestamp;

    public abstract void generateJson(String path);

    @Override
    public void run() {

    }
}
