import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton uploadButton, tryAgainButton;
    JLabel movieLabel, instructionsLabel;

    public GUI() {
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 100, 150));
        panel.setLayout(new GridLayout(0, 1));

        setLabels();
        setButtons();
        setActions();
        setFrame();
    }

    private void setLabels() {
        instructionsLabel = new JLabel("Upload your IMDB CSV movie list!", JLabel.CENTER);
        instructionsLabel.setPreferredSize(new Dimension(300, 30));
        panel.add(instructionsLabel);

        movieLabel = new JLabel("", JLabel.CENTER);
        panel.add(movieLabel);
    }

    private void setButtons() {
        uploadButton = new JButton("Upload");
        uploadButton.setPreferredSize(new Dimension(100, 30));
        panel.add(uploadButton);

        tryAgainButton = new JButton("Try Again!");
        tryAgainButton.setPreferredSize(new Dimension(100, 30));
        panel.add(tryAgainButton);
        tryAgainButton.setVisible(false);
    }

    private void setActions() {
        uploadButton.addActionListener(this);
        uploadButton.setActionCommand("uploadButton");

        tryAgainButton.addActionListener(this);
        tryAgainButton.setActionCommand("tryAgainButton");
    }

    private void setFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("IMDB Movie Picker");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if (command.equals("uploadButton")) {
            movieLabel.setText("Let's watch: '" + MoviePicker.getMovie() + "'");
            tryAgainButton.setVisible(true);
        } else if (command.equals("tryAgainButton")) {
            movieLabel.setText("Let's watch: '" + MoviePicker.getDifferentMovie() + "'");
        }
    }
}
