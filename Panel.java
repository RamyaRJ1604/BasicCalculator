import javax.swing.JPanel;

import java.awt.GridLayout;

public class Panel extends JPanel {

	Buttons buttons = new Buttons();

	Panel() {
		setBounds(50, 100, 300, 300);
		setLayout(new GridLayout(4, 4, 10, 10));

		add(buttons.numButtons[1]);
		add(buttons.numButtons[2]);
		add(buttons.numButtons[3]);
		add(buttons.addButton);

		add(buttons.numButtons[4]);
		add(buttons.numButtons[5]);
		add(buttons.numButtons[6]);
		add(buttons.subButton);

		add(buttons.numButtons[7]);
		add(buttons.numButtons[8]);
		add(buttons.numButtons[9]);
		add(buttons.mulButton);

		add(buttons.decButton);
		add(buttons.numButtons[0]);
		add(buttons.equButton);
		add(buttons.divButton);
	}

}
