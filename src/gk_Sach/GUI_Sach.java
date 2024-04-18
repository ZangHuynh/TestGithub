package gk_Sach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI_Sach extends JFrame implements ActionListener, MouseListener{

	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private DefaultTableModel tbModel;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnAdd;
	private JButton btnRS;
	private JButton btnRemove;
	private JButton btnUpdate;
	private Sach_Collection bookList;
	private JComboBox<String> cbMaSach;
	private JPanel pSub;
	private JLabel lbMess;
	private JButton btnSave;

	public GUI_Sach() {
		setTitle("Quản lý sách");
		setSize(1000, 540);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pContain = new JPanel();
		pContain.setLayout(new BorderLayout());
		
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());
		pNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		
		Box box, b1, b2, b3, b4, b5, b6;
		box = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		b5 = Box.createHorizontalBox();
		b6 = Box.createHorizontalBox();
		
		b1.add(Box.createRigidArea(new Dimension(10, 10)));
		b1.add(new JLabel("Mã sách: "));
		b1.add(Box.createRigidArea(new Dimension(40, 10)));
		b1.add(txtMaSach = new JTextField());
		b1.add(Box.createRigidArea(new Dimension(600, 10)));
		
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(new JLabel("Tựa sách: "));
		b2.add(Box.createRigidArea(new Dimension(35, 10)));
		b2.add(txtTuaSach = new JTextField());
		b2.add(Box.createRigidArea(new Dimension(50, 10)));
		b2.add(new JLabel("Tác giả: "));
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		b2.add(txtTacGia = new JTextField());
		b2.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(new JLabel("Năm xuất bản: "));
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(txtNamXB = new JTextField());
		b3.add(Box.createRigidArea(new Dimension(20, 10)));
		b3.add(new JLabel("Nhà xuất bản: "));
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		b3.add(txtNhaXB = new JTextField());
		b3.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(new JLabel("Số trang: "));
		b4.add(Box.createRigidArea(new Dimension(40, 10)));
		b4.add(txtSoTrang = new JTextField());
		b4.add(Box.createRigidArea(new Dimension(50, 10)));
		b4.add(new JLabel("Đơn giá: "));
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(txtDonGia = new JTextField());
		b4.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b5.add(Box.createRigidArea(new Dimension(10, 10)));
		b5.add(new JLabel("International Standard Book Number (ISBN): "));
		b5.add(Box.createRigidArea(new Dimension(10, 10)));
		b5.add(txtISBN = new JTextField());
		b5.add(Box.createRigidArea(new Dimension(10, 10)));
		
		b6.add(pSub = new JPanel());
		pSub.setLayout(new BorderLayout());
		pSub.add(lbMess = new JLabel(), BorderLayout.WEST);
		Font f = new Font("Times New Roman", Font.ITALIC, 14);
		lbMess.setFont(f);
		lbMess.setForeground(Color.red);
		
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
		box.add(b6);
		
		pNorth.add(box);
		
		JPanel pCenter = new JPanel();
		pCenter.add(btnAdd = new JButton("Thêm"));
		pCenter.add(btnRS = new JButton("Xóa rỗng"));
		pCenter.add(btnUpdate = new JButton("Sửa"));
		pCenter.add(btnRemove = new JButton("Xóa"));
		pCenter.add(btnSave = new JButton("Lưu"));
		pCenter.add(Box.createRigidArea(new Dimension(50, 10)));
		pCenter.add(new JLabel("Tìm theo mã sách: "));
		String[] mang = {};
		pCenter.add(cbMaSach = new JComboBox<>(mang));
		cbMaSach.setPreferredSize(new Dimension(100, 30));
		pCenter.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new BorderLayout());
		pSouth.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		String header[] = {"Mã sách", "Tựa sách", "Tác giả",
				"Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá", "ISBN"};
		tbModel = new DefaultTableModel(header, 0);
		table = new JTable(tbModel);
		table.setRowHeight(30);
		pSouth.add(scroll = new JScrollPane(table), BorderLayout.NORTH);
		scroll.setPreferredSize(new Dimension(0, 250));
		
		bookList = new Sach_Collection();
		
		bookList.napDuLieuTuFile();
		
		updateTableData();
		updateComboBoxData();
		
		pContain.add(pNorth, BorderLayout.NORTH);
		pContain.add(pCenter, BorderLayout.CENTER);
		pContain.add(pSouth, BorderLayout.SOUTH);
		add(pContain);
		
		btnAdd.addActionListener(this);
		btnRS.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnRemove.addActionListener(this);
		btnSave.addActionListener(this);
		table.addMouseListener(this);
		cbMaSach.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new GUI_Sach().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		Sach s = bookList.getElement(row);
		txtMaSach.setText(s.getMaSach());
        txtTuaSach.setText(s.getTuaSach());
        txtTacGia.setText(s.getTacGia());
        txtNamXB.setText(String.valueOf(s.getNamXuatBan()));
        txtNhaXB.setText(String.valueOf(s.getNhaXuatBan()));
        txtSoTrang.setText(String.valueOf(s.getSoTrang()));
        txtDonGia.setText(String.valueOf(s.getDonGia()));
        txtISBN.setText(s.getiSBN());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(cbMaSach)) {
			String maSach = (String) cbMaSach.getSelectedItem();
			Sach book = bookList.timkiem(maSach);
			if(book != null) {
				int index = bookList.getList().indexOf(book);
				fillForm(index);
				table.getSelectionModel().setSelectionInterval(index, index);
				table.scrollRectToVisible(table.getCellRect(index, index, true));
			}
		} else if(obj.equals(btnAdd)) {
			if(validData()) {
				Sach s = revertSachTextField();
				if(bookList.themSach(s)) {
					lbMess.setText("Thêm thành công");
					updateTableData();
					updateComboBoxData();
				} else {
					showMessage("Trùng mã", txtMaSach);
				}
			}
		} else if(obj.equals(btnRS)) {
			clearTextField();
		} else if(obj.equals(btnRemove)) {
			int row = table.getSelectedRow();
			if(row != -1) {
				int alert = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?", 
						"Chú ý", JOptionPane.YES_NO_OPTION);
				if(alert == JOptionPane.YES_OPTION){
					tbModel.removeRow(row);
					Sach s = bookList.getElement(row);
					bookList.xoaSach(s);
					lbMess.setText("Đã xóa 1 sách");
					updateTableData();
					updateComboBoxData();
					clearTextField();
				}
			} else JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa!");
		} else if(obj.equals(btnUpdate)) {
			 String maSach = txtMaSach.getText().trim();
			 if(validData()) {
				 Sach newBook = revertSachTextField();
				 if(bookList.updateSach(maSach, newBook)) {
					 lbMess.setText("Cập nhật thành công!");
					 updateTableData();
					 int index = bookList.getList().indexOf(newBook);
					 table.setRowSelectionInterval(index, index);
				 } else lbMess.setText("Chọn sách để cập nhật!");
			 }
		} else if(obj.equals(btnSave)) {
			LuuTru.ghiFile(bookList.getList());
			lbMess.setText("Lưu thành công!");
		}
	}
	
	private void fillForm(int row) {
		if(row != -1) {
			String maSach = (String) table.getValueAt(row, 0);
			Sach book = new Sach(maSach);
			ArrayList<Sach> dsSach = bookList.getList();
			if(bookList.getList().contains(book)) {
				book = dsSach.get(dsSach.indexOf(book));
				txtMaSach.setText(book.getMaSach());
				txtTuaSach.setText(book.getTuaSach());
				txtTacGia.setText(book.getTacGia());
				txtNhaXB.setText(book.getNhaXuatBan());
				txtNamXB.setText(book.getNamXuatBan() + "");
				txtSoTrang.setText(book.getSoTrang() + "");
				txtDonGia.setText(book.getDonGia() + "");
				txtISBN.setText(book.getiSBN());
				txtMaSach.setEditable(false);
			}
		}
	}
	
	private void updateComboBoxData() {
		int n = bookList.getSize();
		String[] items = new String[n];
		int i = 0;
		for(Sach book : bookList.getList()) {
			items[i] = book.getMaSach();
			i++;
		}
		cbMaSach.setModel(new DefaultComboBoxModel<String>(items));
	}
	
	private void updateTableData() {
		tbModel.setRowCount(0);
		for(Sach book : bookList.getList()) {
			Object[] rowData = { book.getMaSach(), book.getTuaSach(),
					book.getTacGia(), book.getNamXuatBan(), book.getNhaXuatBan(),
					book.getSoTrang(), book.getDonGia(), book.getiSBN()};
			tbModel.addRow(rowData);
		}
	}
	
	private void clearTextField() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtNhaXB.setText("");
		txtDonGia.setText("");
		txtSoTrang.setText("");
		txtISBN.setText("");
		txtMaSach.setEditable(true);
		txtMaSach.requestFocus();
	}
	
	private void showMessage(String mes, JTextField txt) {
		txt.requestFocus();
		txt.setText(mes);
	}
	
	private boolean validData() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String namXB = txtNamXB.getText().trim();
		String soTrang = txtSoTrang.getText().trim();
		String donGia = txtDonGia.getText().trim();
		String iSBN = txtISBN.getText().trim();
		
		if(!(maSach.length() > 0 && maSach.matches("[A-Z]\\d{3}"))) {
			JOptionPane.showMessageDialog(this, 
					"Error: Mã sách phải theo định dạng bắt đầu với kí tự in hoa và 3 kí tự số!");
			return false;
		}
		
		if(!(tuaSach.length() > 0 && tuaSach.matches("[a-zA-Z' ]+"))) {
			JOptionPane.showMessageDialog(this, "Error: Tựa sách phải theo đúng định dạng");
			return false;
		}
		
		if(!(tacGia.length() > 0 && tacGia.matches("([A-Z][a-z]*)+( [A-Z][a-z]*)+"))) {
			JOptionPane.showMessageDialog(this, "Error: Tác giả phải theo đúng định dạng");
			return false;
		}
		
		if(namXB.length() > 0) {
			int x = Integer.parseInt(namXB);
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			try {
				if(!(x >= 1900 && x < currentYear)) {
					JOptionPane.showMessageDialog(this, "Error: >= 1900 < curentYear");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error: Năm xuất bản phải nhập số");
				return false;
			}
		}
		
		if(soTrang.length() > 0) {
			try {
				int x = Integer.parseInt(soTrang);
				if(x <= 0) {
					JOptionPane.showMessageDialog(this, "Error: Số trang phải nhập số dương");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error: Số trang phải nhập số");
				return false;
			}
		}
		
		if(donGia.length() > 0) {
			try {
				double y = Double.parseDouble(donGia);
				if(y <= 0) {
					JOptionPane.showMessageDialog(this, "Error: Đơn giá phải nhập số dương");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error: Đơn giá phải nhập số");
				return false;
			}
		}
		
		if(!(iSBN.length() > 0 && iSBN.matches("\\d{1,4}(-\\d{1,4}){3,4}"))) {
			JOptionPane.showMessageDialog(this, 
					"Error: ISBN phải đúng định dạng X-X-X-X hoặc X-X-X-X-X");
			return false;
		}
		
		return true;
	}
	
	private Sach revertSachTextField() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		
		String namXB = txtNamXB.getText().trim();
		int nam = namXB.length() == 0 ? 0 : Integer.parseInt(namXB);
		
		String nhaXB = txtNhaXB.getText().trim();
		
		String soTrang = txtSoTrang.getText().trim();
		int trang = soTrang.length() == 0 ? 0 : Integer.parseInt(soTrang);
		
		String donGia = txtDonGia.getText().trim();
		double gia = donGia.equals("") ? 0 : Double.parseDouble(donGia);
		
		String iSBN = txtISBN.getText().trim();
		return new Sach(maSach, tuaSach, tacGia, nam, nhaXB, trang, gia, iSBN);
	}
}
