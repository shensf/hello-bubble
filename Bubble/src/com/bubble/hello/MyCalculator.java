package com.bubble.hello;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class MyCalculator extends JFrame implements ActionListener {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String[] texts = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+","��"};
private JTextField display = new JTextField("0");
private JButton reset = new JButton("CE");
private JButton[] buttons = new JButton[texts.length];

double cal1;
double cal2;
String oper;

public MyCalculator() {
super("������");
JPanel jpanel1 = new JPanel(new GridLayout(5,4));

for(int i = 0;i<texts.length;i++) {
buttons[i] = new JButton(texts[i]);
buttons[i].addActionListener(this);
jpanel1.add(buttons[i]);
}
reset.addActionListener(this);
JPanel jpanel2 = new JPanel(new BorderLayout());
jpanel2.add("Center",display);
jpanel2.add("East",reset);

this.getContentPane().setLayout(new BorderLayout());
this.getContentPane().add("North",jpanel2);
this.getContentPane().add("Center", jpanel1);

setSize(300,300);
setVisible(true);

}
//�û��������ֵĴ���
boolean isFirstDigit = true;
public void handleNumber(String key) {
if(isFirstDigit){
display.setText(key);
}else if(key.equals(".") && display.getText().indexOf(".") < 0) {
display.setText(display.getText() + ".");
}else if ( !key.equals(".")) {
display.setText(display.getText() + key);
}
isFirstDigit = false;
}

double number = 0.0;
String operator = "=";
//����ı���
public void hanhleReset() {
display.setText("0");
operator = "=";
isFirstDigit = true;

}


//����Ĵ���
public void handleOperator(String key) {
if (operator.equals("+")) {
number += Double.valueOf(display.getText());
} else if(operator.equals("-")) {
number -= Double.valueOf(display.getText());
} else if(operator.equals("*")){
number *= Double.valueOf(display.getText());
} else if(operator.equals("��")){
number *= Double.valueOf(display.getText());
} else if(operator.equals("/")) {
number /= Double.valueOf(display.getText());

} else if(operator.equals("=")) {
number = Double.valueOf(display.getText());
}
display.setText(String.valueOf(number));
operator = key;
isFirstDigit = true;
}


@Override
public void actionPerformed(ActionEvent e) {
Object target = e.getSource();
String label = e.getActionCommand();
if("0123456789.".indexOf(label) > 0) {
handleNumber (label);
} else if(target == reset) {
hanhleReset();
} else {
handleOperator(label);
}

}

public static void main (String[] args){
new MyCalculator();
}


}
