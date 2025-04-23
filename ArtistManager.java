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
            System.out.println("[3] Update Song Lyrics");
            System.out.println("[4] Add a New Album");
            System.out.println("[5] Logout");
            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 5);

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

                    break;
                case 3:

                    break;
                case 4:

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
        while (true) {
            System.out.println(song);
            System.out.println("[1] Edit title");
            System.out.println("[2] Edit album");
            System.out.println("[3] Update lyrics");
            System.out.println("[4] Exit");
            System.out.print("Enter choice: ");
            int choice = Main.getIntInput(1, 4);

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    }

    private static void updateLyrics(Song song) {
        System.out.println("\nWrite new lyrics:");
        String newLyrics = scanner.nextLine();
        song.editContent(newLyrics);
        System.out.println("lyrics updated successfully...");
        wait(2000);
    }

}
