package th_week2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PushCounter extends JFrame implements ActionListener{

	private JButton btnPush;
	private JLabel lbPushCount;
	private int count = 0;

	public PushCounter() {
		setTitle("Push Counter");
		setSize(350,80);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.cyan);
		
		btnPush = new JButton("Push me!");
		lbPushCount = new JLabel("Pushes: ");
		
		add(btnPush);
		add(lbPushCount);
		
		btnPush.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new PushCounter().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnPush)) {
			count++;
			lbPushCount.setText("Pushes: " + count);
		}
		
	}
	
	
}
