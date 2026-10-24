import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Experiment 9 - Layout Managers");
            frame.setLayout(new BorderLayout(8, 8));

            JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.CENTER));
            toolbar.add(new JButton("New"));
            toolbar.add(new JButton("Open"));
            toolbar.add(new JButton("Save"));

            JPanel keypad = new JPanel(new GridLayout(4, 3, 5, 5));
            String[] keys = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
            for (String key : keys) {
                keypad.add(new JButton(key));
            }

            frame.add(toolbar, BorderLayout.NORTH);
            frame.add(keypad, BorderLayout.CENTER);
            frame.add(new JLabel("FlowLayout toolbar | GridLayout keypad | BorderLayout frame"),
                    BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(340, 360);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}