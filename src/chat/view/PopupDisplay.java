package chat.view;

import javax.swing.JOptionPane;

public class PopupDisplay
{
	public void displayMessage(String messageToDisplay)
	{
		JOptionPane.showMessageDialog(null, messageToDisplay);
	}
	
	public String getResponse(String prompt)
	{
		String answer = JOptionPane.showInputDialog(null, prompt);
		return answer;
	}
}
