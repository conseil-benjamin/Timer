import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public  class GUI implements ActionListener {

    float count = 0;
    private Timer t;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private ActionListener taskPerformer;

    public GUI(){

        frame = new JFrame();
        label = new JLabel();

        JButton button = new JButton("Click Me");
        button.addActionListener(this);
        JButton button1 = new JButton("Start Chrono");


        t = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t.isRunning()) {
                    t.start();
                    label.setText(String.valueOf(t));
                    button1.setText("Stop");
                } else {
                    t.stop();
                    button1.setText("Start");
                }
                label.setText(String.valueOf(t));
                System.out.println("Ok");
                label.setText("Number of clicks per second" + count/10);
            }
        });

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30 , 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(button1);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Professional Application");
        frame.pack();
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        count ++;
        label.setText("Number of clicks "+count);
    }

    public static void main(String[] args) {
       new GUI();
    }

}
