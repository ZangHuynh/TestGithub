package gk_EDP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI_NhanVien extends JFrame implements ActionListener, MouseListener{

	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtLuong;
	private JRadioButton rbNam;
	private JRadioButton rbNu;
	private ButtonGroup group;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private JTextField txtFind;
	private JButton btnFind;
	private NhanVien_Collection dsNV;
	private JComboBox<String> cbFind;
	private JButton btnUpdate;

	public GUI_NhanVien() {
		setTitle("22716371-HuynhThanhGiang");
		setSize(1000,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pContain = new JPanel();
		pContain.setLayout(new BorderLayout());
		
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());
		
		Box box, b1, b2, b3, b4, b5;
		box = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		b5 = Box.createHorizontalBox();
		
		JLabel lbTT = new JLabel("THÔNG TIN NHÂN VIÊN");
		lbTT.setForeground(Color.BLUE);
		lbTT.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b1.add(lbTT);
		
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(new JLabel("Mã nhân viên: "));
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(txtMaNV = new JTextField());
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(new JLabel("Họ: "));
		b3.add(Box.createRigidArea(new Dimension(70, 10)));
		b3.add(txtHo = new JTextField());
		b3.add(Box.createRigidArea(new Dimension(20, 10)));
		b3.add(new JLabel("Tên: "));
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(txtTen = new JTextField());
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(new JLabel("Tuổi: "));
		b4.add(Box.createRigidArea(new Dimension(60, 10)));
		b4.add(txtTuoi = new JTextField());
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(new JLabel("Phái: "));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(rbNam = new JRadioButton("Nam"));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(rbNu = new JRadioButton("Nữ"));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		group = new ButtonGroup();
		group.add(rbNam);
		group.add(rbNu);

		b5.add(Box.createRigidArea(new Dimension(10, 10)));
		b5.add(new JLabel("Tiền lương: "));
		b5.add(Box.createRigidArea(new Dimension(22, 10)));
		b5.add(txtLuong = new JTextField());
		b5.add(Box.createRigidArea(new Dimension(10, 10)));
		
		box.add(Box.createRigidArea(new Dimension(10, 10)));
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
		String[] header = {"Mã NV", "Họ", "Tên", "Tuổi", "Phái", "Tiền lương"};
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		pCenter.add(scroll = new JScrollPane(table), BorderLayout.NORTH);
		scroll.setPreferredSize(new Dimension(0, 250));
		
		dsNV = new NhanVien_Collection();
		LuuTru save = new LuuTru();
		try {
			dsNV = (NhanVien_Collection) save.docFile();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy file!!");
		}
		
		docArrayListVaoModel();
		
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new BorderLayout());
		
		JPanel pRight = new JPanel();
		pRight.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		pRight.add(btnThem = new JButton("Thêm"));
		pRight.add(btnXoa = new JButton("Xóa"));
		pRight.add(btnXoaTrang = new JButton("Xóa trắng"));
		pRight.add(btnUpdate = new JButton("Cập nhật"));
		pRight.add(btnLuu = new JButton("Lưu"));
		
		
		JPanel pMiddle = new JPanel();
		pMiddle.add(new JLabel("Tìm (COMBOBOX)"));
		String[] mang = {};
		pMiddle.add(cbFind = new JComboBox<String>(mang));
		cbFind.setPreferredSize(new Dimension(100, 30));
		
		JPanel pLeft = new JPanel();
		pLeft.add(new JLabel("Nhập mã cần tìm: "));
		pLeft.add(Box.createRigidArea(new Dimension(10, 10)));
		pLeft.add(txtFind = new JTextField(15));
		pLeft.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
		pLeft.add(btnFind = new JButton("Tìm"));
		
		pSouth.add(pLeft, BorderLayout.WEST);
		pSouth.add(pMiddle, BorderLayout.CENTER);
		pSouth.add(pRight, BorderLayout.EAST);
		
		updateComboBox();
		
		pContain.add(pNorth, BorderLayout.NORTH);
		pContain.add(pCenter, BorderLayout.CENTER);
		pContain.add(pSouth, BorderLayout.SOUTH);
		add(pContain);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnFind.addActionListener(this);
		table.addMouseListener(this);
		cbFind.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new GUI_NhanVien().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThem)) {
			
			if(txtMaNV.getText().trim().isEmpty() || txtHo.getText().trim().isEmpty() || txtTen.getText().trim().isEmpty() || (Integer.parseInt(txtTuoi.getText().trim())) <= 0 
					|| Double.parseDouble(txtLuong.getText().trim()) < 0 || (!rbNam.isSelected() && !rbNu.isSelected())) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin!");
			} else {
				NhanVien nv = revertNhanVien();
				
				if(!dsNV.themNV(nv)) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
				} else {
					tableModel.addRow(new Object[] {nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.isPhai()?"Nam":"Nữ", nv.getTienLuong()});
					updateComboBox();
				}
			}
			
		} else if(obj.equals(btnXoaTrang)) {
			clearText();
			
		} else if(obj.equals(btnXoa)) {
			int remove = table.getSelectedRow();
			NhanVien nv = dsNV.getElement(remove);
			tableModel.removeRow(remove);
			dsNV.removeNV(nv);
			updateComboBox();
			
		} else if(obj.equals(btnLuu)) {
			LuuTru save = new LuuTru();
			try {
				save.ghiFile(dsNV);
				JOptionPane.showMessageDialog(null, "Lưu thành công!");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		} else if(obj.equals(btnFind)) {
			String find = txtFind.getText().trim();
			NhanVien nv = dsNV.timKiem(find);
			if(!find.isEmpty() || nv != null) {
				int row = dsNV.getAll().indexOf(nv);
				table.getSelectionModel().setSelectionInterval(row, row);
				table.scrollRectToVisible(table.getCellRect(row, 0, true));
				txtFind.setText("");
			} else {
				txtFind.selectAll();
				txtFind.requestFocus();
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
			}
			
		} else if(obj.equals(cbFind)) {
			String maNV = (String) cbFind.getSelectedItem();
			NhanVien nv = dsNV.timKiem(maNV);
			
			if(nv != null) {
				int index = dsNV.getAll().indexOf(nv);
				table.getSelectionModel().setSelectionInterval(index, index);
				table.scrollRectToVisible(table.getCellRect(index, 0, true));
			}
			
		} else if(obj.equals(btnUpdate)) {
			String maNV = txtMaNV.getText().trim();
			NhanVien nv = revertNhanVien();
			if(dsNV.updateNV(maNV, nv)) {
				docArrayListVaoModel();
				JOptionPane.showMessageDialog(this, "Update success!");
				int index = dsNV.getAll().indexOf(nv);
				table.setRowSelectionInterval(index, index);
			} else JOptionPane.showMessageDialog(this, "Vui lòng chọn");
		}
		
	}
	
	public NhanVien revertNhanVien() {
		String maNV = txtMaNV.getText().trim();
		String ho = txtHo.getText().trim();
		String ten = txtTen.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText().trim());
		boolean phai = rbNam.isSelected();
		Double tienLuong = Double.parseDouble(txtLuong.getText().trim());
		
		NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, phai, tienLuong);
		
		return nv;
	}
	
	public void docArrayListVaoModel() {
		tableModel.setRowCount(0);
		for(int i = 0; i < dsNV.getSize(); i++) {
			NhanVien nv = dsNV.getElement(i);
			tableModel.addRow(new Object[] {nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.isPhai()?"Nam":"Nữ", nv.getTienLuong()});
		}
	}
	
	public void clearText() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		rbNam.setSelected(false);
		rbNu.setSelected(false);
		txtLuong.setText("");
	}
	
	public void updateComboBox() {
		int combo = dsNV.getSize();
		String[] items = new String[combo];
		int i = 0;
		for(NhanVien nv : dsNV.getAll()) {
			items[i] = nv.getMaNV();
			i++;
		}
		cbFind.setModel(new DefaultComboBoxModel<String>(items));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		NhanVien nv = dsNV.getElement(row);
		txtMaNV.setText(nv.getMaNV());
		txtHo.setText(nv.getHoNV());
		txtTen.setText(nv.getTenNV());
		txtTuoi.setText(String.valueOf(nv.getTuoi()));
		rbNam.setSelected(nv.isPhai());
		rbNu.setSelected(!nv.isPhai());
		txtLuong.setText(String.valueOf(nv.getTienLuong()));
		
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
