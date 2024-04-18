package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connect.ConnectionDB;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_dao {
	
	public NhanVien_dao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectionDB.getInstance();
		Connection con = ConnectionDB.getConnection();
		try {
			PreparedStatement sm = con.prepareStatement("SELECT * FROM NhanVien");
			ResultSet rs = sm.executeQuery();
			
			while(rs.next()) {
				String maNV = rs.getString("maNV");
				String ho = rs.getString("ho");
				String ten = rs.getString("ten");
				int tuoi = rs.getInt("tuoi");
				boolean phai = rs.getBoolean("phai");
				double luong = rs.getDouble("tienLuong");
				PhongBan pBan = new PhongBan(rs.getString("maPhong"));
				NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, phai, luong, pBan);
				dsNV.add(nv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public boolean create(NhanVien nv) {
		ConnectionDB.getInstance();
		Connection con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getManNV());
			stmt.setString(2, nv.getHo());
			stmt.setString(3, nv.getTen());
			stmt.setInt(4, nv.getTuoi());
			stmt.setBoolean(5, nv.isPhai());
			stmt.setDouble(6, nv.getTienLuong());
			stmt.setString(7, nv.getpBan().getMaPhong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean update(NhanVien nv) {
		ConnectionDB.getInstance();
		Connection con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;		
		try {
			stmt = con.prepareStatement("update NhanVien set ho = ?, ten = ?, tuoi = ?, phai = ?, tienLuong = ?, maPhong = ? where maNV = ?");
			stmt.setString(1, nv.getManNV());
			stmt.setString(2, nv.getHo());
			stmt.setString(3, nv.getTen());
			stmt.setInt(4, nv.getTuoi());
			stmt.setBoolean(5, nv.isPhai());
			stmt.setDouble(6, nv.getTienLuong());
			stmt.setString(7, nv.getpBan().getMaPhong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return n > 0;
	}
	
	public ArrayList<NhanVien> getNhanVienByMaNV(String maNV) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectionDB.getInstance();
		PreparedStatement stmt = null;
		Connection con = ConnectionDB.getConnection();
		try {
			stmt = con.prepareStatement("select * from NhanVien where maNV = ?");
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				PhongBan pBan = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, pBan);
				dsNV.add(nv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsNV;
	}
	
	public ArrayList<NhanVien> getNhanVienByPhong(String maPB) {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectionDB.getInstance();
		Connection con = ConnectionDB.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from NhanVien where maPhong = ?");
			stmt.setString(1, maPB);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ho = rs.getString(2);
				String ten = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				double luong = rs.getDouble(6);
				PhongBan pBan = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong, pBan);
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public boolean deleteNV(String maNV) {
		ConnectionDB.getInstance();
		Connection con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete NhanVien where maNV = ?");
			stmt.setString(1, maNV);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
