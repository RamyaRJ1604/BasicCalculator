import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class TextField extends JTextField {
    TextField() {
        setBounds(50, 25, 300, 50);
        setFont(new Font("Courier", Font.BOLD, 30));
        setEditable(false);
        setHorizontalAlignment(SwingConstants.RIGHT);
        setBorder(new LineBorder(Color.BLACK, 2));
    }
}
