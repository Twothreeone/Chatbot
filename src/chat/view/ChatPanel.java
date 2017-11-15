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
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEditable(false);
		chatArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 2, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -60, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 10, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -20, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		
	}
}
