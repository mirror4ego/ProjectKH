package setting;

import javax.swing.UIManager;
import com.jgoodies.looks.plastic.*;

public class SetLookAndFeel {
	public SetLookAndFeel(){
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel(newLookAndFeel);
		} catch (Exception exc){}
	}
}
