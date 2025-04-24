import java.util.ArrayList;

public class UserManager extends Main {

    private static User user;

    // Menu options for regular users
    public static void userMenu(User u) {
        user = u;

        while (true) {
            System.out.println("\n** User Menu **");
            System.out.println("Welcome " + u.getName());
            System.out.println("[1] View All Songs");
            System.out.println("[2] View Favourite Songs");
            System.out.println("[3] View All Artists");
            System.out.println("[4] View Followed Artists");
            System.out.println("[5] Logout");
            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 5);

            switch (choice) {
                case 1:
                    showSongs(songs);
                    break;
                case 2:
                    showSongs(user.getFavoriteSongs());
                    break;
                case 3:
                    ArrayList<Artist> artists = new ArrayList<>();
                    for (Account a : accounts) {
                        if (a instanceof Artist) {
                            artists.add((Artist) a);
                        }
                    }
                    showArtists(artists);
                    break;
                case 4:
                    showArtists(user.getFollowedArtists());
                    break;
                case 5:
                    Main.logout();
                    return;
            }
        }
    }

    private static void showSongs(ArrayList<Song> songs) {
        while (true) {
            System.out.println("\n** All Songs **");
            for (int i = 0; i < songs.size(); i++) {
                Song song = songs.get(i);
                System.out.println("[" + (i + 1) + "] " + song.getTitle() + " (" + song.getViewCount() + " views, " + song.getLikeCount() + " likes)");
            }
            System.out.println("[" + (songs.size() + 1) + "] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, songs.size() + 1);
            if (choice == songs.size() + 1) {
                break;
            } else {
                showSong(songs.get(choice - 1));
            }
        }
    }

    private static void showSong(Song song) {
        user.viewSong(song);

        while (true) {
            System.out.println(song);
            System.out.println("[1] Like this song");
            System.out.println("[2] Leave a comment");
            System.out.println("[3] Add to your favorites");
            System.out.println("[4] View artists");
            System.out.println("[5] Suggest edit for this song");
            System.out.println("[6] View album");
            System.out.println("[7] Exit");
            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 7);

            switch (choice) {
                case 1:
                    user.likeSong(song);
                    break;
                case 2:
                    System.out.println("\nWrite your comment:");
                    String commentContent = scanner.nextLine();
                    song.addComment(new Comment(commentContent, user));
                    break;
                case 3:
                    user.addFavoriteSong(song);
                    break;
                case 4:
                    showArtists(song.getArtists());
                    break;
                case 5:
                    System.out.println("\nWrite your message for edit:");
                    String messageContent = scanner.nextLine();
                    song.suggestEdit(new EditMessage(messageContent, user));
                    break;
                case 6:
                    showAlbum(song.getAlbum());
                    break;
                case 7:
                    return;
            }
        }
    }

    private static void showArtists(ArrayList<Artist> artists) {
        while (true) {
            System.out.println("\n** Artists **");
            for (int i = 0; i < artists.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + artists.get(i));
            }
            System.out.println("[" + (artists.size() + 1) + "] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, artists.size() + 1);
            if (choice == artists.size() + 1) {
                break;
            } else {
                showArtist(artists.get(choice - 1));
            }
        }
    }

    private static void showArtist(Artist artist) {
        while (true) {
            System.out.println("\n** Artist **");
            System.out.println("Name: " + artist.getName() + " (" + artist.getFollowers().size() + " followers)");
            System.out.println("[1] view songs");
            System.out.println("[2] view albums");
            System.out.println("[3] follow this artist");
            System.out.println("[4] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 4);

            switch (choice) {
                case 1:
                    showSongs(artist.getSongs());
                    break;
                case 2:
                    showAlbums(artist.getAlbums());
                    break;
                case 3:
                    user.followArtist(artist);
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void showAlbums(ArrayList<Album> albums) {
        while (true) {
            System.out.println("\n** All Albums **");
            for (int i = 0; i < albums.size(); i++) {
                Album album = albums.get(i);
                System.out.println("[" + (i + 1) + "] " + album);
            }
            System.out.println("[" + (albums.size() + 1) + "] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, albums.size() + 1);
            if (choice == albums.size() + 1) {
                break;
            } else {
                showAlbum(albums.get(choice - 1));
            }
        }
    }

    private static void showAlbum(Album album) {
        while (true) {
            System.out.println("\n** Album: **");
            System.out.println(album);
            for (int i = 0; i < album.getTracklist().size(); i++) {
                Song song = album.getTracklist().get(i);
                System.out.println("[" + (i + 1) + "] " + song.getTitle() + " (" + song.getViewCount() + "views, " + song.getLikeCount() + "likes)");
            }
            System.out.println("[" + (album.getTracklist().size() + 1) + "] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, album.getTracklist().size() + 1);
            if (choice == album.getTracklist().size() + 1) {
                break;
            } else {
                showSong(album.getTracklist().get(choice - 1));
            }
        }
    }
}
