package de.frankp.game.ui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;

public class MainPanel extends JPanel {
	public MainPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "2, 2, fill, default");
		
		JComboBox comboBox_3 = new JComboBox();
		add(comboBox_3, "4, 2, fill, default");
		
		JComboBox comboBox_2 = new JComboBox();
		add(comboBox_2, "6, 2, fill, default");
		
		JComboBox comboBox_1 = new JComboBox();
		add(comboBox_1, "8, 2, fill, default");
	}

}
