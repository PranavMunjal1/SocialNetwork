/* Pranav Munjal, Travis Huang, Collin Hargreaves, 
 * Javier Gomez Tagle, Long Hodac
 * Mirsaeid Abolghasemi
 * CIS 22C
 * 28 May 2023
 */

package midterm;

import java.util.*;

class Profile {
    private String name;
    private String image;
    private String status;
    private Set<Profile> friends;

    public Profile(String name) {
        this.name = name;
        this.image = "";
        this.status = "Online";
        this.friends = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Profile> getFriends() {
        return friends;
    }

    public void addFriend(Profile profile) {
        friends.add(profile);
    }

    public void removeFriend(Profile profile) {
        friends.remove(profile);
    }

    @Override
    public String toString() {
        return "Profile [name=" + name + ", image=" + image + ", status=" + status + ", friends=" + friends + "]";
    }
}
