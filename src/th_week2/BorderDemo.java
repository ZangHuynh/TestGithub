package th_week2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BorderDemo extends JFrame implements ActionListener{

	public BorderDemo() {
		setTitle("Border Demo");
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,5,10));
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		add(panel);
		
		JLabel p1 = new JLabel("Line Border");
		p1.setHorizontalAlignment(JLabel.CENTER);
		p1.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		
		JLabel p2 = new JLabel("Etched Border");
		p2.setHorizontalAlignment(JLabel.CENTER);
		p2.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel p3 = new JLabel("Raised Bevel Border");
		p3.setHorizontalAlignment(JLabel.CENTER);
		p3.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JLabel p4 = new JLabel("Lowered Bevel Border");
		p4.setHorizontalAlignment(JLabel.CENTER);
		p4.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel p5 = new JLabel("Titled Border");
		p5.setHorizontalAlignment(JLabel.CENTER);
		p5.setBorder(BorderFactory.createTitledBorder("Title"));
		
		JLabel p6 = new JLabel("Titled Border (right)");
		p6.setHorizontalAlignment(JLabel.CENTER);
		TitledBorder tb = BorderFactory.createTitledBorder("Title");
		tb.setTitleJustification(TitledBorder.RIGHT);
		p6.setBorder(tb);
		
		JLabel p7 = new JLabel("Compiund Border");
		p7.setHorizontalAlignment(JLabel.CENTER);
		p7.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.blue,2), BorderFactory.createEtchedBorder()));
		
		JLabel p8 = new JLabel("Matte Border");
		p8.setHorizontalAlignment(JLabel.CENTER);
		p8.setBorder(BorderFactory.createMatteBorder(1,  5,  1,  1, Color.red));

		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);
		panel.add(p6);
		panel.add(p7);
		panel.add(p8);
	}
	
	public static void main(String[] args) {
		new BorderDemo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
