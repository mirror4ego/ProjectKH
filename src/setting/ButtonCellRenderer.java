package setting;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonCellRenderer extends AbstractCellEditor implements TableCellRenderer,TableCellEditor {
	private final JButton button;
	public ButtonCellRenderer(final JTable table, final DefaultTableModel model) {
		this.button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Point point = e.getPoint();
				System.out.println("작동");
				if (table.columnAtPoint(point) == 4) {
					fireEditingStopped();
					int row = table.rowAtPoint(point);
					if (row >= 0) {
						model.removeRow(row);
					}

				}

				//table.setBackground(Color.getColor("F0F0F0"));
				//table.setGridColor(new Color(255,1,1,0));
				table.repaint();
			}
		});
	}
	public Component getTableCellRendererComponent(JTable table,
			Object value,
			boolean isSelected,
			boolean hasFocus,
			int row,
			int column) {
		return button;
	}
	public Component getTableCellEditorComponent(JTable table,
			Object value,
			boolean isSelected,
			int row,
			int column) {
		return button;
	}
	public Object getCellEditorValue() {
		return button.getText();
	}
}
