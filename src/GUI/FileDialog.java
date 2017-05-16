package GUI;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileDialog extends JFrame{
	JFileChooser fileChooser = new JFileChooser();
	
	public String openFile() {
		int result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			return selectedFile.toString();
		}
		else
			return null;
	}
	public String saveFile() {
		int result = fileChooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			return selectedFile.toString();
		}
		else
			return null;
	}
}
