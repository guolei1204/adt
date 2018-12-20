package com.thread.test;

import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame {
    private JPanel panel;
    private JButton yellowButton;
    private JButton blueButton;
    private JButton redButton;


    public ButtonFrame() throws HeadlessException {
        setSize(300, 400);
        panel = new JPanel();
        add(panel);
        yellowButton = new JButton("yellow");
        blueButton = new JButton("blue");
        redButton = new JButton("red");
        panel.add(yellowButton);
        panel.add(blueButton);
        panel.add(redButton);
        ActionListenerInstaller.processAnnotitions(this);
    }

    @ActionListenerFor(source = "yellowButton")
    public void yellowBackGround() {
        panel.setBackground(Color.YELLOW);
    }

    @ActionListenerFor(source = "blueButton")
    public void blueBackGround() {
        panel.setBackground(Color.BLUE);
    }

    @ActionListenerFor(source = "redButton")
    public void redBackGround() {
        panel.setBackground(Color.RED);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ButtonFrame f = new ButtonFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}
