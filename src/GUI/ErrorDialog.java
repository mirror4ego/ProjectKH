package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ErrorDialog extends JDialog{
	JPanel MainPanel = new JPanel();
	JPanel TopPanel = new JPanel();
	JPanel BottomPanel = new JPanel();
	
	JLabel label;
	JButton button = new JButton("확인");
	
	public ErrorDialog(JFrame frame, String msg) {
		super(frame, msg, true);
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2 - 120, (screenSize.height - frameSize.height)/2 - 120);
		
		setTitle("Error!");
		add(MainPanel);
		MainPanel.add(TopPanel);
		MainPanel.add(BottomPanel);
		
		TopPanel.add(label = new JLabel(msg, SwingConstants.CENTER));
		button.addActionListener(new ButtonListener());
		BottomPanel.add(button);
		
		setSize(250, 120);
		setResizable(false);
		setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
}
