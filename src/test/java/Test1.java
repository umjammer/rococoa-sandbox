/*
 * Copyright (c) 2021 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

import java.awt.Dimension;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * System Tray (not work)
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (umjammer)
 * @version 0.00 2021/10/30 umjammer initial version <br>
 */
public class Test1 {

    /** */
    public static void main(String[] args) throws Exception {
        SystemTray.getSystemTray().add(new TrayIcon(Toolkit.getDefaultToolkit().getImage("duke.png")));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(640, 480));

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

/* */
