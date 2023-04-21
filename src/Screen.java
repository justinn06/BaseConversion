import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {
    private JPanel panelMain;
    private JTextField textBase2;
    private JButton buttonConvert;
    private JTextField textBase8;
    private JTextField textBase10;
    private JTextField textBase16;


    Screen() {
        super("Base Converter");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(600, 400);

        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = textBase2.getText();
                int n = Integer.parseInt(num);
                Number x = new Number(num,2);
                x.Convert();
                textBase8.setText(x.base8);
                textBase10.setText(String.valueOf(x.intBase10));
                textBase16.setText(x.base16);
            }
        });

    }

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.setVisible(true);
    }


}