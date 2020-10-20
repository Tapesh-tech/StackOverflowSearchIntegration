import java.util.List;
import java.util.Scanner;

public class InputOutputUtility {
	public static String welcomeUserAndReadInput() {
		System.out.print("Please enter your search query: ");
		Scanner s1 = new Scanner(System.in);
		String searchQuery = s1.nextLine();
		s1.close();
		return searchQuery;
	}
	
	public static void printDetailsOfQuestions(List<Question> questions, String searchQuery) {
		System.out.println("Here are the top-"+StackOverflowConstants.REQUIRED_ANSWER_SIZE+" results for your search  '"+searchQuery+"':");
		for(Question question : questions) {
			System.out.println("\t Title: "+question.getTitle());
			System.out.println("\t URL: "+question.getLink());
			System.out.println("\t Author Display Name: "+question.getOwner().getDisplay_name());
			System.out.println();
		}
	}
}
