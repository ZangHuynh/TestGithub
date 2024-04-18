package th_week3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{

	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JRadioButton cong;
	private JRadioButton tru;
	private JRadioButton nhan;
	private JRadioButton chia;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;

	public Calculator() {
		setTitle("Cộng - Trừ - Nhân - Chia");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pContain = new JPanel();
		pContain.setLayout(new BorderLayout());
		add(pContain);
		
		JPanel pNorth = new JPanel();
		JLabel lbTitle = new JLabel("Cộng Trừ Nhân Chia");
		lbTitle.setFont(new Font(null, Font.BOLD, 30));
		lbTitle.setForeground(Color.blue);
		pNorth.add(lbTitle);
		pContain.add(pNorth, BorderLayout.NORTH);
		
		JPanel pSouth = new JPanel(new FlowLayout());
        pSouth.setPreferredSize(new Dimension(0, 30));
        pSouth.setBackground(Color.pink);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.blue);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.red);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.yellow);
        pSouth.add(Box.createRigidArea(new Dimension(20 , 20)));
        pSouth.add(p1);
        pSouth.add(p2);
        pSouth.add(p3);
        pContain.add(pSouth, BorderLayout.SOUTH);
        
        JPanel pWest = new JPanel();
        pWest.setBackground(Color.gray);
        pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
        pWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
        
        btnGiai = new JButton("Giải");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
		btnGiai.setMaximumSize(btnThoat.getMaximumSize());
		btnXoa.setMaximumSize(btnThoat.getMaximumSize());
		
		pWest.add(Box.createRigidArea(new Dimension(10, 10)));
		pWest.add(btnGiai);
		pWest.add(Box.createRigidArea(new Dimension(10, 10)));
		pWest.add(btnXoa);
		pWest.add(Box.createRigidArea(new Dimension(10, 10)));
		pWest.add(btnThoat);
		pWest.setPreferredSize(new Dimension(90, 90));
        pContain.add(pWest, BorderLayout.WEST);
        
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new BorderLayout());
        pCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));
        
        JLabel lbA = new JLabel("Nhập a:");
        JLabel lbB = new JLabel("Nhập b:");
        JLabel lbC = new JLabel("Kết quả:");
        txtA = new JTextField();
        txtB = new JTextField();
        txtC = new JTextField();
        txtC.setEditable(false);
        JPanel pContent = new JPanel();
        pContent.setBorder(BorderFactory.createTitledBorder("Phép toán"));
        
        
        ButtonGroup group = new ButtonGroup();
        cong = new JRadioButton("Cộng");
        tru = new JRadioButton("Trừ");
        nhan = new JRadioButton("Nhân");
        chia = new JRadioButton("Chia");

        group.add(cong);
        group.add(tru);
        group.add(nhan);
        group.add(chia);

        pContent.add(cong);
        pContent.add(tru);
        pContent.add(nhan);
        pContent.add(chia);
        
        Box box, b1, b2, b3, b4;
        box = Box.createVerticalBox();
        b1 = Box.createHorizontalBox();
        b2 = Box.createHorizontalBox();
        b3 = Box.createHorizontalBox();
        b4 = Box.createHorizontalBox();
        b1.add(Box.createRigidArea(new Dimension(50, 10)));
        b1.add(lbA);
        b1.add(Box.createRigidArea(new Dimension(10, 10)));
        b1.add(txtA);
        b1.add(Box.createRigidArea(new Dimension(30, 10)));
        
        b2.add(Box.createRigidArea(new Dimension(50, 10)));
        b2.add(lbB);
        b2.add(Box.createRigidArea(new Dimension(10, 10)));
        b2.add(txtB);
        b2.add(Box.createRigidArea(new Dimension(30, 10)));
        
        b3.add(Box.createRigidArea(new Dimension(100, 10)));
        b3.add(pContent);
        b3.add(Box.createRigidArea(new Dimension(30, 10)));
        
        b4.add(Box.createRigidArea(new Dimension(50, 10)));
        b4.add(lbC);
        b4.add(Box.createRigidArea(new Dimension(10, 10)));
        b4.add(txtC);
        b4.add(Box.createRigidArea(new Dimension(30, 10)));
        
        box.add(b1);
        box.add(Box.createRigidArea(new Dimension(10, 10)));
        box.add(b2);
        box.add(Box.createRigidArea(new Dimension(10, 10)));
        box.add(b3);
        box.add(Box.createRigidArea(new Dimension(10, 10)));
        box.add(b4);
        
        pCenter.add(box);
        pContain.add(pCenter);
        
        btnGiai.addActionListener(this);
        btnXoa.addActionListener(this);
        btnThoat.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Calculator().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThoat)) System.exit(0);
		if(obj.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtA.requestFocus();
		}
		if(obj.equals(btnGiai)) {
			float a = Float.parseFloat(txtA.getText());
			float b = Float.parseFloat(txtB.getText());
			if(cong.isSelected()) {
				float rs = a + b;
				txtC.setText(String.valueOf(rs));
			}
			if(tru.isSelected()) {
				float rs = a - b;
				txtC.setText(String.valueOf(rs));
			}
			if(nhan.isSelected()) {
				float rs = a * b;
				txtC.setText(String.valueOf(rs));
			}
			if(chia.isSelected()) {
				float rs = a / b;
				txtC.setText(String.valueOf(rs));
			}
		}
	}
	
}
