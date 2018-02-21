package chat.view;

import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton searchButton;
	private JButton tweetButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	
	/**
	 * The constructor, sets all of the values and sets up the Panel.
	 * @param appController The ChatbotController used by the program.
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		chatButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		loadButton = new JButton("load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		saveButton = new JButton("save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		searchButton = new JButton("search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		tweetButton = new JButton("tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweet.png")));
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		checkerButton = new JButton("check");
		infoLabel = new JLabel();
		chatScrollPane = new JScrollPane();
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Adds all of the necessary attributes to the chatScrollPane.
	 */
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * Adds all of the components and sets some values in the Panel.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(searchButton);
		this.add(tweetButton);
		this.add(inputField);
		this.add(checkerButton);
		this.add(infoLabel);
		this.add(chatScrollPane);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setText("Type here to speak to chatbot");
		chatArea.setEditable(false);
		chatArea.setEnabled(false);
	}
	
	/**
	 * Moves all of the components to their proper spots.
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, 0, SpringLayout.WEST, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.SOUTH, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, checkerButton);
		appLayout.putConstraint(SpringLayout.EAST, inputField, 0, SpringLayout.WEST, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, -100, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.SOUTH, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 0, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.SOUTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 0, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, loadButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.SOUTH, loadButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 20, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -60, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, infoLabel, 0, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 20, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -60, SpringLayout.SOUTH, this);
	}
	
	/**
	 * Sets up all of the Listeners for the components.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		inputField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
		});
	}
}
