package org.example;

import java.util.ArrayList;

public class Playlist {

    private String name;
    private ArrayList<String> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTracks() {
        return tracks;
    }

    public void addTrack(String track) {

        if (!tracks.contains(track)) {
            tracks.add(track);
        }else{
            System.out.println("Track already exists");
        }
    }

    public void removeTrack(String track) {

        if (tracks.contains(track)) {
            tracks.remove(track);
        }else{
            System.out.println("Track does not exist");
        }
    }

    public void display() {
        System.out.println("Playlist: " + name);
        for (String track : tracks) {
            System.out.println(" - " + track);
        }
    }
}
