import java.util.ArrayList;

public class ArtistManager extends Main{

    private static Artist artist;

    // Menu options for artists
    public static void artistMenu(Artist a) {
        artist = a;

        while (true) {
            System.out.println("\n** Artist Menu **");
            System.out.println("[1] View Your Songs");
            System.out.println("[2] Add a New Song");
            System.out.println("[3] View Your Albums");
            System.out.println("[4] Add a New Album");
            System.out.println("[5] View Your Followers");
            System.out.println("[6] View all edit messages");
            System.out.println("[7] Logout");
            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 7);

            switch (choice) {
                case 1:
                    if (artist.getSongs().isEmpty()) {
                        System.out.println("You have no songs yet...");
                        wait(1000);
                    } else {
                        showSongs(artist.getSongs());
                    }
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    if (artist.getAlbums().isEmpty()) {
                        System.out.println("You have no albums yet...");
                        wait(1000);
                    } else {
                        showAlbums(artist.getAlbums());
                    }
                    break;
                case 4:
                    addAlbum();
                    break;
                case 5:
                    showAllFollowers();
                    break;
                case 6:
                    showAllEditMessages();
                    break;
                case 7:
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
        while (true) {
            System.out.println(song);
            System.out.println("[1] Edit title");
            System.out.println("[2] Edit album");
            System.out.println("[3] Update lyrics");
            System.out.println("[4] Add an artist");
            System.out.println("[5] Delete an artist");
            System.out.println("[6] Exit");
            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 6);

            s : switch (choice) {
                case 1:
                    editSongTitle(song);
                    break;
                case 2:
                    editSongAlbum(song);
                    break;
                case 3:
                    updateLyrics(song);
                    break;

                case 4:
                    System.out.println("\nEnter artist's username you wish to add:");
                    String usernameToAdd = scanner.nextLine();
                    for (Artist artist : song.getArtists()) {
                        if (artist.getUsername().equals(usernameToAdd)) {
                            System.out.println("\nArtist already exists!");
                            wait(1000);
                            break s; //gets back to edit album
                        }
                    }

                    for (Account acc : accounts) {
                        if (acc.getUsername().equals(usernameToAdd) && (acc instanceof Artist)) {
                            song.addArtist((Artist) acc);
                            System.out.println("\nArtist added successfully...");
                            wait(2000);
                            break s;
                        }
                    }

                    System.out.println("\nUsername not found!");
                    wait(1000);

                    break;

                case 5:
                    System.out.println("\nEnter artist's username you wish to remove:");
                    String usernameToRemove = scanner.nextLine();
                    for (Artist artist : song.getArtists()) {
                        if (artist.getUsername().equals(usernameToRemove)) {
                            song.removeArtist(artist);
                            System.out.println("\nArtist removed successfully...");
                            wait(2000);
                            break s;
                        }
                    }

                    System.out.println("\nUsername not found!");
                    wait(1000);
                    break;

                case 6:
                    return;
            }
        }
    }

    private static void editSongTitle(Song song) {
        System.out.println("\nEnter new song title:");
        String newName = scanner.nextLine();
        song.editTitle(newName);
        System.out.println("\nSong title updated successfully...");
        wait(2000);
    }

    private static void editSongAlbum(Song song) {
        System.out.println("\nSelect new album:");

        //displays albums owned by the artist
        int i = 1;
        for (Album album : artist.getAlbums()) {
            System.out.println("[" + i + "] " + album.getTitle());
            i++;
        }
        System.out.println("\n[" + i + "] Exit");

        System.out.print("Enter choice: ");
        int choice = Main.getIntInput(1, i);

        if (choice == i) {
            return;
        } else {
            song.changeAlbum(artist.getAlbums().get(choice - 1));
            System.out.println("\nAlbum changed to " + artist.getAlbums().get(choice - 1).getTitle() + " successfully...");
            wait(2000);
        }
    }

    private static void updateLyrics(Song song) {
        System.out.println("\nWrite new lyrics:");
        String newLyrics = scanner.nextLine();
        song.editContent(newLyrics);
        System.out.println("lyrics updated successfully...");
        wait(2000);
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
            System.out.println("[1] View songs");
            System.out.println("[2] Edit this album");
            System.out.println("[3] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 3);

            switch (choice) {
                case 1:
                    showSongs(album.getTracklist());
                    break;
                case 2:
                    editAlbum(album);
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void editAlbum(Album album) {
        while (true) {
            System.out.println("\n** Edit Album **");
            System.out.println(album);
            System.out.println("[1] Edit album title");
            System.out.println("[2] Add an artist");
            System.out.println("[3] Remove an artist");
            System.out.println("[4] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 4);

            s : switch (choice) {
                case 1:
                    System.out.println("\nEnter new album title:");
                    String newName = scanner.nextLine();
                    album.editTitle(newName);
                    System.out.println("\nalbum title updated successfully...");
                    wait(2000);
                    break;

                case 2:
                    System.out.println("\nEnter artist's username you wish to add:");
                    String usernameToAdd = scanner.nextLine();
                    for (Artist artist : album.getArtists()) {
                        if (artist.getUsername().equals(usernameToAdd)) {
                            System.out.println("\nArtist already exists!");
                            wait(1000);
                            break s; //gets back to edit album
                        }
                    }

                    for (Account acc : accounts) {
                        if (acc.getUsername().equals(usernameToAdd) && (acc instanceof Artist)) {
                            album.addArtist((Artist) acc);
                            System.out.println("\nArtist added successfully...");
                            wait(2000);
                            break s;
                        }
                    }

                    System.out.println("\nUsername not found!");
                    wait(1000);
                    break;

                case 3:
                    System.out.println("\nEnter artist's username you wish to remove:");
                    String usernameToRemove = scanner.nextLine();
                    for (Artist artist : album.getArtists()) {
                        if (artist.getUsername().equals(usernameToRemove)) {
                            album.removeArtist(artist);
                            System.out.println("\nArtist removed successfully...");
                            wait(2000);
                            break s;
                        }
                    }

                    System.out.println("\nUsername not found!");
                    wait(1000);
                    break;

                case 4:
                    return;
            }
        }
    }

    private static void showAllFollowers() {
        if (artist.getFollowers() == null || artist.getFollowers().isEmpty()) {
            System.out.println("\nYou have no followers yet...");
            wait(1000);
            return;
        }

        while (true) {
            System.out.println("\n** Followers **");
            for (int i = 0; i < artist.getFollowers().size(); i++) {
                System.out.println((i + 1) + ". " + artist.getFollowers().get(i).getUsername() + "(" + artist.getFollowers().get(i).getName() + ")");
            }
            System.out.println("[1] Exit");

            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 1);
            if (choice == 1) {
                return;
            }
        }
    }

    private static void showAllEditMessages() {

        if (artist.getEditMessages() == null || artist.getEditMessages().isEmpty()) {
            System.out.println("\nYou have no messages...");
            wait(1000);
            return;
        }

        while (true) {
            System.out.println("\n** Edit Message **");

            int i = 1;
            for (EditMessage message : artist.getEditMessages()) {
                System.out.println(i + ". " + message);
                System.out.println();
                i++;
            }

            System.out.println("[1] Exit");
            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 1);
            if (choice == 1) {
                return;
            }
        }
    }

    private static void addSong() {
        if (artist.getAlbums().isEmpty()) {
            System.out.println("\nPlease add an album first!");
            wait(1500);
            return;
        }

        String title;
        loop : while (true) {
            System.out.print("\nsong title: ");
            title = scanner.nextLine();

            for (Song song : artist.getSongs()) {
                if (song.getTitle().equals(title)) {
                    System.out.println("\nSong already exists! Enter another name!");
                    continue loop;
                }
            }

            break;
        }

        System.out.print("\nsong lyrics: ");
        String lyrics = scanner.nextLine();

        System.out.println("\nsong album: ");
        int i = 1;
        for (Album album : albums) {
            System.out.println("[" + i + "] " + album.getTitle());
            i++;
        }
        System.out.print("\nEnter Your choice: ");
        int choice = Main.getIntInput(1, i - 1);
        Album album = albums.get(choice - 1);

        Song song = new Song(title, lyrics, artist, album);
        songs.add(song);
        artist.addSong(song);
        album.addSong(song);
        System.out.println("\nSong added successfully...");
        wait(2000);
    }

    private static void addAlbum() {
        String title;
        loop : while (true) {
            System.out.print("\nAlbum title: ");
            title = scanner.nextLine();

            for (Album album : artist.getAlbums()) {
                if (album.getTitle().equals(title)) {
                    System.out.println("\nAlbum already exists! Enter another name!");
                    continue loop;
                }
            }

            break;
        }

        Album album = new Album(title, artist);
        albums.add(album);
        artist.addAlbum(album);
        System.out.println("\nAlbum added successfully...");
        wait(2000);
    }
}
