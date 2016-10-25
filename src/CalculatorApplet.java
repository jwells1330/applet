import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorApplet extends JApplet{
	
	private JTextField numberField;
	private JPanel panel;
	private JButton button;

	public void init(){
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		createTextField();
		createButtons();
	}
	public void createTextField(){
		numberField = new JTextField();
		add(numberField, BorderLayout.NORTH);
	}
	public void createButtons(){
		panel = new JPanel();
		for(int i = 7; i<10; i++){
			button = new JButton("" + i);
			panel.add(button);
		}
		button = new JButton("/");
		panel.add(button);
		for(int i = 4; i<7; i++){
			button = new JButton("" + i);
			panel.add(button);
		}
		button = new JButton("*");
		panel.add(button);
		for(int i = 1; i<4; i++){
			button = new JButton("" + i);
			panel.add(button);
		}
		button = new JButton("-");
		panel.add(button);
		button = new JButton("0");
		panel.add(button);
		button = new JButton(".");
		panel.add(button);
		button = new JButton("=");
		panel.add(button);
		button = new JButton("+");
		panel.add(button);
		
		panel.setLayout(new GridLayout(4,4));

		add(panel);
	}
}
