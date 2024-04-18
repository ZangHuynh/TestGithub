package th_week2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StyleOptions extends JFrame implements ActionListener{

	private JLabel lbSaying;
	private JCheckBox cbBold;
	private JCheckBox cbItalic;

	public StyleOptions() {
		setTitle("Style Options");
		setSize(370,120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.cyan);
		
		lbSaying  = new JLabel("Saying it with style!");
		lbSaying.setFont(new Font("Helvetica", Font.PLAIN, 36));
        add(lbSaying);
		cbBold = new JCheckBox("Bold");
		cbBold.setBackground(Color.cyan);
		cbItalic = new JCheckBox("Italic");
		cbItalic.setBackground(Color.cyan);
		
		
		add(lbSaying);
		add(cbBold);
		add(cbItalic);
		
		cbBold.addActionListener(this);
		cbItalic.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new StyleOptions().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int style = Font.PLAIN;
		if(cbBold.isSelected())
			style += Font.BOLD;
		if(cbItalic.isSelected())
			style += Font.ITALIC;
		lbSaying.setFont(new Font("Helvetica", style, 36));
	}
	
}
