package th_week2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Fahrenheit extends JFrame implements ActionListener{

	private JLabel lbFahrenheit;
	private JLabel lbTemperature;
	private JTextField tfFahrenheit;

	public Fahrenheit() {
		setTitle("Fahrenheit");
		setSize(400,100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.yellow);
		
		lbFahrenheit = new JLabel("Enter Fahrenheit temperature: ");
		lbTemperature = new JLabel("Temperature ature in Celsius: ");
		tfFahrenheit = new JTextField(5);
		
		add(lbFahrenheit);
		add(tfFahrenheit);
		add(lbTemperature);
		
		tfFahrenheit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Fahrenheit().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(tfFahrenheit)) {
			double fahrenheitTemp, celsiusTemp;
			String text = tfFahrenheit.getText();
			fahrenheitTemp = Double.parseDouble(text);
			celsiusTemp = (fahrenheitTemp-32) * 5/9;
			DecimalFormat df = new DecimalFormat("#.##");
			lbTemperature.setText("Temperature in Celsius: " + df.format(celsiusTemp));
		}
	}
	
}
