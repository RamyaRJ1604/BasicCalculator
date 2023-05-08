import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

    TextField textField = new TextField();
    Panel panel = new Panel();
    Buttons buttons = new Buttons();

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Frame() {
        setTitle("Calculator");
        setSize(420, 550);
        setLocationRelativeTo(null); // Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setBackground(Color.WHITE);

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
                    num1 = Double.parseDouble(textField.getText());
                    operator = '+';
                    textField.setText("");
                }

                if (e.getSource() == panel.buttons.subButton) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '-';
                    textField.setText("");
                }

                if (e.getSource() == panel.buttons.mulButton) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '*';
                    textField.setText("");
                }

                if (e.getSource() == panel.buttons.divButton) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '/';
                    textField.setText("");
                }

                if (e.getSource() == buttons.clrButton) {
                    textField.setText("");
                }

                if (e.getSource() == buttons.delButton) {
                    String string = textField.getText();
                    textField.setText("");
                    for (int i = 0; i < string.length() - 1; i++) {
                        textField.setText(textField.getText() + string.charAt(i));
                    }
                }

                if (e.getSource() == panel.buttons.decButton) {
                    textField.setText(textField.getText().concat("."));
                }

                if (e.getSource() == panel.buttons.equButton) {
                    num2 = Double.parseDouble(textField.getText());

                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            result = num1 / num2;
                            break;
                    }
                    textField.setText(String.valueOf(result));
                    num1 = result;
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
