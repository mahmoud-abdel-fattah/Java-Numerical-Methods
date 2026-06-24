package GUI;

import Integration.Integrate;
import Integration.Integrator;

import javax.swing.*;
import java.awt.*;



public class IntegrationPanel extends JPanel {

    private static final int MAX_SUBINTERVAL = 1000000;




    public IntegrationPanel(){
        // Methods Box
        JLabel methodsLabel = GUIUtils.createLabel("Method");
        String[] methods = {"Simpson 1/3", "Trapezoidal", "Romberg Integration", "Gauss Quadrature", "Left Rectangular", "Right Rectangular"};
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

                double result = evaluate(methodsBox.getSelectedIndex(),function,start,end,subinterval);
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
        resultField.setEnabled(false);

        // Lower Card
        JPanel dataPanel = GUIUtils.createCardPanel();

        dataPanel.add(resultPanel);


        // Main
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.setLayout(new GridLayout(2,1,20,20));
        this.add(inputPanel);
        this.add(dataPanel);


    }
    // TODO: Replace with Enums
    public double evaluate(int index,String function, String a, String b, int n){
        double result;
        return switch (index){
            case 0 -> result = Integrate.simpson(function,a,b,n);
            //case 1 -> result = Integrate.trapezoidal(function,a,b,n);
            //case 2 -> result = Integrate.romberg(function,a,b,n);
            //case 3 -> result = Integrate.gauss(function,a,b,n);
            //case 4 -> result = Integrate.leftRectangular(function,a,b,n);
            //case 5 -> result = Integrate.rightRectangular(function,a,b,n);
            default -> throw new IllegalArgumentException("Unknown Method");
        };
    }
    public void checkSubintervalLimit(int n){
        if (n > MAX_SUBINTERVAL){
            throw new IllegalArgumentException("Max Subinterval is 1,000,000");
        }
    }


}