package org.example;

import java.util.ArrayList;

public class MusicLibrary {

    private String name;
    private String owner;
    private ArrayList<String> tracks;
    private ArrayList<Playlist> playlists;

    public MusicLibrary(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track is already here.");
        }
    }

    public void removeTrack(String track) {
        if (tracks.remove(track)) {
            for (Playlist playlist : playlists) {
                playlist.removeTrack(track);
            }
        }
    }

    public void displayTracks() {
        System.out.println("All Tracks in " + name + " :");
        for (String track : tracks) {
            System.out.println(" - " + track);
        }
    }

    public void searchTracks(String keyword) {
        System.out.println("Search results for: " + keyword);
        for (String track : tracks) {
            if (track.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(" - " + track);
            }
        }
    }

    public void createPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(name)) {
                System.out.println("Playlist already existed.");
            }
        }
        playlists.add(new Playlist(name));
    }

    private Playlist findPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(name)) {
                return playlist;
            }
        }
        return null;
    }

    public void addTrackToPlaylist(String track, String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null && tracks.contains(track)) {
            playlist.addTrack(track);
        }
    }

    public void displayPlaylist(String name) {
        Playlist playlist = findPlaylist(name);
        if (playlist != null) {
            playlist.display();
        } else {
            System.out.println("Playlist \"" + name + "\" not found.");
        }
    }

    public void displayAllPlaylists() {
        System.out.println("All Playlists:");
        for (Playlist playlist : playlists) {
            System.out.println(" - " + playlist.getName());
        }
    }

    public int getTrackCount() {
        return tracks.size();
    }

    public int getPlaylistCount() {
        return playlists.size();
    }
}
