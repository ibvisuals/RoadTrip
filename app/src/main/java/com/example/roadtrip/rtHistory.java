package com.example.roadtrip;

import java.util.Map;

public class rtHistory {

    private String id;
    private String item;
    private String info;

    public rtHistory() {
    }

    public rtHistory(String id, String item, String info) {
        this.id = id;
        this.item = item;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static rtHistory fromMapTortHistory(Map<String, Object> map) {
        rtHistory rth = null;

        if (map != null) {
            rth = new rtHistory();

            if (map.containsKey("id")) rth.setId(map.get("id").toString());
            if (map.containsKey("item")) rth.setItem(map.get("item").toString());
            if (map.containsKey("info")) rth.setInfo(map.get("info").toString());
        }
        return rth;
    }

    @Override
    public String toString() {
        return "rtHistory{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
