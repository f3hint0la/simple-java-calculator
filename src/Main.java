import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {

    JFrame frame;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[4];
    JButton[] operatorButtons = new JButton[5];
    JButton addBtn, subBtn, mulBtn, divBtn, equalsBtn;
    JButton decBtn, clearBtn, delBtn, percBtn;
    JButton powerBtn;
    JPanel panel;
    JTextField textField;
    Font font, textFont, powerBtnFont;
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    Main() {
        font = new Font("Consolas", Font.BOLD, 25);
        textFont = new Font("Consolas", Font.PLAIN, 20);
        powerBtnFont = new Font("Consolas", Font.BOLD, 18);

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setText("0");
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setFont(textFont);
//        textField.setBackground(Color.gray);
        textField.setBackground(Color.black);
        textField.setForeground(Color.white);


        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("x");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equalsBtn = new JButton("=");
        clearBtn = new JButton("AC");
//        clear
        delBtn = new JButton("CE");
//        delete
        percBtn = new JButton("%");
        powerBtn = new JButton("OFF");

        operatorButtons[0] = addBtn;
        operatorButtons[1] = subBtn;
        operatorButtons[2] = mulBtn;
        operatorButtons[3] = divBtn;
        operatorButtons[4] = equalsBtn;

        functionButtons[0] = decBtn;
        functionButtons[1] = clearBtn;
        functionButtons[2] = delBtn;
        functionButtons[3] = percBtn;

        for (int i = 0; i < 5; i++) {
            operatorButtons[i].setFont(font);
            operatorButtons[i].setForeground(Color.white);
            operatorButtons[i].setBackground(Color.orange);
            operatorButtons[i].setFocusable(false);
            operatorButtons[i].addActionListener(this);
        }

        for (int i = 0; i < 4; i++) {
            functionButtons[i].setFont(font);
            functionButtons[i].setForeground(Color.white);
            functionButtons[i].setBackground(Color.darkGray);
            functionButtons[i].setFocusable(false);
            functionButtons[i].addActionListener(this);
            decBtn.setBackground(Color.black);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setBackground(Color.black);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        powerBtn.setBackground(Color.red);
        powerBtn.setForeground(Color.white);
        powerBtn.setFont(powerBtnFont);
        powerBtn.setActionCommand("power");
        powerBtn.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(6, 4, 10, 10));

        panel.add(clearBtn);
        panel.add(delBtn);
        panel.add(percBtn);
        panel.add(divBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        panel.add(powerBtn);
        panel.add(numberButtons[0]);
        panel.add(decBtn);
        panel.add(equalsBtn);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(410, 450);
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        new Main();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        String onClick = e.getActionCommand();
        JButton btn = (JButton) e.getSource();

//        if (e.getSource() == clearBtn) {
//            textField.setText("");
//        }
         if (e.getActionCommand().equals("power")) {
            if (btn.getText().equals("OFF")) {
                btn.setText("ON");
                btn.setBackground(Color.green);

                textField.setBackground(Color.lightGray);
                for (JButton operatorButtons : operatorButtons) {
                    operatorButtons.setBackground(Color.lightGray);
                    operatorButtons.setEnabled(false);
                }
                for (JButton functionButtons : functionButtons) {
                    functionButtons.setBackground(Color.lightGray);
                    functionButtons.setEnabled(false);
                }
                for (JButton numberButtons : numberButtons) {
                    numberButtons.setBackground(Color.lightGray);
                    numberButtons.setEnabled(false);
                }
            } else {
                btn.setText("OFF");
                btn.setBackground(Color.red);

                textField.setBackground(Color.black);
                for (JButton functionButtons : functionButtons) {
                    functionButtons.setBackground(Color.gray);
                    decBtn.setBackground(Color.black);
                    functionButtons.setForeground(Color.white);
                    functionButtons.setEnabled(true);
                }
                for (JButton numberButtons : numberButtons) {
                    numberButtons.setBackground(Color.black);
                    numberButtons.setForeground(Color.white);
                    numberButtons.setEnabled(true);
                }
                for (JButton operatorButtons : operatorButtons) {
                    operatorButtons.setBackground(Color.orange);
                    operatorButtons.setForeground(Color.white);
                    operatorButtons.setEnabled(true);
                }
                for (JButton functionButtons : functionButtons) {
                    functionButtons.setBackground(Color.darkGray);
                    functionButtons.setForeground(Color.white);
                    decBtn.setBackground(Color.black);
                    functionButtons.setEnabled(true);
                }
                for (JButton numberButtons : numberButtons) {
                    numberButtons.setBackground(Color.black);
                    numberButtons.setEnabled(true);
                }
            }
        }
        if (onClick.equals(".")) {
            if (textField.getText().length() > 0) {
                if (!textField.getText().contains(".")) {
                    textField.setText(textField.getText() + onClick);
                }
            } else
                textField.setText("0.");
        } else if (textField.getText().equals("0")) {
            textField.setText(onClick);
        } else if (e.getSource() == addBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == subBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == mulBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == divBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == percBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }
        else if (e.getSource() == equalsBtn) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        else if (e.getSource() == clearBtn) {
            textField.setText("");
        } else if (e.getSource() == delBtn) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < (string.length() - 1); i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        else textField.setText(textField.getText() + onClick);
    }
}
