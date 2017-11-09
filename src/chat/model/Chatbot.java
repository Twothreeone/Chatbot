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

	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.username = username;
		this.content = "content";
		this.intro = "";
		this.topics = new String[5];
		this.verbs = new String[4];
		this.followUps = new String[0];
		buildMovieList();
		buildShoppingList();
		buildVerbs();
		buildQuestions();
		// buildFollowups();
		buildTopics();
	}

	private void buildTopics()
	{
		topics[0] = "math";
		topics[1] = "video games";
		topics[2] = "food";
		topics[3] = "anime";
		topics[4] = "work";
	}

	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
		movieList.add(new Movie("Back to the Future"));
		movieList.add(new Movie("The Princess Bride"));
		movieList.add(new Movie("Spirited Away"));
		movieList.add(new Movie("Ferris Bueller's Day Off"));
		movieList.add(new Movie("Space Balls"));
		movieList.add(new Movie("Monty Python and the Quest for the Holy Grail"));
	}

	/**
	 * Creates the shoppingList ArrayList that will be used for the chatbot's responses.
	 */
	private void buildShoppingList()
	{
		shoppingList = new ArrayList<String>(Arrays.asList("snacks", "veggies", "protein", "red cream soda", "ice cream", "potato chips", "pringles", "candy", "donuts", "cake", "gum"));
	}

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

	public boolean lengthChecker(String input)
	{
		boolean properLength = false;
		if (input != null && input.length() >= 2)
		{
			properLength = true;
		}
		return properLength;
	}

	public boolean htmlTagChecker(String input)
	{
		return false;
	}

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

	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}

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

	public boolean movieTitleChecker(String title)
	{
		return false;
	}

	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

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

	public String toString()
	{
		return "";
	}

	public List<Movie> getMovieList()
	{
		return movieList;
	}

	public List<String> getShoppingList()
	{
		return shoppingList;
	}

	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String[] getQuestions()
	{
		return questions;
	}

	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}

	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}

	public LocalTime getCurrentTime()
	{
		return currentTime;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}
