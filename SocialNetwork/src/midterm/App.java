/* Pranav Munjal, Travis Huang, Collin Hargreaves, 
 * Javier Gomez Tagle, Long Hodac
 * Mirsaeid Abolghasemi
 * CIS 22C
 * 28 May 2023
 */

package midterm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
	private static List<Profile> profiles = new ArrayList<Profile>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
                 
		System.out.println("Please press one of the following keys: ");
		System.out.println("1: Create a new profile ");
		System.out.println("2: Search for profiles ");
		System.out.println("3: Edit or update a profile ");
		System.out.println("4: Delete a profile ");
		System.out.println("5: Quit ");
		
		int iProfile=scanner.nextInt();
		
		if(iProfile == 5) 
		{
			scanner.close();
			return;
		}
		else if(iProfile == 1) 
		{
			System.out.println("Please enter a name for the profile :\n");
			String name = scanner.next();
			
			if(name != null && name.trim() != "") 
			{
				Profile profile = new Profile(name);
				System.out.println("Please enter a URL for the profile picture:");
				String profilePicture=scanner.next();
				profile.setImage(profilePicture);
				profiles.add(profile);
			}
			
			main(new String[] {});  
		}
		else if(iProfile == 2) 
		{
			System.out.println("Profiles in this social network:");
			for(Profile profile: profiles) {
				System.out.println(profile);
			}
			
			main(new String[] {});
		}
		else if(iProfile == 3) 
		{
			System.out.println("Please choose a profile that you want to update: ");
			
			for(int i=0; i<profiles.size(); i++) 
			{
				System.out.println(i+" for "+profiles.get(i));
			}
			
			System.out.println("5: Return to the main menu");
			int uProfile=scanner.nextInt();
			
			if(uProfile == 5) 
			{
				main(new String[] {});
			}
			else 
			{
				Profile profile=profiles.get(uProfile);
				System.out.println("Select a profile to add a friend");
				for(int i = 0; i<profiles.size(); i++) {
					System.out.println(i+" for "+profiles.get(i));
				}
				System.out.println("5: Return to the main menu");
				int fProfile=scanner.nextInt();
				if(fProfile == 5) {
					main(new String[] {});
				}
				else 
				{
					profile.addFriend(profiles.get(fProfile));
					main(new String[] {});
				}
			}
		}
		else if(iProfile == 4) 
		{
			System.out.println("Please select a profile whose friend you want to delete");
			for(int i=0; i<profiles.size(); i++) 
			{
				System.out.println(i+" for "+profiles.get(i));
			}
			System.out.println("5: Return to the main menu");
			int dProfile = scanner.nextInt();
			if(dProfile == 5) 
			{
				main(new String[] {});
            }
			else 
			{
				System.out.println("Select the friend of "+profiles.get(dProfile).getName()+" you want to delete");
				for(int i = 0; i < profiles.get(dProfile).getFriend().size(); i++) 
				{
					System.out.println(i + " for " + profiles.get(dProfile).getFriend().get(i));
				}
				System.out.println("5: Return to THE main menu");
				int aProfile=scanner.nextInt();
				if(aProfile == 5) 
				{
					main(new String[] {});
				}
				else 
				{
					profiles.get(dProfile).getFriend().set(aProfile, null);
				}
			}
		}
	}
}
