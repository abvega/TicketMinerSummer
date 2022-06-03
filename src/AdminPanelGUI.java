import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanelGUI extends JFrame{
    private final int WINDOW_WIDTH =350;
    private final int WINDOW_HEIGHT =350;

    AdminPanelGUI(){
        JPanel panel;
        JPanel panelb;
        JLabel label;
        JButton buttona;
        JButton buttonb;
        JButton buttonc;
        JButton exit;
        setTitle("Administrator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        label = new JLabel("What would you like to do?");
        buttona = new JButton("Create new");
        buttonb = new JButton("Inquire event");
        buttonc = new JButton("Modify event");
        exit = new JButton("Exit");
        buttona.addActionListener(new buttonaListener());
        buttonb.addActionListener(new buttonbListener());
        buttonc.addActionListener(new buttoncListener());
        exit.addActionListener(new exitListener());
        panel = new JPanel();
        panelb = new JPanel();
        panel.add(label);
        panelb.add(buttona);
        panelb.add(buttonb);
        panelb.add(buttonc);
        panelb.add(exit);
        add(panel);
        add(panelb);
        setVisible(true);
    }
    private class buttonaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JPanel panel;
            JLabel label;
            setTitle("Create new");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            label = new JLabel("Please fill in the information for the event");
            panel = new JPanel();
            panel.add(label);

            setVisible(true);
        }
    }
    private class buttonbListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private class buttoncListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }
    private class exitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}
