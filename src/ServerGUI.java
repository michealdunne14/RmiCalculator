import javax.swing.*;
import java.awt.*;

public class ServerGUI {
    private JTextArea mDisplay = new JTextArea();
    private JFrame frame = new JFrame("Server");

    public ServerGUI() {
//       Sets the Frame
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      Row 1
        mDisplay.setBounds(0,0,500,500);
        frame.add(mDisplay);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public JTextArea getmDisplay() {
        return mDisplay;
    }

    public JFrame getFrame() {
        return frame;
    }
}
