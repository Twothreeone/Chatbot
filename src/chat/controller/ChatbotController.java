package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;

public class ChatbotController
{
	Chatbot chatbot;
	PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		display.displayMessage("words");
		display.getResponse("question");
	}
}
