import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class exercise22dan24 extends Frame implements ActionListener {
    private int sunX; // x-coordinate of the sun
    private int sunY; // y-coordinate of the sun
    private int planetRadius = 20;
    private int orbitRadius = 150;
    private int angle = 0;
    private Color dayColor = Color.BLUE;
    private Color nightColor = Color.BLACK;
    private Timer timer;

    exercise22dan24() {
        addWindowListener(new MyFinishWindow());
        timer = new Timer(50, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        angle++;
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // Get the width and height of the window
        int width = getWidth();
        int height = getHeight();

        // Calculate the center of the window
        sunX = width / 2;
        sunY = height / 2;

        // Draw the sun
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(sunX - 20, sunY - 20, 60, 60);

        // Calculate planet's position
        double planetX = sunX + orbitRadius * Math.cos(Math.toRadians(angle));
        double planetY = sunY + orbitRadius * Math.sin(Math.toRadians(angle));

        // Determine the interpolation factor for color transition
        double interpFactor = (planetY - (sunY - orbitRadius)) / (2 * orbitRadius);

        // Calculate the intermediate color
        Color currentColor = new Color(
                (int) (dayColor.getRed() * interpFactor + nightColor.getRed() * (1 - interpFactor)),
                (int) (dayColor.getGreen() * interpFactor + nightColor.getGreen() * (1 - interpFactor)),
                (int) (dayColor.getBlue() * interpFactor + nightColor.getBlue() * (1 - interpFactor))
        );

        // Set planet color accordingly
        g2d.setColor(currentColor);

        // Draw the planet
        g2d.fillOval((int) (planetX - planetRadius), (int) (planetY - planetRadius), 2 * planetRadius,
                2 * planetRadius);
    }

    public static void main(String[] argv) {
        exercise22dan24 f = new exercise22dan24();
        f.setTitle("Orbit System");
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
