import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel labelInstructions = new JLabel("Upload your IDMB CSV movie list!", JLabel.CENTER);
    JButton uploadButton = new JButton("Upload");
    JLabel labelMovie = new JLabel("", JLabel.CENTER);

    public GUI() {
        panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 100, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(labelInstructions);
        panel.add(uploadButton);
        panel.add(labelMovie);

        labelInstructions.setPreferredSize(new Dimension(300, 30));
        uploadButton.setPreferredSize(new Dimension(100, 30));
        uploadButton.addActionListener(this);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("IMDB Movie Picker");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        labelMovie.setText(new MoviePicker().getMovie());
    }
}
