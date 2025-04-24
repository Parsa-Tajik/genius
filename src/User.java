package src;

import java.util.ArrayList;

public class User extends Account {
    private ArrayList<Artist> followedArtists;
    private ArrayList<Song> likedSongs;
    private ArrayList<Song> favoriteSongs;
    private ArrayList<Song> viewdSongs;

    public User(String name, int age, String email, String username, String password) {
        super(name, age, email, username, password);
        this.followedArtists = new ArrayList<>();
        this.favoriteSongs = new ArrayList<>();
        this.viewdSongs = new ArrayList<>();
        this.likedSongs = new ArrayList<>();
    }

    public void followArtist(Artist artist) {
        if (!followedArtists.contains(artist)) {
            followedArtists.add(artist);
            artist.addFollower(this);
            System.out.println(artist.getName() + " followed successfully...");
            Main.wait(2000);
        } else {
            System.out.println("Artist already followed");
        }
    }
    public void likeSong(Song song) {
        if (!likedSongs.contains(song)) {
            likedSongs.add(song);
            song.addLike();
            System.out.println("Successfully liked...");
            Main.wait(2000);
        } else {
            System.out.println("Song already liked");
        }
    }
    public void addFavoriteSong(Song song) {
        if (!favoriteSongs.contains(song)) {
            favoriteSongs.add(song);
            System.out.println("Successfully added to favorite songs...");
            Main.wait(2000);
        } else {
            System.out.println("Song already in your favorite list!");
            Main.wait(1000);
        }
    }
    public void viewSong(Song song) {
        if (!viewdSongs.contains(song)) {
            viewdSongs.add(song);
            song.addView();
        }
    }

    public ArrayList<Artist> getFollowedArtists() {
        return followedArtists;
    }
    public ArrayList<Song> getFavoriteSongs() {
        return favoriteSongs;
    }
}