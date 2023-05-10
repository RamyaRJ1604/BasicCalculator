import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

    Color bgColor = Color.decode("#D9D9D9");
    TextField textField = new TextField();
    Panel panel = new Panel();
    Buttons buttons = new Buttons();
    ImageIcon icon = new ImageIcon("icon.png");

    BigDecimal num1, num2, result;
    char operator;
    boolean decimalAdded = false;

    Frame() {
        setTitle("Calculator");
        setSize(420, 550);
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setBackground(bgColor);
        setIconImage(icon.getImage());

        add(textField);
        add(buttons.delButton);
        add(buttons.clrButton);
        add(panel);
        setVisible(true);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    if (e.getSource() == panel.buttons.numButtons[i]) {
                        textField.setText(textField.getText().concat(String.valueOf(i)));
                    }
                }

                if (e.getSource() == panel.buttons.addButton) {
                    num1 = new BigDecimal(textField.getText());
                    operator = '+';
                    textField.setText("");
                }

                if (e.getSource() == panel.buttons.subButton) {
                    num1 = new BigDecimal(textField.getText());
                    operator = '-';
                    textField.setText("");
                }

                if (e.getSource() == panel.buttons.mulButton) {
                    num1 = new BigDecimal(textField.getText());
                    operator = '*';
                    textField.setText("");
                }

                if (e.getSource() == panel.buttons.divButton) {
                    num1 = new BigDecimal(textField.getText());
                    operator = '/';
                    textField.setText("");
                }

                if (e.getSource() == buttons.clrButton) {
                    textField.setText("");
                }

                if (e.getSource() == buttons.delButton) {
                    String string = textField.getText();
                    textField.setText(string.substring(0, string.length() - 1));
                }

                if (e.getSource() == panel.buttons.decButton) {
                    if (textField.getText().indexOf(".") == -1) {
                        textField.setText(textField.getText().concat("."));
                    }
                }

                if (e.getSource() == panel.buttons.equButton) {
                    num2 = new BigDecimal(textField.getText());

                    switch (operator) {
                        case '+':
                            result = num1.add(num2);
                            break;
                        case '-':
                            result = num1.subtract(num2);
                            break;
                        case '*':
                            result = num1.multiply(num2);
                            break;
                        case '/':
                            if (num2.equals(BigDecimal.ZERO)) {
                                textField.setText("Division by zero");
                                result = null;
                            } else {
                                result = num1.divide(num2, 10, RoundingMode.HALF_UP);
                            }
                            break;
                    }
                    if (result != null) {
                        textField.setText(result.toString());
                        num1 = result;
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            panel.buttons.numButtons[i].addActionListener(listener);
        }
        for (int i = 0; i < 6; i++) {
            panel.buttons.funButtons[i].addActionListener(listener);
        }
        buttons.delButton.addActionListener(listener);
        buttons.clrButton.addActionListener(listener);
    }

}
