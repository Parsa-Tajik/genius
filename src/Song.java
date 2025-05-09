package src;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private String lyrics;
    private ArrayList<Artist> artists;
    private Album album;
    private int views;
    private int likes;
    private ArrayList<Comment> comments;
    private Date releaseDate;

    public Song(String title, String lyrics, Artist artist, Album album) {
        this.title = title;
        this.lyrics = lyrics;
        this.releaseDate = new Date();
        this.album = album;
        album.addSong(this);
        this.artists = new ArrayList<>();
        artists.add(artist);
        artist.addSong(this);
        this.comments = new ArrayList<>();
        this.views = 0;
        this.likes = 0;
    }

    public void addArtist(Artist artist) {
        if (!artists.contains(artist)) {
            artists.add(artist);
            artist.addSong(this);
        }
    }
    public void removeArtist(Artist artist) {
        artists.remove(artist);
        artist.removeSong(this);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addView() {
        views++;
    }
    public void addLike() {
        likes++;
    }

    public int getViewCount() {
        return views;
    }
    public int getLikeCount() {
        return likes;
    }

    public String getTitle() {
        return title;
    }
    public Album getAlbum() { return album; }
    public ArrayList<Comment> getComments() {
        return comments;
    }
    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void editTitle(String newTitle) {
        title = newTitle;
    }

    public void changeAlbum(Album newAlbum) {
        this.album.getTracklist().remove(this);
        newAlbum.getTracklist().add(this);
        this.album = newAlbum;
    }

    public void editContent(String newContent) {
        this.lyrics = newContent;
    }

    public void suggestEdit(EditMessage message) {
        for (Artist artist : artists) {
            artist.addEditMessage(message);
        }
    }

    @Override
    public String toString() {
        String commentsStr = "";
        int i = 1;
        for (Comment comment : comments) {
            commentsStr += i + ". " + comment + "\n";
            i++;
        }

        return "\n** Song Page **" +
                "\ntitle: " + title +
                "\nAlbum: " + album.getTitle() +
                "\nTotal views: " + views +
                "\nRelease date: " + releaseDate +
                "\nTotal likes: " + likes +
                "\n-------------------\n" + "Lyrics: \n" + lyrics + "\n-------------------" +
                "\n" + getComments().size() + " Comments:" +
                "\n" + commentsStr;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Song)) {
            return false;
        }

        Song song = (Song) o;
        if (getArtists().size() != song.getArtists().size()) { return  false; }
        for (int i = 0; i < getArtists().size(); i++) {
            if (!getArtists().get(i).equals(song.getArtists().get(i))) { return  false; }
        }

        if (getTitle().equals(song.getTitle())) { return true; }

        return false;
    }
}