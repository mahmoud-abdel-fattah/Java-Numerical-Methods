package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Ref;

public class IntegrationPanel extends JPanel {

    public IntegrationPanel(){
        // Methods Box
        JLabel methodsLabel = GUIUtils.createLabel("Method");
        String[] methods = {"Simpson 1/3", "Trapezoidal", "Romberg", "Gauss Quadrature", "Left Rectangular", "Right Rectangular"};
        JComboBox methodsBox = GUIUtils.createComboBox(methods);

        // Labels
        JLabel functionLabel = GUIUtils.createLabel("Function");
        JLabel startLabel = GUIUtils.createLabel("Start");
        JLabel endLabel = GUIUtils.createLabel("End");
        JLabel subintervalLabel = GUIUtils.createLabel("Subinterval");
        JLabel resultLabel = GUIUtils.createLabel("Result");

        // Text Fields
        JTextField functionField = GUIUtils.createTextField(15);
        JTextField startField = GUIUtils.createTextField(5);
        JTextField endField = GUIUtils.createTextField(5);
        JTextField subintervalField = GUIUtils.createTextField(5);
        JTextField resultField = GUIUtils.createTextField(5);

        // Button
        JButton calculateBtn = GUIUtils.createBtn("Calculate");

        // Upper Card Panels
        JPanel methodsPanel = GUIUtils.createInputBlock(methodsLabel,methodsBox);
        JPanel functionPanel = GUIUtils.createInputBlock(functionLabel,functionField);
        JPanel startPanel = GUIUtils.createInputBlock(startLabel,startField);
        JPanel endPanel = GUIUtils.createInputBlock(endLabel,endField);
        JPanel subintervalPanel = GUIUtils.createInputBlock(subintervalLabel,subintervalField);

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT,25, 0));
        row1.setOpaque(false);
        row1.add(methodsPanel);
        row1.add(functionPanel);


        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 25,0));
        row2.setOpaque(false);
        row2.add(startPanel);
        row2.add(endPanel);
        row2.add(subintervalPanel);

        JPanel upperCardLeft = new JPanel();
        upperCardLeft.setLayout(new BoxLayout(upperCardLeft,BoxLayout.Y_AXIS));
        upperCardLeft.setOpaque(false);
        upperCardLeft.add(row1);
        upperCardLeft.add(row2);

        JPanel upperCardRight = new JPanel(new BorderLayout());
        upperCardRight.setOpaque(false);
        upperCardRight.add(calculateBtn,BorderLayout.SOUTH);

        // Upper Card
        JPanel inputPanel = GUIUtils.createCardPanel();
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(upperCardLeft,BorderLayout.CENTER);
        inputPanel.add(upperCardRight,BorderLayout.EAST);


        // Lower Card Panels
        JPanel resultPanel = GUIUtils.createInputBlock(resultLabel, resultField);

        // Lower Card
        JPanel dataPanel = GUIUtils.createCardPanel();

        dataPanel.add(resultPanel);


        // Main
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.setLayout(new GridLayout(2,1,20,20));
        this.add(inputPanel);
        this.add(dataPanel);


    }
}