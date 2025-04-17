public class ArtistManager extends Main{

    // Menu options for artists
    public static void artistMenu(Artist artist) {
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
                        System.out.println("You have no songs.");
                    } else {
                        for (Song s : artist.getSongs()) {
                            System.out.println(s);
                        }
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

}
