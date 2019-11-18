import javax.swing.*;
import java.awt.*;

public class ServerGUI {
    private JTextArea mDisplay = new JTextArea();

    public ServerGUI() {
//       Sets the Frame
        JFrame frame = new JFrame("Server");
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
}
