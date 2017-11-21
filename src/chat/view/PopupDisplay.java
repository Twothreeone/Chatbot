package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	/**
	 * The constructor, sets all of the values for the popups.
	 */
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/Triforce.gif"));
		windowTitle = "Chatbot says";
	}
	
	/**
	 * Displays a message in a popup.
	 * @param messageToDisplay The desired message to display.
	 */
	public void displayMessage(String messageToDisplay)
	{
		JOptionPane.showMessageDialog(null, messageToDisplay, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	/**
	 * Displays a prompt requesting a response from the user in a popup.
	 * @param prompt The desired prompt to show.
	 * @return The users response to the prompt.
	 */
	public String getResponse(String prompt)
	{
		String answer = "";
		answer += JOptionPane.showInputDialog(null, prompt, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		return answer;
	}
}
