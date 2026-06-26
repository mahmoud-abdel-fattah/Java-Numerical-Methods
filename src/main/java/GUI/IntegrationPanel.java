package GUI;

import Integration.Integrate;
import Integration.RectangleType;

import javax.swing.*;
import java.awt.*;


public class IntegrationPanel extends JPanel {

    private static final int MAX_SUBINTERVAL = 1000000;

    public IntegrationPanel(){
        // Methods Box
        JLabel methodsLabel = GUIUtils.createLabel("Method");
        JComboBox<IntEnum> methodsBox = new JComboBox<>(IntEnum.values());

        // Labels
        JLabel functionLabel = GUIUtils.createLabel("Function");
        JLabel startLabel = GUIUtils.createLabel("Start");
        JLabel endLabel = GUIUtils.createLabel("End");
        JLabel subintervalLabel = GUIUtils.createLabel("Subinterval");
        JLabel resultLabel = GUIUtils.createLabel("Result");

        // Text Fields
        JTextField functionField = GUIUtils.createTextField(15);
        JTextField startField = GUIUtils.createTextField(15);
        JTextField endField = GUIUtils.createTextField(15);
        JTextField subintervalField = GUIUtils.createTextField(15);
        JTextField resultField = GUIUtils.createTextField(15);

        // Button
        JButton calculateBtn = GUIUtils.createBtn("Calculate");
        calculateBtn.addActionListener(e -> {
            String function = functionField.getText();
            String start = startField.getText();
            String end = endField.getText();

            try{
                int subinterval = Integer.parseInt(subintervalField.getText());

                checkSubintervalLimit(subinterval);

                double result = evaluate((IntEnum) methodsBox.getSelectedItem(),function,start,end,subinterval);
                resultField.setText(String.valueOf(result));

            } catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.ERROR_MESSAGE);
                resultField.setText("");
            } catch (IllegalArgumentException exception2){
                JOptionPane.showMessageDialog(null,exception2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                resultField.setText("");
            }


        });

        // Upper Card Panels
        JPanel methodsPanel = GUIUtils.createInputBlock(methodsLabel,methodsBox);
        JPanel functionPanel = GUIUtils.createInputBlock(functionLabel,functionField);
        JPanel startPanel = GUIUtils.createInputBlock(startLabel,startField);
        JPanel endPanel = GUIUtils.createInputBlock(endLabel,endField);
        JPanel subintervalPanel = GUIUtils.createInputBlock(subintervalLabel,subintervalField);

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT,25, 0));
        row1.setOpaque(false);
        row1.add(methodsPanel);


        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 25,0));
        row2.setOpaque(false);
        row2.add(functionPanel);
        row2.add(startPanel);

        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 25,0));
        row3.setOpaque(false);
        row3.add(endPanel);
        row3.add(subintervalPanel);

        JPanel upperCardLeft = new JPanel();
        upperCardLeft.setLayout(new GridLayout(3,2));
        upperCardLeft.setOpaque(false);
        upperCardLeft.add(row1);
        upperCardLeft.add(row2);
        upperCardLeft.add(row3);


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
        resultField.setEditable(false);

        // Lower Card
        JPanel dataPanel = GUIUtils.createCardPanel();

        dataPanel.add(resultPanel);


        // Main
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.setLayout(new GridLayout(2,1,20,20));
        this.add(inputPanel);
        this.add(dataPanel);


    }
    public double evaluate(IntEnum item,String function, String a, String b, int n){
        double result;
        return switch (item){
            case IntEnum.SIMPSON -> result = Integrate.simpson(function,a,b,n);
            case IntEnum.TRAPEZOIDAL  -> result = Integrate.trapezoidal(function,a,b,n);
            case IntEnum.LEFT  -> result = Integrate.rectangle(function,a,b,n, RectangleType.LEFT);
            case IntEnum.RIGHT  -> result = Integrate.rectangle(function,a,b,n, RectangleType.RIGHT);
            //case IntEnum.SIMPSON  -> result = Integrate.leftRectangular(function,a,b,n);
            //case IntEnum.SIMPSON  -> result = Integrate.rightRectangular(function,a,b,n);
            default -> throw new IllegalArgumentException("Unknown Method");
        };
    }
    public void checkSubintervalLimit(int n){
        if (n > MAX_SUBINTERVAL){
            throw new IllegalArgumentException("Max Subinterval is 1,000,000");
        }
    }


}