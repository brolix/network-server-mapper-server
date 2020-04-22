package ost.snm.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ost.snm.contracts.Configurable;
import ost.snm.contracts.Hashable;

import java.util.List;

@Document("Segments")
@Data
@NoArgsConstructor
public class Segment implements Configurable, Hashable {

    @Id
    private String id;

    @Indexed(unique=true)
    private String subnetAddr;
    private String desc;
    private List<Server> servers;
    private JsonSettings settings;

    public Segment(String subnetAddr, String desc, List<Server> servers, JsonSettings settings) {
        this.subnetAddr = subnetAddr;
        this.desc = desc;
        this.servers = servers;
        this.settings = settings;
    }

    @Override
    public JsonSettings getSettings() {
        return this.settings;
    }

    @Override
    public String getHash() {
        return id;
    }
}
