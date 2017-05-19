package setting;

import java.awt.Font;

import javax.swing.UIManager;

public class SetUiFont {
	
	public SetUiFont() {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			Font f = new javax.swing.plaf.FontUIResource("맑은 고딕", Font.PLAIN, 12);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
			
		}
	}
	
	public SetUiFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}
}
