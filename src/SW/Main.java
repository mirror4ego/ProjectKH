package SW;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JFrame;

import Person.Employee;

public class Main {
	public static JFrame mainFrame;
	public static void main(String[] args) {
		mainFrame = new GUI.MainFrame();
		HRSW.initLogFile();
	}
}