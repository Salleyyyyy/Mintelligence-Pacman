package mintelligence.workshop.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import mintelligence.workshop.editor.MapEditor;

public class StartWindow extends JFrame {

    public StartWindow(){
        setSize(600,300);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon();
        try {
            logo = new ImageIcon(ImageIO.read(this.getClass().getResource("/resources/images/pacman_logo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Register Custom fonts
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/resources/fonts/crackman.ttf")));
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        getContentPane().add(new JLabel(logo),BorderLayout.NORTH);

        JPanel buttonsC = new JPanel();
        buttonsC.setBackground(Color.black);
        //buttonsC.setLayout(new FlowLayout(FlowLayout.LEADING,20,10));
        buttonsC.setLayout(new BoxLayout(buttonsC,BoxLayout.Y_AXIS));
        FansyButton startButton = new FansyButton("Start Game");
        FansyButton customButton = new FansyButton("Customize Game");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        customButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacWindow pw = new PacWindow();
                //new PacWindow();
                dispose();
            }
        });

        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapEditor me = new MapEditor();
                dispose();
            }
        });

        buttonsC.add(startButton);
        buttonsC.add(customButton);

        getContentPane().add(buttonsC);

        System.out.print('\n');
        System.out.println("PacMan v1.0   Developed By : Armin Kazemi");
        System.out.println("-----------------------------------------");
        setVisible(true);
    }
}
