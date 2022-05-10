package edu.upenn.cit594project.repo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LinkRepo {
    Map<String, String> linkMap;

    public LinkRepo() {
        linkMap = new HashMap<>();
    }

    public void setLink(String key, String link) {
        linkMap.put(key, link);
    }

    public String getLink(String key) {
        return linkMap.getOrDefault(key, "");
    }
}
