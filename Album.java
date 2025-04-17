import java.util.ArrayList;
import java.util.Date;

public class Album {
    private String title;
    private Date releaseDate;
    private ArrayList<Song> tracklist; // Tracklist in a specific order.
    private Artist artist; // Each album belongs to one artist.

    public Album(String title, Date releaseDate, Artist artist) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.tracklist = new ArrayList<>();
    }

    public void addSong(Song song) {
        tracklist.add(song);
    }

    public ArrayList<Song> getTracklist() {
        return tracklist;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nRelease date: " + releaseDate + "\nArtist: " + artist;
    }
}