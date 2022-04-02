import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class timer extends JFrame {

    private JPanel contentPane;
    Timer tm;
    int i = 0;
    float count = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    timer frame = new timer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public timer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 524, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);



        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                tm.start();

            }
        });

        btnStart.setBounds(29, 30, 90, 90);
        contentPane.add(btnStart);

        JButton buttonRestart = new JButton("Restart");
        buttonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               tm.restart();
            }
        });
        buttonRestart.setBounds(30, 120, 90, 90);
        contentPane.add(buttonRestart);

        JButton buttonStop = new JButton("Cliquez ici");
        JLabel label1 = new JLabel("Number of clicks");
        buttonStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                label1.setText("Number of clicks "+ count);
            }
        });
        buttonStop.setBounds(350, 80, 90, 90);
        contentPane.add(buttonStop);
        label1.setBounds(350, 200, 200, 50);
        contentPane.add(label1);


        JLabel label = new JLabel(".........");
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.setBounds(220, 73, 76, 50);
        contentPane.add(label);

        tm = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                label.setText(Integer.toString(i));
                i++;

                if (i == 10){
                    tm.stop();
                }

            }
        });

    }
}