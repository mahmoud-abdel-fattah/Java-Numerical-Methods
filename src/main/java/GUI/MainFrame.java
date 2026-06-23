package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private final JFrame frame = new JFrame();
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final IntegrationPanel integrationPanel = new IntegrationPanel();
    private final DifferentiationPanel differentiationPanel = new DifferentiationPanel();
    private final RootFindingPanel rootFindingPanel = new RootFindingPanel();
    private final ApplicationsPanel applicationsPanel = new ApplicationsPanel();

    public MainFrame(){

        // Tabs
        tabbedPane.add(integrationPanel,"Integration");
        tabbedPane.add(differentiationPanel,"Differentiation");
        tabbedPane.add(rootFindingPanel,"Root Finding");
        tabbedPane.add(applicationsPanel,"Applications");
        tabbedPane.setFont(new Font("Dialog",Font.BOLD,16));
        tabbedPane.setFocusable(false);

        // Frame
        frame.setTitle("Numerical Methods");
        frame.setIconImage(new ImageIcon("src/main/resources/math-integrals.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,650);
        frame.setLayout(new BorderLayout());
        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}