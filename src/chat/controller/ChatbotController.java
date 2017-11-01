package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.getResponse("What do you want to talk about?");
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.getResponse(response);
		}
	}
	
	private String popupChat(String chat)
	{
		return chatbot.processConversation(chat);
	}
}
