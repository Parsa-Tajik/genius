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
        } else {
            System.out.println("Artist already followed");
        }
    }
    public void likeSong(Song song) {
        if (!likedSongs.contains(song)) {
            likedSongs.add(song);
            song.addLike();
        } else {
            System.out.println("Song already liked");
        }
    }
    public void addFavoriteSong(Song song) {
        if (!favoriteSongs.contains(song)) {
            favoriteSongs.add(song);
        } else {
            System.out.println("Song already in your favorite list!");
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
}