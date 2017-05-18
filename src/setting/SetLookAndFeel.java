package setting;

import javax.swing.UIManager;

public class SetLookAndFeel {
	public SetLookAndFeel(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception exc){}
	}
}
