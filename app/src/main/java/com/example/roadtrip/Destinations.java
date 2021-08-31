package com.example.roadtrip;

import java.util.Map;

public class Destinations {
    private String id;
    private String name;
    private String location;
    private String about;

    public Destinations() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public static Destinations fromMapToDestinations(Map<String, Object> map) {
        Destinations d = null;

        if (map != null) {

            d = new Destinations();

            if (map.containsKey("id")) d.setId(map.get("id").toString());
            if (map.containsKey("name")) d.setName(map.get("name").toString());
            if (map.containsKey("location")) d.setLocation(map.get("location").toString());
            if (map.containsKey("about")) d.setAbout(map.get("about").toString());
        }
        return d;
    }

    @Override
    public String toString() {
        return "Destinations{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
