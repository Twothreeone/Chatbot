package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String[] verbs;
	private String[] topics;
	private String[] followUps;
	private String[] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;

	/**
	 * Constructor for Chatbot, initializes data members.
	 * 
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.username = username;
		this.content = "content";
		this.intro = "";
		this.followUps = new String[0];
		buildMovieList();
		buildShoppingList();
		buildVerbs();
		buildQuestions();
		// buildFollowups();
		buildTopics();
	}

	/**
	 * Builds the topics array.
	 */
	private void buildTopics()
	{
		topics = new String[] {"math", "video games", "food", "anime", "work"};
	}

	/**
	 * Builds the verbs array.
	 */
	private void buildVerbs()
	{
		verbs = new String[] {"like", "dislike", "am ambivalent about", "am thinking about"};
	}

	/**
	 * Builds the movieList.
	 */
	private void buildMovieList()
	{
		movieList = new ArrayList<Movie>(Arrays.asList(new Movie("Back to the Future"), new Movie("The Princess Bride"), new Movie("Spirited Away"), new Movie("Ferris Bueller's Day Off"),
				new Movie("Space Balls"), new Movie("Monty Python and the Quest for the Holy Grail")));
	}

	/**
	 * Builds the shoppingList.
	 */
	private void buildShoppingList()
	{
		shoppingList = new ArrayList<String>(Arrays.asList("snacks", "veggies", "protein", "red cream soda", "ice cream", "potato chips", "pringles", "candy", "donuts", "cake", "gum"));
	}

	/**
	 * Builds the cuteAnimalMemes list.
	 */
	private void buildCuteAnimals()
	{

	}

	/**
	 * Creates the questions array that will be used for the chatbot's responses.
	 */
	private void buildQuestions()
	{
		questions = new String[] { "What is your name?", "What are your favorite hobbies?", "How do you live?", "What is your favorite color?", "Why?", "What is your least favorite emotion?",
				"What is your job?", "Why are you so useless?", "Do you sleep?", "What is your favorite movie?" };
	}

	/**
	 * Takes in the users input and runs buildChatbotResponse() to craft what the chatbot will respond
	 * with.
	 * 
	 * @param input
	 *            What the user said to the chatbot.
	 * @return What the chatbot will say to the user.
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "You said:" + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		return chatbotResponse;
	}

	/**
	 * Randomly creates what the chatbot will say back to the user using arrays and Math.random().
	 * 
	 * @return The String the chatbot will respond with.
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		random = (int) (Math.random() * 5);
		if (random % 5 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		return response;
	}

	/**
	 * Checks the length of the users input to make sure it is valid.
	 * @param input The user's input.
	 * @return The validity of the user's input's length.
	 */
	public boolean lengthChecker(String input)
	{
		boolean properLength = false;
		if (input != null && input.length() >= 2)
		{
			properLength = true;
		}
		return properLength;
	}

	/**
	 * Checks the validity of the HTML tag
	 * @param input HTML tag
	 * @return The validity of the HTML tag
	 */
	public boolean htmlTagChecker(String input)
	{
		return false;
	}

	/**
	 * Checks the validity of the user's username.
	 * @param input The user's username.
	 * @return The validity of the user's username.
	 */
	public boolean userNameChecker(String input)
	{
		if (input == null)
		{
			return false;
		}
		if (input.length() < 2 || input.charAt(0) != '@' || input.substring(1, input.length()).contains("@"))
		{
			return false;
		}
		return true;
	}

	/**
	 * Checks if the content data member is anywhere in the supplied text.
	 * @param contentCheck The user's input.
	 * @return If the content data member is in the user's input.
	 */
	public boolean contentChecker(String contentCheck)
	{
		if (content.length() < 6)
		{
			return false;
		}
		if (contentCheck.toLowerCase().contains(content.toLowerCase()))
		{
			return true;
		}
		return false;
	}

	/**
	 * Checks if a cute animal meme is anywhere in the user's input.
	 * @param input The user's input.
	 * @return Whether or not the user's input contains a cute animal meme.
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}

	/**
	 * Checks if an item on the shoppingList is anywhere in the user's input.
	 * @param shoppingItem The user's input.
	 * @return Whether or not the user's input contains an item on the shoppingList.
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (String item : shoppingList)
		{
			if (shoppingItem.toLowerCase().contains(item))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a movie on the movieList appears anywhere in the user's input.
	 * @param title The user's input.
	 * @return Whether or not the user's input contains a movie on the movieList.
	 */
	public boolean movieTitleChecker(String title)
	{
		return false;
	}

	/**
	 * Checks if a movie genre on the movieList appears anywhere in the user's input.
	 * @param genre The user's input.
	 * @return Whether or not the user's input contains a movie genre on the movieList.
	 */
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	/**
	 * Checks if the user wants to stop chatting.
	 * @param exitString The user's input.
	 * @return Whether or not the user wants to quit.
	 */
	public boolean quitChecker(String exitString)
	{
		if (exitString == null)
		{
			return false;
		}
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	/**
	 * Checks if the user is keyboard mashing.
	 * @param sample The user's input.
	 * @return Whether or not the user is keyboard mashing.
	 */
	public boolean keyboardMashChecker(String sample)
	{
		String[] mash = { "sdf", "SDF", "dfg", "cvb", ",./", "kjh", "DFG", "CVB", "KJH" };
		for (String letters : mash)
		{
			if (sample.contains(letters))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Overrides the standard toString method for more useful output.
	 */
	public String toString()
	{
		return "";
	}

	/**
	 * @return movieList
	 */
	public List<Movie> getMovieList()
	{
		return movieList;
	}

	/**
	 * @return shoppingList
	 */
	public List<String> getShoppingList()
	{
		return shoppingList;
	}

	/**
	 * @return cuteAnimalMemes
	 */
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	/**
	 * @return questions
	 */
	public String[] getQuestions()
	{
		return questions;
	}

	/**
	 * @return verbs
	 */
	public String[] getVerbs()
	{
		return verbs;
	}

	/**
	 * @return topics
	 */
	public String[] getTopics()
	{
		return topics;
	}

	/**
	 * @return followUps
	 */
	public String[] getFollowUps()
	{
		return followUps;
	}

	/**
	 * @return username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @return content
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * @return intro
	 */
	public String getIntro()
	{
		return intro;
	}

	/**
	 * @return currentTime
	 */
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}

	/**
	 * @param username new username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @param content new content
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
