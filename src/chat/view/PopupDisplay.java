package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/Triforce.png"));
		windowTitle = "Chatbot says";
	}
	public void displayMessage(String messageToDisplay)
	{
		JOptionPane.showMessageDialog(null, messageToDisplay, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public String getResponse(String prompt)
	{
		String answer = "";
		answer += JOptionPane.showInputDialog(null, prompt, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		return answer;
	}
}
