import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import com.google.gson.Gson;

public class APIProcessingUtility {
	
	public static String processCallToStackOverflow(String inlineText){
		String searchQueryEncoded="";
		try {
			searchQueryEncoded = URLEncoder.encode(inlineText, StandardCharsets.UTF_8.toString());
			String URL = StackOverflowConstants.STACK_OVERFLOW_SEARCH_API_URL+searchQueryEncoded;
			URL url = new URL(URL);
			StringBuffer responseContent = new StringBuffer();
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			int responsecode = httpURLConnection.getResponseCode();
			if (responsecode != 200) {
				return StackOverflowConstants.EXCEPTION;
			} else {
				GZIPInputStream gzip = new GZIPInputStream(httpURLConnection.getInputStream());
				BufferedReader reader = new BufferedReader(new InputStreamReader(gzip));
				String line;
				while((line=reader.readLine())!=null) {
					responseContent.append(line);
				}
				reader.close();
				return responseContent.toString();
			}
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return StackOverflowConstants.EXCEPTION;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return StackOverflowConstants.EXCEPTION;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return StackOverflowConstants.EXCEPTION;
		}
	}
	
	public static List<Question> getListOfQuestionsFromResponseString(String responseString){
		Gson gson = new Gson();
		QuestionList questions = gson.fromJson(responseString, QuestionList.class);
		if(questions==null) {
			return new ArrayList<Question>();
		}
		else if(questions.getListOfQuestions().size()<=StackOverflowConstants.REQUIRED_ANSWER_SIZE) {
			return questions.getListOfQuestions();
		}
		else {
			List<Question> filteredQuestions = questions.getListOfQuestions().subList(StackOverflowConstants.ZERO, StackOverflowConstants.REQUIRED_ANSWER_SIZE);
			return filteredQuestions;
		}
	}
	
}
