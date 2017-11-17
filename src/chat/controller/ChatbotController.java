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
		String response = display.getResponse("What do you want to talk about?");
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.getResponse(response);
//		}
	}
	
	/**
	 * Does basic chatbot communication through popups.
	 * @param chat The user's input.
	 * @return The chatbot's response.
	 */
	private String popupChat(String chat)
	{
		return chatbot.processConversation(chat);
	}
	
	/**
	 * Does chatbot communication through the GUI.
	 * @param input The user's input.
	 * @return The chatbot's response.
	 */
	public String interactWithChatbot(String input)
	{
		return "";
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
