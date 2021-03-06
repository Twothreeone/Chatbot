package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Manages the Chatbot application including the Model and Frame of the View package.
 * 
 * @author Ben Charlesworth
 * @version 21.11.17 Added Frame 1.3
 */
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
	 *            The user's username
	 */
	public Chatbot(String username)
	{
		this.currentTime = LocalTime.now();
		this.username = username;
		this.content = "content";
		this.intro = "";
		buildMovieList();
		buildShoppingList();
		buildVerbs();
		buildQuestions();
		buildFollowUps();
		buildTopics();
		buildCuteAnimals();
	}
	
	/**
	 * Builds the followUps array.
	 */
	private void buildFollowUps()
	{
		followUps = new String[] { "Food is tasty.", "Video games are fun.", "I am really tired.", "I am lazy." };
	}

	/**
	 * Builds the topics array.
	 */
	private void buildTopics()
	{
		topics = new String[] { "math", "video games", "food", "anime", "work" };
	}

	/**
	 * Builds the verbs array.
	 */
	private void buildVerbs()
	{
		verbs = new String[] { "like", "dislike", "am ambivalent about", "am thinking about" };
	}

	/**
	 * Builds the movieList.
	 */
	private void buildMovieList()
	{
		movieList = new ArrayList<Movie>(Arrays.asList(new Movie("Back to the Future"), new Movie("The Princess Bride"), new Movie("Spirited Away"), new Movie("Ferris Bueller's Day Off"),
				new Movie("Space Balls"), new Movie("Monty Python and the Quest for the Holy Grail"), new Movie("Spiderman"), new Movie("Hidden Figures"),
				new Movie("Journey to the Edge of the Universe", "Documentary"), new Movie("Jigsaw", "Thriller")));
	}

	/**
	 * Builds the shoppingList.
	 */
	private void buildShoppingList()
	{
		shoppingList = new ArrayList<String>(Arrays.asList("eggs", "hot peppers", "onions", "bagel", "crunchy peanut butter", "hot sauce", "juice", "snacks", "veggies", "protein", "red cream soda",
				"ice cream", "potato chips", "pringles", "candy", "donuts", "cake", "gum"));
	}

	/**
	 * Builds the cuteAnimalMemes list.
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes = new ArrayList<String>(Arrays.asList("otter", "pupper", "kittie", "floofer"));
	}

	/**
	 * Creates the questions array that will be used for the chatbot's responses.
	 */
	private void buildQuestions()
	{
		questions = new String[] { "What is your name?", "What are your favorite hobbies?", "What is your social security number?", "What is your favorite color?", "Why?", "What is your least favorite emotion?",
				"What is your job?", "Am I frustrating?", "Do you sleep?", "What is your favorite movie?" };
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
		currentTime = LocalTime.now();
		String chatbotResponse = currentTime.getHour() + ":" + currentTime.getMinute() + " " + "You said:" + "\n" + input + "\n";
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
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!" + "\n";
		}
		int followup = (int) (Math.random() * 5);
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
			break;
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		return response;
	}

	/**
	 * Checks the length of the users input to make sure it is valid.
	 * 
	 * @param input
	 *            The user's input.
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
	 * 
	 * @param input
	 *            HTML tag
	 * @return The validity of the HTML tag
	 */
	public boolean htmlTagChecker(String input)
	{
		if (!input.contains("<") || !input.contains(">"))
		{
			return false;
		}
		else if (input.contains("<>"))
		{
			return false;
		}
		else if (input.contains("< >"))
		{
			return false;
		}
		else if (input.toLowerCase().contains("<p>") || input.toLowerCase().contains("<br>"))
		{
			return true;
		}
		else if ((input.toLowerCase().contains("<a href=") && input.toLowerCase().contains("</a>")) && input.toLowerCase().indexOf("<a href=") < input.toLowerCase().indexOf("</a>"))
		{
			return true;
		}
		int firstOpenTag = input.indexOf("<");
		int firstCloseTag = input.indexOf(">");
		if (!(firstOpenTag < firstCloseTag))
		{
			return false;
		}
		if (input.indexOf("<", firstOpenTag + 1) == -1 || input.indexOf(">", firstCloseTag) + 1 == -1)
		{
			return false;
		}
		int secondOpenTag = input.indexOf("<", firstOpenTag + 1);
		int secondCloseTag = input.indexOf(">", firstCloseTag + 1);
		if (!(secondOpenTag < secondCloseTag))
		{
			return false;
		}
		if (!(firstCloseTag < secondOpenTag))
		{
			return false;
		}
		String firstInside = input.substring(firstOpenTag + 1, firstCloseTag);
		String secondInside = input.substring(secondOpenTag + 1, secondCloseTag);
		if (!secondInside.contains("/"))
		{
			return false;
		}
		if (firstInside.toLowerCase().equals(secondInside.substring(1, secondInside.length()).toLowerCase()))
		{
			return true;
		}
		return false;
	}

	/**
	 * Checks the validity of the user's username.
	 * 
	 * @param input
	 *            The user's username.
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
	 * 
	 * @param contentCheck
	 *            The user's input.
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
	 * 
	 * @param input
	 *            The user's input.
	 * @return Whether or not the user's input contains a cute animal meme.
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		for (String meme : cuteAnimalMemes)
		{
			if (input.toLowerCase().contains(meme))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if an item on the shoppingList is anywhere in the user's input.
	 * 
	 * @param shoppingItem
	 *            The user's input.
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
	 * 
	 * @param title
	 *            The user's input.
	 * @return Whether or not the user's input contains a movie on the movieList.
	 */
	public boolean movieTitleChecker(String title)
	{
		for (Movie movieTitle : movieList)
		{
			if (title.toLowerCase().contains(movieTitle.getTitle().toLowerCase()))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a movie genre on the movieList appears anywhere in the user's input.
	 * 
	 * @param genre
	 *            The user's input.
	 * @return Whether or not the user's input contains a movie genre on the movieList.
	 */
	public boolean movieGenreChecker(String genre)
	{
		for (Movie movieGenre : movieList)
		{
			if (genre.toLowerCase().contains(movieGenre.getGenre().toLowerCase()))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the user wants to stop chatting.
	 * 
	 * @param exitString
	 *            The user's input.
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
	 * 
	 * @param sample
	 *            The user's input.
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
	 * @param username
	 *            new username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @param content
	 *            new content
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
