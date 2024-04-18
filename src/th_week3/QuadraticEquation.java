package th_week3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuadraticEquation extends JFrame implements ActionListener{

	private JButton btnGiai;
	private JButton btnXoaTrang;
	private JButton btnThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtRS;

	public QuadraticEquation() {
		setTitle("Quadratic Equation");
		setSize(500, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pContain = new JPanel();
		pContain.setLayout(new BorderLayout());
		add(pContain);
		
		JPanel pNorth = new JPanel();
		pNorth.add(new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI"));
		pNorth.setBackground(Color.gray);
		pContain.add(pNorth, BorderLayout.NORTH);
		
		JPanel pSouth = new JPanel();
		pSouth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.magenta),"Chọn thao tác"));
		pContain.add(pSouth, BorderLayout.SOUTH);
		btnGiai = new JButton("Giải");
		btnXoaTrang = new JButton("Xóa trắng");
		btnThoat = new JButton("Thoát");
		pSouth.add(btnGiai);
		pSouth.add(btnXoaTrang);
		pSouth.add(btnThoat);
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Nhập a, b, c"));
		pCenter.setLayout(new BorderLayout());
		JLabel lbA = new JLabel("Nhập a");
		JLabel lbB = new JLabel("Nhập b");
		JLabel lbC = new JLabel("Nhập c");
		JLabel lbResult = new JLabel("Kết quả");
		txtA = new JTextField();
		txtB = new JTextField();
		txtC = new JTextField();
		txtRS = new JTextField();
		txtRS.setEditable(false);
		lbA.setPreferredSize(lbResult.getPreferredSize());
		lbB.setPreferredSize(lbResult.getPreferredSize());
		lbC.setPreferredSize(lbResult.getPreferredSize());
		pContain.add(pCenter);
		
		Box b, b1, b2, b3, b4;
		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		b1.add(lbA);
		b1.add(Box.createRigidArea(new Dimension(10, 10)));
		b1.add(txtA);
		b2.add(lbB);
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(txtB);
		b3.add(lbC);
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(txtC);
		b4.add(lbResult);
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(txtRS);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b2);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b3);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b4);
		pCenter.add(b);
		
		btnGiai.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new QuadraticEquation().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThoat)) System.exit(0);
		if(obj.equals(btnXoaTrang)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtRS.setText("");
			txtA.requestFocus();
		}
		if(obj.equals(btnGiai)) {
			float a, b, c;
			try {
				a = Float.parseFloat(txtA.getText());
				b = Float.parseFloat(txtB.getText());
				c = Float.parseFloat(txtC.getText());
				
				float delta = b*b - 4 * a * c;
				if(delta < 0) txtRS.setText("Phương trình vô nghiệm");
				if(delta == 0) {
					float x = -b / (2 * a);
					txtRS.setText("Phương trình có nghiệm kép" + x);
				}
				if(delta > 0) {
					float x1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
					float x2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
					txtRS.setText("Phương trình có nghiệm x1 = " + x1 + " và x2 = " + x2);
				}
					
			} catch (NumberFormatException err) {
				System.err.println("Chỉ được nhập số");
			}
		}
	}
	
}
