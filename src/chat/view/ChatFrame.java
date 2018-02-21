package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPane;
	
	/**
	 * The constructor, it will set up the Frame and create the Panel.
	 * @param appController The ChatbotController used by the program.
	 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		setupFrame();
	}

	/**
	 * Sets up the frame for the GUI.
	 */
	private void setupFrame()
	{
		this.setContentPane(appPane);
		this.setTitle("Chatting with the Chatbot");
		this.setResizable(false);
		this.setSize(500, 290);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * @return appController
	 */
	public ChatbotController getBaseController()
	{
		return appController;
	}
}
