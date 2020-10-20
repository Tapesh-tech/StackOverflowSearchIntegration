
import java.util.List;
public class Initiator {

	public static void main(String[] args){
		String searchQuery = InputOutputUtility.welcomeUserAndReadInput();
		String responseFromAPI = APIProcessingUtility.processCallToStackOverflow(searchQuery);
		if(responseFromAPI.equals(StackOverflowConstants.EXCEPTION)) {
			System.out.println("Some exception occured while getting response from API. Program ended. Failed");
			return;
		}
		List<Question> filteredQuestions = APIProcessingUtility.getListOfQuestionsFromResponseString(responseFromAPI);
		InputOutputUtility.printDetailsOfQuestions(filteredQuestions, searchQuery);
		System.out.println("Program ended. Success!");
	}

}
