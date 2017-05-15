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

public class SaveDialog extends JDialog{
	JPanel MainPanel = new JPanel();
	JPanel TopPanel = new JPanel();
	JPanel BottomPanel = new JPanel();
	
	JLabel label;
	JButton SaveAndTerminate = new JButton("저장 후 종료");
	JButton TerminateWithoutSave = new JButton("저장하지않고 종료");
	JButton cancel = new JButton("취소");
	
	public SaveDialog(JFrame frame, String msg) {
		super(frame, msg, true);
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2 - 180, (screenSize.height - frameSize.height)/2 - 80);
		
		setTitle("Warning!");
		add(MainPanel);
		MainPanel.add(TopPanel);
		MainPanel.add(BottomPanel);
		
		TopPanel.add(label = new JLabel(msg, SwingConstants.CENTER));
		SaveAndTerminate.addActionListener(new ButtonListener());
		TerminateWithoutSave.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		BottomPanel.add(SaveAndTerminate);
		BottomPanel.add(TerminateWithoutSave);
		BottomPanel.add(cancel);
		
		setSize(350, 130);
		setResizable(false);
		setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			if(source.equals(SaveAndTerminate)) {
				FileDialog FD = new FileDialog();
				String FileName = FD.saveFile();
				if(FileName == null)
					return;
				SW.HRSW.saveToFile(FileName);
				SW.HRSW.logging(FileName + "에 저장 후 종료");
				System.exit(0);
			}
			else if(source.equals(TerminateWithoutSave)) {
				SW.HRSW.logging("프로그램 종료");
				System.exit(0);
			}
			else if(source.equals(cancel))
				dispose();
		}
	}
}
