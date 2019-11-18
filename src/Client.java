/*
 * @author Micheal Dunne
 * @description Client that sends and receives information from the server.
 * */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;

public class Client {
    private float calculator = 0;
    private String operator = null;
    private String number = "";
    private ClientGUI clientGUI;
    private ArrayList<String> calculatorValue = new ArrayList<>();


    private static Calculator obj = null;

    public static void main(String args[])
    {
        new Client();
    }

    private Client(){
//      Client GUI
        clientGUI = new ClientGUI();
        clickListeners();
    }

    private void clickListeners(){

        JTextArea field = clientGUI.getmDisplay();
//      Divide operator
        clientGUI.getmSlash().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "/";
                field.append(operator);
                resetValue(true);
            }
        });
//      Multiply  operator
        clientGUI.getmStar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "*";
                field.append(operator);
                resetValue(true);
            }
        });
//      Minus operator
        clientGUI.getmMinus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = "-";
                field.append(operator);
                resetValue(true);
            }
        });
//      Plus operator
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
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmFour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 4;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmOne().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 1;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmZero().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 0;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmEight().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 8;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmFive().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 5;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmTwo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 2;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmNine().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 9;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmSix().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 6;
                updateCalcuatorValues(field);
            }
        });

        clientGUI.getmThree().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number += 3;
                updateCalcuatorValues(field);
            }
        });

//      Submit button to send information to server
        clientGUI.getmSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
//                  Resets Calculator
                    if (clientGUI.getmSubmit().getText().equals("Clear")) {
                        clientGUI.getmDisplay().setText("");
                        clientGUI.getmSubmit().setText("Submit");
                        clientGUI.getmSubmit().setEnabled(false);
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
                        calculatorValue.clear();
                        number = "";
                        operator = null;
                    }
//                  Gets result from server
                    else if (calculatorValue.size() == 2) {
                        clientGUI.getJta().append("Connected to Server \n");
                        obj = (Calculator) Naming.lookup("//"
                                + "localhost"
                                + "/Calculator");
//                      operations
                        if (operator.equals("+")) {
//                          Get result from server
                            calculator = obj.addNums(calculatorValue.get(0), calculatorValue.get(1));
                        } else if (operator.equals("-")) {
//                          Get result from server
                            calculator = obj.subtractNums(calculatorValue.get(0), calculatorValue.get(1));
                        }
                        else if (operator.equals("/")) {
//                          Get result from server
                            calculator = obj.divideNums(calculatorValue.get(0), calculatorValue.get(1));
                        } else if (operator.equals("*")) {
//                          Get result from server
                            calculator = obj.multipleNums(calculatorValue.get(0), calculatorValue.get(1));
                        }
                        System.out.println(calculator);
                        field.append("=" + calculator);
                        clientGUI.getmOne().setEnabled(false);
                        clientGUI.getmTwo().setEnabled(false);
                        clientGUI.getmThree().setEnabled(false);
                        clientGUI.getmFour().setEnabled(false);
                        clientGUI.getmFive().setEnabled(false);
                        clientGUI.getmSix().setEnabled(false);
                        clientGUI.getmSeven().setEnabled(false);
                        clientGUI.getmEight().setEnabled(false);
                        clientGUI.getmNine().setEnabled(false);
                        clientGUI.getmZero().setEnabled(false);
                        clientGUI.getmNext().setEnabled(false);
                        clientGUI.getmSubmit().setText("Clear");
                        clientGUI.getJta().append("Data Received from server \n");
                        clientGUI.getJta().append("Got Result " + calculator + "\n");
                    }
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
//      Go to the next stage of setting the operation.
        clientGUI.getmNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValue(false);
                number = "";
                clientGUI.getmNext().setEnabled(false);
            }
        });
    }

//  Update values
    public void updateCalcuatorValues(JTextArea field){
        if (calculatorValue.isEmpty()) {
            calculatorValue.add(this.number);
            field.setText(calculatorValue.get(0));
        }else if (operator == null){
            calculatorValue.remove(0);
            calculatorValue.add(this.number);
            field.setText(calculatorValue.get(0));
        } else {
            if (calculatorValue.size() != 2){
                calculatorValue.add(this.number);
            }else {
                calculatorValue.remove(1);
                calculatorValue.add(this.number);
            }
            field.setText(calculatorValue.get(0) + operator + calculatorValue.get(1));
        }
    }


    public void resetValue(boolean disablecheck){
        if (calculatorValue.size() == 2){
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
        clientGUI.getmSubmit().setEnabled(disablecheck);
    }
}
