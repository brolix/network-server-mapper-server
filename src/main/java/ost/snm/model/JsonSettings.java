package ost.snm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class JsonSettings {
    private Map<String,Object> settings;

    public JsonSettings(){
        this.settings = new HashMap<>();
    }
}
