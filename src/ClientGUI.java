import javax.swing.*;
import java.awt.*;

public class ClientGUI {
    private JTextArea mDisplay = new JTextArea();
    private JFrame frame = new JFrame("Client");
    private JTextArea jta = new JTextArea();



    private JButton mSlash,mStar,mMinus,mPlus,mOne,mTwo,mThree,mFour,mFive,mSix,mSeven,mEight,mNine,mZero,mSubmit,mNext;

    public ClientGUI() {
//       Sets the Frame
        frame.setSize(415, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mSlash = new JButton("/");
        mStar = new JButton("*");
        mMinus = new JButton("-");
        mPlus = new JButton("+");
        mOne = new JButton("1");
        mTwo = new JButton("2");
        mThree = new JButton("3");
        mFour = new JButton("4");
        mFive = new JButton("5");
        mSix = new JButton("6");
        mSeven = new JButton("7");
        mEight = new JButton("8");
        mNine = new JButton("9");
        mZero = new JButton("0");
        mSubmit = new JButton("Submit");
        mNext = new JButton("Next");

//      Row 1
        mDisplay.setBounds(0,0,400,100);
        mDisplay.setFont(new Font("Arial", Font.PLAIN, 40));
        mSlash.setBounds(0, 100, 100, 100);
        mSlash.setFont(new Font("Arial", Font.PLAIN, 40));
        mStar.setBounds(0, 200, 100, 100);
        mStar.setFont(new Font("Arial", Font.PLAIN, 40));
        mMinus.setBounds(0,300,100,100);
        mMinus.setFont(new Font("Arial", Font.PLAIN, 40));
        mPlus.setBounds(0,400,100,100);
        mPlus.setFont(new Font("Arial", Font.PLAIN, 40));

        mSlash.setEnabled(false);
        mPlus.setEnabled(false);
        mMinus.setEnabled(false);
        mStar.setEnabled(false);
        mSubmit.setEnabled(false);

//      Row 2
        mSeven.setBounds(100,100,100,100);
        mSeven.setFont(new Font("Arial", Font.PLAIN, 40));
        mFour.setBounds(100,200,100,100);
        mFour.setFont(new Font("Arial", Font.PLAIN, 40));
        mOne.setBounds(100,300,100,100);
        mOne.setFont(new Font("Arial", Font.PLAIN, 40));
        mZero.setBounds(100,400,100,100);
        mZero.setFont(new Font("Arial", Font.PLAIN, 40));

//      Row 3
        mEight.setBounds(200,100,100,100);
        mEight.setFont(new Font("Arial", Font.PLAIN, 40));
        mFive.setBounds(200,200,100,100);
        mFive.setFont(new Font("Arial", Font.PLAIN, 40));
        mTwo.setBounds(200,300,100,100);
        mTwo.setFont(new Font("Arial", Font.PLAIN, 40));
        mSubmit.setBounds(300,400,100,100);
        mSubmit.setFont(new Font("Arial", Font.PLAIN, 16));
        mNext.setBounds(200,400,100,100);
        mNext.setFont(new Font("Arial", Font.PLAIN, 16));

//      Row 4
        mNine.setBounds(300,100,100,100);
        mNine.setFont(new Font("Arial", Font.PLAIN, 40));
        mSix.setBounds(300,200,100,100);
        mSix.setFont(new Font("Arial", Font.PLAIN, 40));
        mThree.setBounds(300,300,100,100);
        mThree.setFont(new Font("Arial", Font.PLAIN, 40));

        jta.setBounds(0, 500, 400,200);


        frame.add(mSlash);
        frame.add(mDisplay);
        frame.add(mSlash);
        frame.add(mStar);
        frame.add(mMinus);
        frame.add(mPlus);

        frame.add(mSeven);
        frame.add(mFour);
        frame.add(mOne);
        frame.add(mZero);

        frame.add(mEight);
        frame.add(mFive);
        frame.add(mTwo);
        frame.add(mSubmit);
        frame.add(mNext);

        frame.add(mNine);
        frame.add(mSix);
        frame.add(mThree);
        frame.add(jta);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    public JButton getmNext() {
        return mNext;
    }

    public JTextArea getmDisplay() {
        return mDisplay;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getJta() {
        return jta;
    }

    public JButton getmSlash() {
        return mSlash;
    }

    public JButton getmStar() {
        return mStar;
    }

    public JButton getmMinus() {
        return mMinus;
    }

    public JButton getmPlus() {
        return mPlus;
    }

    public JButton getmOne() {
        return mOne;
    }

    public JButton getmTwo() {
        return mTwo;
    }

    public JButton getmThree() {
        return mThree;
    }

    public JButton getmFour() {
        return mFour;
    }

    public JButton getmFive() {
        return mFive;
    }

    public JButton getmSix() {
        return mSix;
    }

    public JButton getmSeven() {
        return mSeven;
    }

    public JButton getmEight() {
        return mEight;
    }

    public JButton getmNine() {
        return mNine;
    }

    public JButton getmZero() {
        return mZero;
    }

    public JButton getmSubmit() {
        return mSubmit;
    }
}
