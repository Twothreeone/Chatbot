package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String[10];
		this.username = username;
		this.content = "";
		this.intro = "";
		this.topics = new String[5];
		this.verbs = new String[4];
		this.followUps = new String[0];
		buildMovieList();
		buildShoppingList();
		buildVerbs();
		buildQuestions();
//		buildFollowups();
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
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("red cream soda");
		shoppingList.add("ice cream");
		shoppingList.add("potato chips");
		shoppingList.add("pringles");
		shoppingList.add("candy");
		shoppingList.add("donuts");
		shoppingList.add("cake");
		shoppingList.add("gum");
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What are your favorite hobbies?";
		questions[2] = "How do you live?";
		questions[3] = "What is your favorite color?";
		questions[4] = "Why?";
		questions[5] = "What is your least favorite emotion?";
		questions[6] = "What is your job?";
		questions[7] = "Why are you so useless?";
		questions[8] = "Do you sleep?";
		questions[9] = "What is your favorite movie?";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "You said:" + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		random = (int) (Math.random() * questions.length);
		response += questions[random];
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
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
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
		String mash = "qwertyuiop[]asdfghjkl;'zxcvbnm,./.,mnbvcxz';lkjhgfdsa][poiuytrewq";
		for (int i = 0; i < mash.length() - 2; i++)
		{
			if (mash.substring(i, i + 3).equalsIgnoreCase(sample))
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

	public String [] getQuestions()
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
