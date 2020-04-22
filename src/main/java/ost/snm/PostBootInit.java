package ost.snm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ost.snm.contracts.ModelManager;
import ost.snm.contracts.PingManager;
import ost.snm.managers.ModelManagerImpl;
import ost.snm.managers.PingManagerImpl;

import javax.annotation.PostConstruct;

@Component
public class PostBootInit {

    private final PingManager pingManager;
    private final ModelManager modelManager;

    @Autowired
    public PostBootInit(PingManagerImpl pingManager, ModelManagerImpl modelManager) {
        this.pingManager = pingManager;
        this.modelManager = modelManager;
    }

    @PostConstruct
    public void init() {
        pingManager.init();
        modelManager.init();
    }
}
