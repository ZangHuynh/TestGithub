package th_week4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TTNhanVien extends JFrame implements ActionListener, MouseListener{
	
	private NhanVien_Collection dsNV;
	private JTextField txtCode;
	private JTextField txtLName;
	private JTextField txtFName;
	private JTextField txtOld;
	private JRadioButton rbMale;
	private JRadioButton rbFemale;
	private ButtonGroup group;
	private JTextField txtSalary;
	private DefaultTableModel tbModel;
	private JTable table;
	private JScrollPane scroll;
	private JTextField txtFind;
	private JButton btnFind;
	private JButton btnAdd;
	private JButton btnRS;
	private JButton btnRemove;
	private JButton btnSave;

	public TTNhanVien() {
		setTitle("^-^");
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pContain = new JPanel();
		pContain.setLayout(new BorderLayout());
		
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());
		
		JLabel lbTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lbTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbTieuDe.setForeground(Color.BLUE);
		
		Box box, b1, b2, b3, b4, b5;
		box = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		b5 = Box.createHorizontalBox();
		
		b1.add(lbTieuDe);
		b1.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(new JLabel("Mã nhân viên: "));
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(txtCode = new JTextField());
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(new JLabel("Họ: "));
		b3.add(Box.createRigidArea(new Dimension(70, 10)));
		b3.add(txtLName = new JTextField());
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(new JLabel("Tên nhân viên: "));
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(txtFName = new JTextField());
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(new JLabel("Tuổi: "));
		b4.add(Box.createRigidArea(new Dimension(60, 10)));
		b4.add(txtOld = new JTextField());
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(new JLabel("Phái: "));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(rbMale = new JRadioButton("Nam"));
		b4.add(rbFemale = new JRadioButton("Nữ"));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		group = new ButtonGroup();
		group.add(rbFemale);
		group.add(rbMale);
		
		b5.add(Box.createRigidArea(new Dimension(10, 10)));
		b5.add(new JLabel("Tiền lương: "));
		b5.add(Box.createRigidArea(new Dimension(22, 10)));
		b5.add(txtSalary = new JTextField());
		b5.add(Box.createRigidArea(new Dimension(10, 10)));
		
		box.add(b1);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(b2);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(b3);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(b4);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		box.add(b5);
		box.add(Box.createRigidArea(new Dimension(10, 10)));
		pNorth.add(box, BorderLayout.CENTER);
		
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		String[] header = {"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
		tbModel = new DefaultTableModel(header, 0);
		table = new JTable(tbModel);
		table.setRowHeight(30);
		pCenter.add(scroll = new JScrollPane(table), BorderLayout.NORTH);
		scroll.setPreferredSize(new Dimension(0, 250));
		
		dsNV = new NhanVien_Collection();
		LuuTru save = new LuuTru();
		try {
			dsNV = (NhanVien_Collection) save.DocFile("data/NhanVien.txt");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy file");
		}
		
		docDuLieuTuArrayListVaoModel();
		
		JPanel pSouth = new JPanel();  
		pSouth.setLayout(new BorderLayout());
		
		JPanel pLeft = new JPanel();
		pLeft.add(new JLabel("Nhập mã số cần tìm: "));
		pLeft.add(txtFind = new JTextField(20));
		pLeft.add(btnFind = new JButton("Tìm"));
		pLeft.setBorder(BorderFactory.createLineBorder(Color.gray));
		pSouth.add(pLeft, BorderLayout.WEST);

		JPanel pRight = new JPanel();
		pRight.add(btnAdd = new JButton("Thêm"));
		pRight.add(btnRS = new JButton("Xóa trắng"));
		pRight.add(btnRemove = new JButton("Xóa"));
		pRight.add(btnSave = new JButton("Lưu"));
		pRight.setBorder(BorderFactory.createLineBorder(Color.gray));
		pSouth.add(pRight, BorderLayout.EAST);
		
		pContain.add(pNorth, BorderLayout.NORTH);
		pContain.add(pCenter, BorderLayout.CENTER);
		pContain.add(pSouth, BorderLayout.SOUTH);
		add(pContain);
		
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnFind.addActionListener(this);
		btnRS.addActionListener(this);
		btnSave.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new TTNhanVien().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
	    if (obj.equals(btnAdd)) {
	        String maNV = txtCode.getText();
	        String hoNV = txtLName.getText();
	        String tenNV = txtFName.getText();
	        int tuoi = Integer.parseInt(txtOld.getText());
	        boolean phai = rbMale.isSelected();
	        double tienLuong = Double.parseDouble(txtSalary.getText());
	        DecimalFormat df = new DecimalFormat("#,##0.00 $");
	        
	        if (maNV.trim().isEmpty() || hoNV.trim().isEmpty() || tenNV.trim().isEmpty() || tuoi < 18 || tienLuong < 0 || (!rbFemale.isSelected() && !rbMale.isSelected())) {
	            JOptionPane.showMessageDialog(this, "Vui lòng không để trống thông tin hoặc nhập sai định dạng.");
	        } else {
	        	NhanVien nv = new NhanVien(maNV, hoNV, tenNV, phai, tuoi, tienLuong);

	            if (!dsNV.themNV(nv)) {
	                JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại.");
	            } else {
	                tbModel.addRow(new Object[] {nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getPhai() ? "Nam" : "Nữ", nv.getTuoi(), df.format(nv.getTienLuong())});
	            }
	        }
	    }
	    
	    if(obj.equals(btnRemove)) {
	    	int remove = table.getSelectedRow();
	    	tbModel.removeRow(remove);
	    	NhanVien nv = dsNV.getElement(remove);
	    	dsNV.xoaNV(nv);
	    }
	    
	    if(obj.equals(btnRS)) {
	    	txtCode.setText("");
	    	txtFName.setText("");
	    	txtLName.setText("");
	    	txtOld.setText("");
	    	rbMale.setSelected(false);
	        rbFemale.setSelected(false);
	    	txtSalary.setText("");
	    }
	    
	    if(obj.equals(btnFind)) {
	    	findByCode();
	    }
	    
	    if(obj.equals(btnSave)) {
	    	LuuTru save = new LuuTru();
	    	try {
				save.LuuFile(dsNV, "data/NhanVien.txt");
				JOptionPane.showMessageDialog(null, "Lưu thành công");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	
	    }
	}
	
	public void docDuLieuTuArrayListVaoModel() { 
		for(int i = 0; i < dsNV.getSize(); i++) { 
			NhanVien nv = dsNV.getElement(i); 
			tbModel.addRow(new Object[] {nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getPhai() ? "Nam" : "Nữ", nv.getTuoi(), nv.getTienLuong()}); } 
	}

	/*
	 * public void clearAll() { 
	 * DefaultTableModel dft = (DefaultTableModel)
	 * table.getModel(); dft.getDataVector().removeAllElements(); }
	 */
	
	public void findByCode() {
	    String find = txtFind.getText();
	    if (find.trim().length() > 0 || find != null) {
	        boolean found = false;
	        for (int i = 0; i < dsNV.getSize(); i++) {
	            if (dsNV.getElement(i).getMaNV().equalsIgnoreCase(find)) {
	                found = true;
	                table.setRowSelectionInterval(i, i);
	                table.scrollRectToVisible(table.getCellRect(i, 0, true));
	                txtFind.setText("");
	                break;
	            }
	        }
	        if (!found) {
	        	txtFind.selectAll();
	        	txtFind.requestFocus();
	            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có mã " + find);
	        }
	    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		NhanVien nv = dsNV.getElement(row);
		txtCode.setText(nv.getMaNV());
        txtFName.setText(nv.getHoNV());
        txtLName.setText(nv.getTenNV());
        rbMale.setSelected(nv.getPhai());
        rbFemale.setSelected(!nv.getPhai());
        txtOld.setText(String.valueOf(nv.getTuoi()));
        txtSalary.setText(String.valueOf(nv.getTienLuong()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
