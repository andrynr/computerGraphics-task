import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class exercise25 extends Frame implements ActionListener {
    private int x; // x-coordinate of the heart
    private int y; // y-coordinate of the heart
    private int width = 50; // Width of the heart
    private int height = 50; // Height of the heart
    private boolean expanding = true; // Flag to indicate if heart is expanding or contracting
    private Timer timer;
    private int lineY; // y-coordinate of the line

    exercise25() {
        addWindowListener(new MyFinishWindow());
        timer = new Timer(50, this); // 50 milliseconds delay between updates
        timer.start();

        // Calculate initial position to place the heart in the center of the window
        x = 100; // Center horizontally
        y = 100; // Center vertically
        lineY = this.getHeight() / 2; // Set the line in the middle of the window vertically
    }

    public void actionPerformed(ActionEvent e) {
        // Move the heart along the line
        x++;
        if (x > getWidth() + width) {
            x = -width; // Reset the x-coordinate when heart goes out of window
        }

        // Update lineY to stay in the middle of the window vertically
        lineY = this.getHeight() / 2;

        // Toggle the expansion/contraction of the heart
        if (expanding) {
            width++;
            height++;
            lineY++;
        } else {
            width--;
            height--;
            lineY--;
        }

        // Change the flag when heart reaches maximum size or minimum size
        if (width >= 70 || width <= 30) {
            expanding = !expanding;
        }

        repaint(); // Trigger repaint to update the animation
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the heart
        g2d.setColor(Color.BLACK);
        g2d.fillArc(x, y, width / 2, height / 2, 0, 180);
        g2d.fillArc(x + width / 2, y, width / 2, height / 2, 0, 180);
        g2d.fillRect(x, y + height / 4, width, height / 4);

        // Draw the triangle (bottom part of the heart)
        int[] xPoints = { x, x + width / 2, x + width };
        int[] yPoints = { y + height / 2, y + height, y + height / 2 };
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Draw the line
        g2d.setColor(Color.RED);
        g2d.drawLine(0, lineY, getWidth(), lineY);
    }

    public static void main(String[] argv) {
        exercise25 f = new exercise25();
        f.setTitle("Beating Heart Animation");
        f.setSize(500, 300);
        f.setLocationRelativeTo(null); // Place the frame in the center of the screen
        f.setVisible(true);
    }
}
