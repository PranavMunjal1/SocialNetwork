package Final1;

import java.util.List;

public class SocialNetworkApp {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        // Create profiles
        network.joinNetwork("Mark", "profile1.jpg", "Feeling good today!");
        network.joinNetwork("John", "profile2.jpg", "Excited for the weekend!");
        network.joinNetwork("Alice", "profile3.jpg", "Looking for book recommendations");

        // Update profile
        network.updateProfile("Mark", "Mark Zuckerberg", "profile1_updated.jpg");

        // Add friends
        network.addFriend("Mark", "John");
        network.addFriend("Mark", "Alice");

        // Get a profile and display its friends
        Profile markProfile = network.searchProfile("Mark");
        if (markProfile != null) {
            System.out.println(markProfile.getName() + "'s friends:");
            for (Profile friend : markProfile.getFriends()) {
                System.out.println("- " + friend.getName());
            }
        }

        // Get friends' friends
        List<Profile> friendsOfFriends = network.getFriendsOfFriends("Mark");
        if (!friendsOfFriends.isEmpty()) {
            System.out.println("Friends of friends:");
            for (Profile friend : friendsOfFriends) {
                System.out.println("- " + friend.getName());
            }
        }
    }
}