import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class Greet {
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel label;
    private final JTextField name;
    private final JButton button;

    public Greet() {
        frame = new JFrame("Saludo");
        configurePanel();

        panel = new JPanel(new GridBagLayout());

        label = new JLabel("¿Cómo te llamas?");
        name = new JTextField(15);
        button = new JButton("Saludar");

        configureElements();

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel nameLabel = new JLabel("Nombre:");

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(8, 0, 8, 8);
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.anchor = GridBagConstraints.WEST;
        name.setPreferredSize(new Dimension(180, 30));
        panel.add(name, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 0;
        panel.add(label, gbc);

        gbc.gridy = 2;
        panel.add(button, gbc);
        frame.add(panel);
    }

    private void configurePanel() {
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void configureElements() {
        label.setHorizontalAlignment(SwingConstants.CENTER);

        name.setHorizontalAlignment(SwingConstants.CENTER);

        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.addActionListener(e -> onClick());
    }

    private void onClick() {
        String nameText = name.getText().trim();
        if (nameText.isBlank()) {
            JOptionPane.showMessageDialog(panel, "El campo \"Nombre\" no puede estar vacío", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        label.setText("Hola, " + nameText);
    }

    public void displayWindow() {
        frame.setVisible(true);
    }
}
