package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	/**
	 * Constructor for the ChatbotController. Initializes data members.
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * This is called by the ChatRunner to start the program. 
	 */
	public void start()
	{
		display.displayMessage("Welcome to Chatbot");
	}
	
	/**
	 * Does chatbot communication through the GUI.
	 * @param input The user's input.
	 * @return The chatbot's response.
	 */
	public String interactWithChatbot(String input)
	{
		if(chatbot.quitChecker(input))
		{
			close();
		}
		return chatbot.processConversation(input);
	}
	
	/**
	 * Runs all of the relevant checkers on the users inputed response.
	 * @param text What the user typed.
	 * @return What the chatbot will respond with.
	 */
	public String useCheckers(String text)
	{
		String response = "";
		if (chatbot.contentChecker(text))
		{
			
		}
		if (chatbot.cuteAnimalMemeChecker(text))
		{
			
		}
		if (chatbot.htmlTagChecker(text))
		{
			
		}
		if (chatbot.keyboardMashChecker(text))
		{
			
		}
		if (chatbot.movieTitleChecker(text))
		{
			
		}
		if (chatbot.movieGenreChecker(text))
		{
			
		}
		if (chatbot.shoppingListChecker(text))
		{
			
		}
		if (chatbot.userNameChecker(text))
		{
			
		}
		return response;
	}
	
	/**
	 * Closes the program.
	 */
	private void close()
	{
		display.displayMessage("Goodbye");
		System.exit(0);
	}
	
	public void HandleErrors(Exception error)
	{
		display.displayMessage(error.getMessage());
	}
	
	/**
	 * @return chatbot
	 */
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	
	/**
	 * @return display
	 */
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	/**
	 * @return appFrame
	 */
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
}
