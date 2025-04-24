# <span style="color:#FFDD40">Genius Project</span>
<p align="center">
  <img src="https://github.com/user-attachments/assets/88c233bc-d6e2-499b-bde0-43ca5147cb61" width="500">
</p>
A Java-based application inspired by Genius.com, designed for managing song lyrics, artist profiles, and user contributions.   

---

## <span style="color:#44AAE5;">Core Features</span>

### <span style="color:#2E8B57;">Artist and User Entities</span>
The application features two main roles: **Artist** and **User**, both extending from the **Account** superclass, allowing for shared attributes and role-specific functionalities.

### <span style="color:#2E8B57;">Artist Data</span>
Each **Artist** manages:
- Songs
- Albums
- Followers
- Edit suggestions from users

### <span style="color:#2E8B57;">User Data</span>
Each **User** keeps track of:
- Artists they follow
- Songs they’ve liked
- Songs they’ve viewed
- Songs they’ve added to favorites

### <span style="color:#2E8B57;">Multiple Artists per Album</span>
Albums can include multiple artists, facilitating collaboration across tracks.

### <span style="color:#2E8B57;">Multiple Artists per Song</span>
A song may have multiple artists, supporting collaborations on individual tracks.

### <span style="color:#2E8B57;">Comment and Edit Suggestion Classes</span>
Dedicated classes are used for managing comments and edit suggestions, allowing interaction between users and artists.

### <span style="color:#2E8B57;">Nested and Recursive Menus</span>
The app features recursive, nested menus for intuitive navigation based on user roles and available actions.

### <span style="color:#2E8B57;">User Input Validation</span>
Robust input validation ensures that only valid data is processed throughout the application.

---

## <span style="color:#44AAE5;">Additional Technical Features</span>

### **<span style="color:#FF6347;">1. Save and Load All Program Data:</span>**  
The application ensures persistence by allowing all data to be saved and reloaded between sessions, maintaining state across user and artist activities.

### **<span style="color:#FF6347;">2. Object Streams for Data Transfer:</span>**  
   Data is serialized and deserialized using **Object Streams**, enabling seamless transfer of complex objects between memory and disk.

### **<span style="color:#FF6347;">3. Generic Functions for Saving and Loading Data (DRY Principle)</span>**:  
   Generic functions handle saving and loading across all entities, maintaining clean, reusable code and following the **DRY (Don't Repeat Yourself)** principle.

### **<span style="color:#FF6347;">4. Exception Handling System:</span>**
   A structured exception handling system catches and manages errors, ensuring smooth operation even during unexpected situations.

### **<span style="color:#FF6347;">5. Loading System for UI/UX Optimization:</span>**
   A **loading system** enhances UX by providing clear feedback during long-running processes, such as data loading or saving, ensuring users are informed about ongoing actions.

---

## <span style="color:#44AAE5;">Getting Started:</span>
- Users can **register**, **log in**, or **close** the application.
- Upon registration, users can choose one of two roles:
    - **User**
    - **Artist**

---

## <span style="color:#44AAE5;">User Features:</span>
Once logged in as a **User**, the application provides access to several features:

#### Main Menu:
1. **Browse All Songs**: View all available songs in the platform.
2. **Favorite Songs**: View all songs the user has marked as favorites.
3. **Browse All Artists**: View all available artists on the platform.
4. **Followed Artists**: View a list of artists the user is following.
5. **Logout**: Logout from the current user account.

#### Song Details:
- Users can select a song from the available list and:
    - **Like** the song.
    - **Comment** on the song.
    - Add the song to the **Favorites** list.
    - View the **Artists** associated with the song.
    - Suggest changes to the song's **Lyrics**.
    - View the **Album** associated with the song.

#### Album Details:
- Users can view all songs in a selected album and choose to play any of them.

#### Artist Details:
- Users can view all available artists and select one to:
    - See all songs by the artist.
    - View the artist’s albums.
    - **Follow** the artist.

---

## <span style="color:#44AAE5;">Artist Features:</span>

Once logged in as an **Artist**, the application provides access to several features specific to managing your songs, albums, and followers:

### Main Menu:
1. **View All My Songs**: See all songs added by the artist.
2. **Add New Song**: Add a new song to the platform, with the ability to select an album and define song details.
3. **View All My Albums**: See all albums created by the artist.
4. **Add New Album**: Add a new album to the artist's profile.
5. **View My Followers**: See the list of followers who are following the artist.
6. **View Edit Suggestions**: View all edit suggestions submitted by users for the artist's songs.
7. **Logout**: Logout from the current artist account.

### Song Management:
Within each song's page, an artist has the following options:
1. **Change Song Title**: Update the title of the song.
2. **Change Song's Album**: Change the album associated with the song (the song will be removed from its current album and added to the new one).
3. **Update Song Lyrics**: Modify the lyrics of the song.
4. **Add Artist to Song**: Add an artist to the song. The application checks if the username exists and ensures the artist is not already part of the song. The new artist will also be added to the list of songs in their profile.
5. **Remove Artist from Song**: Remove an artist from the song. The song will be removed from that artist’s list, and the artist will be removed from the song’s artist list.

### Add a New Song:
When adding a new song, the artist must ensure they have at least one album. The artist can then select an existing album for the song and provide the song's title and lyrics.

### Album Management:
Artists can view all their albums. Upon selecting an album, they have the following options:
1. **View Songs in Album**: See all songs within the selected album.
2. **Edit Album**: Modify details of the album, with options to:
   - **Change Album Name**: Update the album's name.
   - **Add Artist to Album**: Add an artist to the album, following the same checks as adding an artist to a song.
   - **Remove Artist from Album**: Remove an artist from the album, following the same checks as removing an artist from a song.

---

## <span style="color:#FFDD40">Developer</span>
- Parsa Tajik ([github profile](https://github.com/parsa-tajik));
### <span style="color:#44AAE5;">Thanks for Checking Out the Project! 🚀</span>

I hope you enjoyed exploring this project as much as I enjoyed building it. If you have any questions, suggestions, or just want to chat about code, feel free to reach out. 🚀

Don't forget to check out my [GitHub profile](https://github.com/parsa-tajik) for more exciting projects!

Keep coding, and keep jamming! 🎸✨
