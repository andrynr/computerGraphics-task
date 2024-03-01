import java.awt.*;

public class exercise26 extends Frame {

    // Constructor
    public exercise26() {
        // Enable the closing of the window.
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // Use antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // Definition and drawing of the curves that define the letters.

        // Letter A
        int xa1 = 50, ya1 = 400;
        int xa2 = 150, ya2 = 100;
        int xa3 = 250, ya3 = 400;
        int xa4 = 209, ya4 = 280;
        int xa5 = 91, ya5 = 280; 
        g2d.drawLine(xa1, ya1, xa2, ya2);
        g2d.drawLine(xa2, ya2, xa3, ya3);
        g2d.drawLine(xa5, ya5, xa4, ya4);
        g2d.drawLine(xa5, ya5, xa4, ya4); 


        // Letter N
        int xn1 = 300, yn1 = 400;
        int xn2 = 300, yn2 = 100;
        int xn3 = 400, yn3 = 400;
        int xn4 = 400, yn4 = 100;
        g2d.drawLine(xn1, yn1, xn2, yn2);
        g2d.drawLine(xn2, yn2, xn3, yn3);
        g2d.drawLine(xn3, yn3, xn4, yn4);

        // Letter R
        int xr1 = 450, yr1 = 400;
        int xr2 = 450, yr2 = 100;
        int xr3 = 550, yr3 = 250;
        int xr4 = 450, yr4 = 250;
        int xr5 = 550, yr5 = 400;
        g2d.drawLine(xr1, yr1, xr2, yr2);
        g2d.drawLine(xr2, yr2, xr3, yr3);
        g2d.drawLine(xr3, yr3, xr4, yr4);
        g2d.drawLine(xr4, yr4, xr5, yr5);
    }

    public static void main(String[] argv) {
        exercise26 f = new exercise26();
        f.setTitle("My Initial: A, N, R");

        f.setSize(600, 500);
        f.setVisible(true);
    }
}
