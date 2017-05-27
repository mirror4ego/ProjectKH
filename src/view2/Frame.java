package view2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Frame {
	public static void main(String[] args){
	JFrame modifyFrame = new JFrame("분류명 변경");
	modifyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	modifyFrame.setSize(270,85);
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension dimension1 = toolkit.getScreenSize();
	Dimension dimension2 = modifyFrame.getSize();
	modifyFrame.setLocation((int)(dimension1.getWidth() / 2 - dimension2.getWidth() / 2), 
			(int)(dimension1.getHeight() / 2 - dimension2.getHeight() / 2));
	modifyFrame.setResizable(false);
	modifyFrame.getContentPane().setLayout(null);
	JTextField textField;
	textField = new JTextField();
	textField.setBounds(68, 14, 116, 25);
	modifyFrame.getContentPane().add(textField);
	textField.setColumns(10);
	
	JButton btnNewButton = new JButton("변경");
	btnNewButton.setBounds(196, 14, 57, 25);
	modifyFrame.getContentPane().add(btnNewButton);
	
	JLabel label = new JLabel("분류명");
	label.setBounds(13, 14, 57, 25);
	modifyFrame.getContentPane().add(label);
	modifyFrame.setVisible(true);
	}
}
