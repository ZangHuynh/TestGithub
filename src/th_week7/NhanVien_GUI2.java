package th_week7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connect.ConnectionDB;
import dao.NhanVien_dao;
import dao.PhongBan_dao;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_GUI2 extends JFrame implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;

	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;

	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttLuu;
	private JButton bttXoaTrang;
	
	private JCheckBox chkNu;
	private JComboBox<String> cboPhongBan;

	private static PhongBan_dao pb_dao;

	private static NhanVien_dao nv_dao;

	

	public NhanVien_GUI2() {
		
		try {
			ConnectionDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pb_dao = new PhongBan_dao();
		nv_dao = new NhanVien_dao();

		setTitle("^-^");
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.blue);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3, b4;
		JLabel lblMaNV, lblHo, lblTuoi, lblPhai, lblTienLuong;
		
		b.add(b11 = Box.createHorizontalBox());
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(Box.createRigidArea(new Dimension(10, 10)));
		b1.add(lblMaNV = new JLabel("Mã nhân viên:   "));
		b1.add(txtMaNV = new JTextField());
		b1.add(Box.createRigidArea(new Dimension(10, 10)));

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(lblHo = new JLabel("Họ "));
		b2.add(txtHo = new JTextField());
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(new JLabel("Tên nhân viên: "));
		b2.add(txtTen = new JTextField());
		b2.add(Box.createRigidArea(new Dimension(10, 10)));

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(lblTuoi = new JLabel("Tuổi: "));
		b3.add(txtTuoi = new JTextField());
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(lblPhai = new JLabel("Phái: "));
		b3.add(chkNu = new JCheckBox("Nữ"));
		b3.add(Box.createRigidArea(new Dimension(10, 10)));

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(lblTienLuong = new JLabel("Tiền lương: "));
		b4.add(txtTienLuong = new JTextField());
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(new JLabel("Phòng Ban: "));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		
		//Tạo và đổ dữ liệu vào comboBox
		b4.add(cboPhongBan = new JComboBox<String>());
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		cboPhongBan.setEditable(true);	
		
		ArrayList<PhongBan> pbList = pb_dao.getAllPhongBan();
		for(PhongBan p : pbList) {
			cboPhongBan.addItem(p.getMaPhong());
		}
		
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhai.setPreferredSize(lblMaNV.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		cboPhongBan.setPreferredSize(lblMaNV.getPreferredSize());
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Mã NV", "Họ NV", "Tên NV", "Tuổi", "Phái", "Lương", "Phòng ban" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		tableNhanVien = new JTable(modelNhanVien);
		add(new JScrollPane(tableNhanVien), BorderLayout.CENTER);

		// =================================
		// doc du lieu tu database SQL vao Jtable
		docDuLieuTuDB();
		
		// =================================

		JPanel p = new JPanel();
		add(p, BorderLayout.SOUTH);
		JPanel pnlLeft, pnlRight;
		p.add(pnlLeft = new JPanel());
		p.add(pnlRight = new JPanel());

		pnlLeft.add(new JLabel("Nhập mã số cần tìm: "));
		pnlLeft.add(txtTim = new JTextField(10));
		pnlLeft.add(bttTim = new JButton("Tìm"));

		pnlRight.add(bttThem = new JButton("Thêm"));
		pnlRight.add(bttXoaTrang = new JButton("Xóa trắng"));
		pnlRight.add(bttXoa = new JButton("Xóa"));
		pnlRight.add(bttLuu = new JButton("Loc theo Ph Ban"));

		bttThem.addActionListener(this);
		bttXoaTrang.addActionListener(this);
		bttXoa.addActionListener(this);
		bttLuu.addActionListener(this);
		bttTim.addActionListener(this);
		tableNhanVien.addMouseListener(this);
	}

	public static void main(String[] args) {
		new NhanVien_GUI2().setVisible(true);
	}
	
	public void docDuLieuTuDB() {
		modelNhanVien.setRowCount(0);
		List<NhanVien> list = nv_dao.getAllNhanVien(); 
		
		for(NhanVien nv : list) {
			modelNhanVien.addRow(new Object[] { nv.getManNV(), nv.getHo(), nv.getTen(), nv.getTuoi()
					, nv.isPhai()?"Nữ":"Nam", nv.getTienLuong(), nv.getpBan().getMaPhong()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj.equals(bttXoaTrang)) {
			clearText();
		} else if(obj.equals(bttThem)) {
			String maNV = txtMaNV.getText().trim();
			String hoNV = txtHo.getText().trim();
			String tenNV = txtTen.getText().trim();
			int tuoi = Integer.parseInt(txtTuoi.getText().trim());
			boolean phai = chkNu.isSelected();
			double tienLuong = Double.parseDouble(txtTienLuong.getText().trim());
			String phBan = cboPhongBan.getSelectedItem().toString();
			
			if(validData()) {
				PhongBan pBan = new PhongBan(phBan);
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, tienLuong, pBan);
				try {
					if(nv_dao.create(nv)) {
						modelNhanVien.addRow(new Object[] {nv.getManNV(), nv.getHo(), nv.getTen(), nv.getTuoi(), nv.isPhai()?"Nữ":"Nam", nv.getTienLuong(), nv.getpBan().getMaPhong()});
					} else {
						JOptionPane.showMessageDialog(null, "Error: Trùng mã!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error: Trùng mã!");
				}
			}
		} else if(obj.equals(bttXoa)) {
			int row = tableNhanVien.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(null, "Error: Vui lòng chọn!");
			} else {
				String maNV = modelNhanVien.getValueAt(row, 0).toString();
				
				boolean deleted = nv_dao.deleteNV(maNV);
				if(deleted) {
					modelNhanVien.removeRow(row);
					clearText();
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Xóa không thành công!");
				}
			}
		} else if(obj.equals(bttTim)) {
			String maNV = txtTim.getText().trim();
			if(maNV.isEmpty()) {
				docDuLieuTuDB();
				txtTim.requestFocus();
			} else {
				ArrayList<NhanVien> result = nv_dao.getNhanVienByMaNV(maNV);
				updateTable(result);
			}
		} else if(obj.equals(bttLuu)) {
			String maPB = cboPhongBan.getSelectedItem().toString();
			if(maPB.isEmpty()) {
				docDuLieuTuDB();
			} else {
				ArrayList<NhanVien> nvList = nv_dao.getNhanVienByPhong(maPB);
				updateTable(nvList);
			}
		}
		
	}
	
	public void updateTable(ArrayList<NhanVien> list) {
		modelNhanVien.setRowCount(0);
		for(NhanVien nv : list)
			modelNhanVien.addRow(new Object[] {nv.getManNV(), nv.getHo(), nv.getTen(), nv.getTuoi(), nv.isPhai()?"Nữ":"Nam", nv.getTienLuong(), nv.getpBan().getMaPhong()});
	}
	
	public void clearText() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		chkNu.setSelected(false);
		txtMaNV.setEditable(true);
		txtMaNV.requestFocus();
	}
	
	public boolean validData() {
		String maNV = txtMaNV.getText().trim();
		String hoNV = txtHo.getText().trim();
		String tenNV = txtTen.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText().trim());
		double tienLuong = Double.parseDouble(txtTienLuong.getText().trim());
		
		if(maNV.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: Mã nhân viên");
			txtMaNV.requestFocus();
			return false;
		}
		if(hoNV.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: Họ nhân viên");
			txtHo.requestFocus();
			return false;
		}
		if(tenNV.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: Tên nhân viên");
			txtTen.requestFocus();
			return false;
		}
		if(tuoi <= 0) {
			JOptionPane.showMessageDialog(null, "Error: Tuổi nhân viên");
			txtTuoi.requestFocus();
			return false;
		}
		if(tienLuong <= 0) {
			JOptionPane.showMessageDialog(null, "Error: Tiền lương nhân viên");
			txtTienLuong.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtHo.setText(modelNhanVien.getValueAt(row, 1).toString());
		txtTen.setText(modelNhanVien.getValueAt(row, 2).toString());
		txtTuoi.setText(modelNhanVien.getValueAt(row, 3).toString());
		chkNu.setSelected(modelNhanVien.getValueAt(row, 4).toString() == "Nữ" ? true : false);
		txtTienLuong.setText(modelNhanVien.getValueAt(row, 5).toString());
		cboPhongBan.setSelectedItem(modelNhanVien.getValueAt(row, 6).toString());
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
