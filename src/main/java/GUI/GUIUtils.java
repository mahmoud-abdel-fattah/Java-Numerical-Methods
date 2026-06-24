package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIUtils {

    private static final Font myFont = new Font("Dialog",Font.PLAIN,15);
    private static final Color inputPanelColor = new Color(45,45,48);

    public static JTextField createTextField(int columns){
        JTextField textField = new JTextField(columns);
        textField.setFont(myFont);
        textField.putClientProperty("FlatLaf.style","focusWidth: 0");
        return textField;
    }

    public static JLabel createLabel(String text){
        JLabel label = new JLabel(text);
        label.setFont(myFont);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBackground(new Color(45,45,48));
        return label;
    }

    public static JButton createBtn(String text){
        JButton button = new JButton(text);
        button.setFont(myFont);
        button.setFocusable(false);
        return button;
    }

    public static JComboBox createComboBox(String[] selections){
        JComboBox comboBox = new JComboBox(selections);
        comboBox.setPreferredSize(new Dimension(170,30));
        comboBox.setFont(myFont);
        comboBox.setFocusable(false);
        return comboBox;
    }

    public static JPanel createInputBlock(JLabel label, JComponent field){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(inputPanelColor);
        panel.add(label,BorderLayout.NORTH);
        panel.add(field,BorderLayout.SOUTH);
        return panel;
    }
    public static JPanel createCardPanel(){
        JPanel panel = new JPanel();
        panel.putClientProperty("FlatLaf.style", "arc: 20");
        panel.setBackground(new Color(45,45,48));
        return panel;
    }
}