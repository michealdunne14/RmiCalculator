import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;

public class Client {
    private int calculator = 0;
    private String operator = null;
    private String number = "";
    private ClientGUI clientGUI;
    private ArrayList<String> calcuatorValue = new ArrayList<>();


    static Calculator obj = null;

    public static void main(String args[])
    {
        new Client();
    }

    private Client(){
        clientGUI = new ClientGUI();
        clickListeners();
    }

    private void clickListeners(){
        JTextArea field = clientGUI.getmDisplay();
        clientGUI.getmSlash().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "/";
                field.append(operator);
                resetValue(true);
            }
        });

        clientGUI.getmStar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "*";
                field.append(operator);
                resetValue(true);
            }
        });

        clientGUI.getmMinus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "-";
                field.append(operator);
                resetValue(true);
            }
        });

        clientGUI.getmPlus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "+";
                field.append(operator);
                resetValue(true);
            }
        });
        clientGUI.getmSeven().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 7;
                updateCalcuatorValues(number,field);
            }
        });

        clientGUI.getmFour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 4;
                updateCalcuatorValues(number,field);
            }
        });

        clientGUI.getmOne().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 1;
            }
        });

        clientGUI.getmZero().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 0;
            }
        });

        clientGUI.getmEight().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 8;
                updateCalcuatorValues(number,field);
            }
        });

        clientGUI.getmFive().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 5;
                updateCalcuatorValues(number,field);
            }
        });

        clientGUI.getmTwo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 2;
                updateCalcuatorValues(number,field);
            }
        });

        clientGUI.getmNine().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 9;
                updateCalcuatorValues(number,field);
            }
        });

        clientGUI.getmSix().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 6;
                updateCalcuatorValues(number,field);
            }
        });

        clientGUI.getmThree().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 3;
                updateCalcuatorValues(number,field);
            }
        });


        clientGUI.getmSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (clientGUI.getmSubmit().getText().equals("Clear")) {
                        clientGUI.getmDisplay().setText("");
                        clientGUI.getmSubmit().setText("Submit");
                        clientGUI.getmOne().setEnabled(true);
                        clientGUI.getmTwo().setEnabled(true);
                        clientGUI.getmThree().setEnabled(true);
                        clientGUI.getmFour().setEnabled(true);
                        clientGUI.getmFive().setEnabled(true);
                        clientGUI.getmSix().setEnabled(true);
                        clientGUI.getmSeven().setEnabled(true);
                        clientGUI.getmEight().setEnabled(true);
                        clientGUI.getmNine().setEnabled(true);
                        clientGUI.getmZero().setEnabled(true);
                        clientGUI.getmNext().setEnabled(true);
                        calcuatorValue.clear();
                        number = "";
                        operator = null;
                    }
                    else if (calcuatorValue.size() == 2) {
                        obj = (Calculator) Naming.lookup("//"
                                + "localhost"
                                + "/Calculator");
                        if (operator.equals("+")) {
                            calculator = obj.addNums(calcuatorValue.get(0), calcuatorValue.get(1));
                        } else if (operator.equals("-")) {
                            calculator = obj.subtractNums(calcuatorValue.get(0), calcuatorValue.get(1));
                        }
                        else if (operator.equals("/")) {
                            calculator = obj.divideNums(calcuatorValue.get(0), calcuatorValue.get(1));
                        } else if (operator.equals("*")) {
                            calculator = obj.multipleNums(calcuatorValue.get(0), calcuatorValue.get(1));
                        }
                        System.out.println(calculator);
                        field.append("=" + calculator);
                        clientGUI.getmSubmit().setText("Clear");
                    }
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });

        clientGUI.getmNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValue(false);
                number = "";
                clientGUI.getmNext().setEnabled(false);
            }
        });
    }


    public void updateCalcuatorValues(String number, JTextArea field){
        if (calcuatorValue.isEmpty()) {
            calcuatorValue.add(this.number);
            field.setText(calcuatorValue.get(0));
        }else if (operator == null){
            calcuatorValue.remove(0);
            calcuatorValue.add(this.number);
            field.setText(calcuatorValue.get(0));
        } else {
            if (calcuatorValue.size() != 2){
                calcuatorValue.add(this.number);
            }else {
                calcuatorValue.remove(1);
                calcuatorValue.add(this.number);
            }
            field.setText(calcuatorValue.get(0) + operator + calcuatorValue.get(1));
        }
    }


    public void resetValue(boolean disablecheck){
        if (calcuatorValue.size() == 2){
            clientGUI.getmPlus().setEnabled(disablecheck);
            clientGUI.getmMinus().setEnabled(disablecheck);
            clientGUI.getmStar().setEnabled(disablecheck);
            clientGUI.getmSlash().setEnabled(disablecheck);
        }else {
            clientGUI.getmPlus().setEnabled(!disablecheck);
            clientGUI.getmMinus().setEnabled(!disablecheck);
            clientGUI.getmStar().setEnabled(!disablecheck);
            clientGUI.getmSlash().setEnabled(!disablecheck);
        }
        clientGUI.getmOne().setEnabled(disablecheck);
        clientGUI.getmTwo().setEnabled(disablecheck);
        clientGUI.getmThree().setEnabled(disablecheck);
        clientGUI.getmFour().setEnabled(disablecheck);
        clientGUI.getmFive().setEnabled(disablecheck);
        clientGUI.getmSix().setEnabled(disablecheck);
        clientGUI.getmSeven().setEnabled(disablecheck);
        clientGUI.getmEight().setEnabled(disablecheck);
        clientGUI.getmNine().setEnabled(disablecheck);
        clientGUI.getmZero().setEnabled(disablecheck);
    }
}
