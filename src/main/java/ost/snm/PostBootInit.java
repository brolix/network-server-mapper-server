package ost.snm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ost.snm.managers.PingManagerImpl;

import javax.annotation.PostConstruct;

@Component
public class PostBootInit {

    private final PingManagerImpl pingManager;

    @Autowired
    public PostBootInit(PingManagerImpl pingManager) {
        this.pingManager = pingManager;
    }

    @PostConstruct
    public void init() {
        pingManager.init();
    }
}
