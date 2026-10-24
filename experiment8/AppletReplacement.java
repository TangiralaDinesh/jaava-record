import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class ChartPanel extends JPanel {
    private final Color[] palette = {
        new Color(205, 63, 56), new Color(43, 139, 99),
        new Color(51, 112, 166), new Color(225, 177, 54)
    };
    private final int[] marks = { 78, 91, 45, 66, 88 };
    private int selectedColor;
    private String message = "Select a color or click a bar";

    ChartPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int paletteIndex = (event.getX() - 24) / 58;
                if (event.getY() >= 42 && event.getY() <= 82
                        && paletteIndex >= 0 && paletteIndex < palette.length) {
                    selectedColor = paletteIndex;
                } else if (event.getY() >= 130 && event.getX() >= 24) {
                    int barIndex = (event.getX() - 24) / 64;
                    if (barIndex >= 0 && barIndex < marks.length) {
                        message = "Subject " + (barIndex + 1) + " = " + marks[barIndex];
                    }
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.DARK_GRAY);
        graphics.drawString(message, 24, 25);

        for (int i = 0; i < palette.length; i++) {
            graphics.setColor(palette[i]);
            graphics.fillRect(24 + i * 58, 42, 48, 40);
        }

        for (int i = 0; i < marks.length; i++) {
            int height = marks[i];
            graphics.setColor(marks[i] >= 50 ? palette[selectedColor] : Color.GRAY);
            graphics.fillRect(24 + i * 64, 250 - height, 46, height);
            graphics.setColor(Color.DARK_GRAY);
            graphics.drawString(Integer.toString(marks[i]), 34 + i * 64, 244 - height);
            graphics.drawString("S" + (i + 1), 38 + i * 64, 270);
        }
    }
}

public class AppletReplacement {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Experiment 8 - Graphics and Mouse Events");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ChartPanel());
            frame.setSize(410, 310);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}