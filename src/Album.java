package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Album implements Serializable {
    private String title;
    private Date releaseDate;
    private ArrayList<Song> tracklist; // Tracklist in a specific order.
    private ArrayList<Artist> artists; // Each album can belong to multiple artists.

    public Album(String title, Artist artist) {
        this.title = title;
        this.releaseDate = new Date();
        this.artists = new ArrayList<>();
        this.artists.add(artist);
        artist.addAlbum(this);
        this.tracklist = new ArrayList<>();
    }

    public void addSong(Song song) {
        tracklist.add(song);
    }

    public ArrayList<Song> getTracklist() {
        return tracklist;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void editTitle(String newTitle) {
        title = newTitle;
    }

    public void addArtist(Artist artist) {
        artist.addAlbum(this);
        artists.add(artist);
    }
    public void removeArtist(Artist artist) {
        artist.removeAlbum(this);
        artists.remove(artist);
    }

    @Override
    public String toString() {
        String artistsStr = "";

        for (Artist artist : artists) {
            artistsStr += artist.getName() + "\n";
        }

        return "Title: " + title + "\nRelease date: " + releaseDate + "\nArtist(s): \n" + artistsStr;
    }
}