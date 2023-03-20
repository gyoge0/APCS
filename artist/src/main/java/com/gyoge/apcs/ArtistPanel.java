// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ArtistPanel extends JPanel {

    private final BufferedImage myImage;

    public ArtistPanel(BufferedImage b) {
        myImage = b;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }
}
