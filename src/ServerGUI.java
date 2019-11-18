/*
 * @author Micheal Dunne
 * @description Displays the server front-end
 * */
import javax.swing.*;

public class ServerGUI {
    private JTextArea mDisplay = new JTextArea();

    public ServerGUI() {
//       Sets the Frame
        JFrame frame = new JFrame("Server");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//      Sets up JTextArea
        mDisplay.setBounds(0,0,500,500);
        frame.add(mDisplay);

//      Sets up the frame layout
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public JTextArea getmDisplay() {
        return mDisplay;
    }
}
