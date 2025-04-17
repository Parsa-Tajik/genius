import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    protected static Scanner scanner = new Scanner(System.in);

    protected static ArrayList<Account> accounts = new ArrayList<>();
    protected static ArrayList<Song> songs = new ArrayList<>();
    protected static ArrayList<Album> albums = new ArrayList<>();

    protected static Account account = null;

    public static void main(String[] args) {
        // initial test values
        Artist artist = new Artist("Metallica", 40, "", "metallica", "metallica");
        Album album = new Album("Black Album", new Date(), artist);
        songs.add(new Song("My Friend Of Mysery", "They Say The Empty Can Rattles The Most", artist, album));
        songs.add(new Song("Holier Than Thou", "who are you, where ya been, where ya from?", artist, album));
        album.addSong(songs.get(0));
        album.addSong(songs.get(1));
        artist.addSong(songs.get(0));
        artist.addSong(songs.get(1));



        // Main loop.
        while (true) {
            if (account != null) {
                if (account instanceof User) {
                    UserManager.userMenu((User) account);
                } else if (account instanceof Artist) {
                    ArtistManager.artistMenu((Artist) account);
                }

                continue;
            }

            System.out.println("\n*** Hey, Welcome to Genius! ***");
            System.out.println("[1] Sign Up");
            System.out.println("[2] Log In");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");
            int choice = getIntInput(1, 3);

            if (choice == 1) {
                signUp();
            } else if (choice == 2) {
                logIn();
            } else {
                System.out.println("Goodbye!");
                wait(1000);
                break;
            }
        }
    }

    // Sign-up process: get user information and the role.
    private static void signUp() {
        System.out.println("\n** Sign Up **");
        System.out.print("What's Your Name? ");
        String name = scanner.nextLine();
        System.out.print("Enter Your Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Your Email: ");
        String email = scanner.nextLine();
        String username = inputUsername();
        String password = inputPassword();

        System.out.println("Select Role:");
        System.out.println("[1] User");
        System.out.println("[2] Artist");
        System.out.print("Enter your choice: ");
        int roleChoice = getIntInput(1, 2);

        account = switch (roleChoice) {
            case 1 -> new User(name, age, email, username, password);
            case 2 -> new Artist(name, age, email, username, password);
            default -> null;
        };

        accounts.add(account);
        System.out.println("Account created successfully! Redirecting...");
        wait(2000);
    }

    // to get username and check the availability
    private static String inputUsername() {
        System.out.print("Enter A Username: ");
        String username = scanner.nextLine();

        while (true) {
            boolean usernameAvailable = true;
            for (Account account : accounts) {
                if (account.getUsername().equals(username)) {
                    usernameAvailable = false;
                    break;
                }
            }

            if (usernameAvailable) {
                break;
            }

            System.out.print("Username already in use. Enter another username: ");
            username = scanner.nextLine();
        }

        return username;
    }

    // Password confirming process
    private static String inputPassword() {
        System.out.print("Enter A Password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm Your Password: ");
        String confirmPassword = scanner.nextLine();
        while (!password.equals(confirmPassword)) {
            System.out.println("Passwords don't match!");
            System.out.print("Enter A Password: ");
            password = scanner.nextLine();
            System.out.print("Confirm Your Password: ");
            confirmPassword = scanner.nextLine();
        }

        return password;
    }

    private static void logIn() {
        System.out.println("\n** Log In **");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (Account acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                account = acc;
                break;
            }
        }

        if (account == null) {
            System.out.println("Incorrect username or password.");
            return;
        }

        System.out.println("Logged in successfully! Welcome " + account.getName() + ". Redirecting...");
        wait(2000);
    }

    protected static void logout() {
        account = null;
        System.out.println("Logging out...");
        wait(1000);
    }

    public static int getIntInput(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        while (choice < min || choice > max) {
            System.out.println("Invalid input. Try again.");
            choice = sc.nextInt();
            sc.nextLine();
        }
        return choice;
    }

    public static void wait(int milliSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliSeconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}