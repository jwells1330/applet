import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorApplet extends JApplet {

	private JTextField numberField;
	private JPanel panel;
	private JButton button;
	private JButton[] buttonArray = new JButton[10];

	private double num1 = 0;
	private double num2 = 0;

	private int func = -1;

	public void init() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		createTextField();
		createButtons();
		createListeners();
	}

	public void createTextField() {
		numberField = new JTextField();
		add(numberField, BorderLayout.NORTH);
	}

	public void createButtons() {
		panel = new JPanel();
		for (int i = 7; i < 10; i++) {
			button = new JButton("" + i);
			panel.add(button);
			buttonArray[i] = button;
		}
		button = new JButton("/");
		button.addActionListener(new Divide());
		panel.add(button);

		for (int i = 4; i < 7; i++) {
			button = new JButton("" + i);
			panel.add(button);
			buttonArray[i] = button;
		}
		button = new JButton("*");
		button.addActionListener(new Multiply());
		panel.add(button);

		for (int i = 1; i < 4; i++) {
			button = new JButton("" + i);
			panel.add(button);
			buttonArray[i] = button;
		}
		
		button = new JButton("-");
		panel.add(button);
		button.addActionListener(new Subtract());
		
		button = new JButton("0");
		panel.add(button);
		buttonArray[0] = button;
		
		button = new JButton(".");
		panel.add(button);
		button.addActionListener(new Decimel());
		
		button = new JButton("=");
		panel.add(button);
		button.addActionListener(new Equals());
		
		button = new JButton("+");
		panel.add(button);
		button.addActionListener(new Add());
		

		panel.setLayout(new GridLayout(4, 4));

		add(panel);
	}

	public void createListeners() {
		for (JButton button : buttonArray) {
			NumberButtonsListener listner = new NumberButtonsListener(button);
			button.addActionListener(listner);
		}
	}

	private class NumberButtonsListener implements ActionListener {

		private String num = "";

		public NumberButtonsListener(JButton button) {
			this.num = button.getText();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			numberField.setText(numberField.getText() + num);
		}
	}

	private class Divide implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			num1 = Double.parseDouble(numberField.getText());
			numberField.setText("");
			func = 1;
		}
	}

	private class Multiply implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			num1 = Double.parseDouble(numberField.getText());
			numberField.setText("");
			func = 2;
		}
	}

	private class Subtract implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			num1 = Double.parseDouble(numberField.getText());
			numberField.setText("");
			func = 3;
		}
	}

	private class Add implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			num1 = Double.parseDouble(numberField.getText());
			numberField.setText("");
			func = 4;
		}
	}

	private class Equals implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			num2 = Double.parseDouble(numberField.getText());

			if (func == 1) {
				num1 = num1/num2;
			}
			if (func == 2) {
				num1 = num1*num2;
			}
			if (func == 3) {
				num1 = num1-num2;
			}
			if (func == 4) {
				num1 = num1+num2;
			}
			numberField.setText(""+num1);
		}
	}
	private class Decimel implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			numberField.setText(numberField.getText() + ".");
		}
	}
}
