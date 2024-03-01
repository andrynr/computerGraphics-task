import java.awt.*;
import java.awt.geom.*;

public class exercise21 extends Frame {

    exercise21() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        super.paint(g); // Memanggil paint dari kelas induk untuk menggambar frame
        Graphics2D g2d = (Graphics2D) g;

        // Use antialiasing for smoother lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set line thickness to 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // Draw car body
        RoundRectangle2D carBody = new RoundRectangle2D.Double(100, 100, 200, 80, 20, 20);
        g2d.setColor(Color.WHITE); // Set color to blue for the car body
        g2d.fill(carBody); // Fill the car body
        g2d.setColor(Color.BLACK); // Set color back to black for outlines
        g2d.draw(carBody); // Draw outline of the car body

        // Draw car windows
        Rectangle2D windowFront = new Rectangle2D.Double(110, 110, 60, 30);
        Rectangle2D windowBack = new Rectangle2D.Double(230, 110, 60, 30);
        g2d.setColor(Color.WHITE); // Set color to white for windows
        g2d.fill(windowFront); // Fill the front window
        g2d.fill(windowBack); // Fill the back window
        g2d.setColor(Color.BLACK); // Set color back to black for outlines
        g2d.draw(windowFront); // Draw outline of the front window
        g2d.draw(windowBack); // Draw outline of the back window

        // Draw wheels
        Ellipse2D wheelFront = new Ellipse2D.Double(105, 170, 40, 40);
        Ellipse2D wheelBack = new Ellipse2D.Double(260, 170, 40, 40);
        g2d.fill(wheelFront); // Fill the front wheel
        g2d.fill(wheelBack); // Fill the back wheel

        // Draw a coordinate system.
        drawSimpleCoordinateSystem(250, 200, g2d);
    }

    public static void drawSimpleCoordinateSystem(int xmax, int ymax, Graphics2D g2d) {
        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;
        // Remember the actual font.
        Font fo = g2d.getFont();
        // Use a small font.
        g2d.setFont(new Font("sansserif", Font.PLAIN, 9));
        // x-axis.
        g2d.drawLine(xOffset, yOffset, xmax, yOffset);
        // Marks and labels for the x-axis.
        for (int i = xOffset + step; i <= xmax; i = i + step) {
            g2d.drawLine(i, yOffset - 2, i, yOffset + 2);
            g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);
        }

        // y-axis.
        g2d.drawLine(xOffset, yOffset, xOffset, ymax);

        s = "  "; // for indention of numbers < 100
        for (int i = yOffset + step; i <= ymax; i = i + step) {
            g2d.drawLine(xOffset - 2, i, xOffset + 2, i);
            if (i > 99) {
                s = "";
            }
            g2d.drawString(s + String.valueOf(i), xOffset - 25, i + 5);
        }

        // Reset to the original font.
        g2d.setFont(fo);
    }

    public static void main(String[] argv) {
        exercise21 f = new exercise21();
        f.setTitle("Car Drawing");
        f.setSize(400, 300);
        f.setVisible(true);
    }
}
