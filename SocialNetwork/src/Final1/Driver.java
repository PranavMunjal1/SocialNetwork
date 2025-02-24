package Final1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Profile {
    private String name;
    private String image;
    private String status;
    private List<Profile> friends;

    public Profile(String name, String image, String status) {
        this.name = name;
        this.image = image;
        this.status = status;
        this.friends = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public List<Profile> getFriends() {
        return friends;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void addFriend(Profile friend) {
        friends.add(friend);
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void setImage(String newImage) {
        this.image = newImage;
    }
}
class SocialNetwork {
    private Map<String, Profile> profiles;

    public SocialNetwork() {
        this.profiles = new HashMap<>();
    }

    public void joinNetwork(String name, String image, String status) {
        Profile profile = new Profile(name, image, status);
        profiles.put(name, profile);
    }

    public void leaveNetwork(String name) {
        profiles.remove(name);
    }

    public Profile searchProfile(String name) {
        return profiles.get(name);
    }

    public void updateProfile(String name, String newName, String newImage) {
        Profile profile = profiles.get(name);
        if (profile != null) {
            profile.setName(newName);
            profile.setImage(newImage);
        }
    }

    public void addFriend(String name1, String name2) {
        Profile profile1 = profiles.get(name1);
        Profile profile2 = profiles.get(name2);

        if (profile1 != null && profile2 != null) {
            profile1.addFriend(profile2);
            profile2.addFriend(profile1);
        }
    }

    public List<Profile> getFriendsOfFriends(String name) {
        Profile profile = profiles.get(name);
        List<Profile> friendsOfFriends = new ArrayList<>();

        if (profile != null) {
            for (Profile friend : profile.getFriends()) {
                friendsOfFriends.addAll(friend.getFriends());
            }
            friendsOfFriends.remove(profile); // Exclude the original profile's friends
        }

        return friendsOfFriends;
    }
}