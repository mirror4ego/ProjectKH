package setting;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SetLookAndFeel {
	public SetLookAndFeel() {
		
		try {
			UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

			LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
			System.out.println(info[1]);
			System.out.println(info[2]);
			System.out.println(info[3]);
			System.out.println(info[4]);
			System.out.println(info[5]);
			System.out.println(info[6]);
			System.out.println(info[7]);
			System.out.println(info[8]);
		} catch (Exception exc){}
	}
}
