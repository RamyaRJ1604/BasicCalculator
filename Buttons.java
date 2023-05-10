import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

public class Buttons extends JButton {

    Color numFColor = Color.decode("#FFFFFF");
    Color funFColor = Color.decode("#FC6A03");
    Color numBColor = Color.decode("#333333");
    JButton[] numButtons;
    JButton[] funButtons;
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;

    Buttons() {
        numButtons = new JButton[10];
        funButtons = new JButton[8];

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        decButton = new JButton(".");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");

        funButtons[0] = addButton;
        funButtons[1] = subButton;
        funButtons[2] = mulButton;
        funButtons[3] = divButton;
        funButtons[4] = equButton;
        funButtons[5] = decButton;
        funButtons[6] = delButton;
        funButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            funButtons[i].setFont(new Font("Courier", Font.BOLD, 30));
            funButtons[i].setFocusable(false);
            funButtons[i].setBackground(numBColor);
            funButtons[i].setForeground(funFColor);
        }
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(new Font("Courier", Font.BOLD, 30));
            numButtons[i].setFocusable(false);
            numButtons[i].setForeground(numFColor);
            numButtons[i].setBackground(numBColor);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

    }

}
