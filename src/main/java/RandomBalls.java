import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RandomBalls extends JFrame {

    final String TITLE_OF_PROGRAM = "Random balls";
    final int WINDOW_WIDTH = 650;
    final int WINDOW_HEIGHT = 650;
    int COUNT_BALLS;
    Random random;
    ArrayList<Ball> balls;
    final Color[] COLORS = {Color.red, Color.green, Color.blue};

    public static void main(String[] args) {
        new RandomBalls();
    }

    public RandomBalls() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(
                new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                canvas.repaint();
                deleteBall(e.getX(), e.getY());
            }
        });
        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        random = new Random();
        balls = new ArrayList<Ball>();

        for (int i = 0; i < COUNT_BALLS; i++) {
            addBall();
        }
    }

    void addBall() {
        int d = random.nextInt(20) + 60;
        int x = random.nextInt(WINDOW_WIDTH - d);
        int y = random.nextInt(WINDOW_HEIGHT - d);
        Color color = COLORS[random.nextInt(COLORS.length)];
        balls.add(new Ball(x, y, d, color));
    }

    void deleteBall(int x, int y) {
        for (int i = balls.size() - 1; i > -1; i--) {
            double dx = balls.get(i).x + balls.get(i).d/2 - x;
            double dy = balls.get(i).y  + balls.get(i).d/2 - y;
            double d = Math.sqrt(dx * dx + dy * dy);
            if (d < balls.get(i).d/2) {
                balls.remove(i);
                break;
            }
        }
    }

    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //grawing
            for (int i = 0; i < 100; i++) {
                int d = random.nextInt(20) + 60;
                int x = random.nextInt(WINDOW_HEIGHT - d);
                int y = random.nextInt(WINDOW_WIDTH - d);
                Color color = COLORS[random.nextInt(COLORS.length)];
                g.setColor(color);
                g.fillOval(x, y, d, d);
                g.setColor(Color.black);
                g.drawOval(x, y, d, d);
            }
        }
    }

    class Ball {
        int x, y, d;
        Color color;

        Ball(int x, int y, int d, Color color) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.color = color;
        }

        void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, d, d);
            g.setColor(Color.black);
            g.drawOval(x, y, d ,d);

            for (Ball ball : balls) {
                ball.paint(g);
            }
        }

    }

}

