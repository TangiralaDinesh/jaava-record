import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegisterForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegisterForm::createWindow);
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Student Registration");
        JTextField name = new JTextField(16);
        JComboBox<String> branch = new JComboBox<>(new String[] { "CSE", "IT", "ECE" });
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JCheckBox hostel = new JCheckBox("Hostel required");
        JButton submit = new JButton("Submit");
        JLabel result = new JLabel(" ");

        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.add(new JLabel("Name"));
        form.add(name);
        form.add(new JLabel("Branch"));
        form.add(branch);
        form.add(new JLabel("Gender"));
        JPanel genderChoices = new JPanel();
        genderChoices.add(male);
        genderChoices.add(female);
        form.add(genderChoices);
        form.add(hostel);
        form.add(submit);
        form.add(result);

        submit.addActionListener(event -> {
            String studentName = name.getText().trim();
            if (studentName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Name cannot be empty");
                return;
            }
            if (!male.isSelected() && !female.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Select a gender");
                return;
            }
            String selectedGender = male.isSelected() ? "Male" : "Female";
            result.setText(studentName + " | " + branch.getSelectedItem() + " | "
                    + selectedGender + " | Hostel: " + (hostel.isSelected() ? "Yes" : "No"));
        });

        frame.setContentPane(form);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}