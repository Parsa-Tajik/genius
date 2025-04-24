package src;

import java.util.ArrayList;

public class Artist extends Account {
    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private ArrayList<Account> followers;
    private ArrayList<EditMessage> editMessages;

    public Artist(String name, int age, String email, String username, String password) {
        super(name, age, email, username, password);
        this.songs = new ArrayList<>();
        this.albums = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.editMessages = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }
    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
    public void removeAlbum(Album album) {
        albums.remove(album);
    }

    public void addFollower(Account follower) { followers.add(follower); }

    public void addEditMessage(EditMessage editMessage) { editMessages.add(editMessage); }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Account> getFollowers() { return followers; }

    public ArrayList<EditMessage> getEditMessages() { return editMessages; }
}