import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame {
    private JPanel panel;
    private JPanel panelb;
    private JLabel label;
    private JButton admin;
    private JButton user;
    private JButton exit;
    private final int WINDOW_WIDTH =350;
    private final int WINDOW_HEIGHT = 250;

    MainMenuGUI(){
        setTitle("Welcome to TicketMiner");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        label = new JLabel("Are you a(n) Admin or a User? \n");
        admin = new JButton("Admin");
        user = new JButton("User");
        exit = new JButton("Exit");
        add(admin);
        add(user);
        add(exit);
        admin.addActionListener(new adminListener());
        user.addActionListener(new userListener());
        exit.addActionListener(new exitListener());
        panel = new JPanel();
        panelb = new JPanel();
        panel.add(label);
        panelb.add(admin);
        panelb.add(user);
        panelb.add(exit);
        add(panel);
        add(panelb);
        setVisible(true);
    }
    private class adminListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            new AdminPanelGUI();
        }
    }
    private class userListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new UserPanel();
        }
    }
    private class exitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}
